package ru.astecom;

import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.ServletRequestAttributes;
import ru.astecom.exceptions.support.iCodeProvider;
import ru.astecom.exceptions.support.iStatusProvider;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.regex.Pattern;

@ControllerAdvice
public class RestExceptionHandler {
    @Value("${server.error.include-message:never}")
    protected String includeMessage;

    public ResponseEntity<Object> handleExceptionInternalSuccess(@NotNull Exception ex, Object body, HttpServletRequest request, @NotNull HttpStatus status, String scope) {
        var wrap = new HashMap<String, Object>();
        var message = ex.getMessage();
        var code = 0;

        wrap.put("timestamp", new Date());
        wrap.put("status", status.value());
        wrap.put("path", (new ServletRequestAttributes(request)).getRequest().getRequestURI());

        if(ex instanceof iCodeProvider codeProvider) {
            code = codeProvider.getCode();
        } else {
            if(message != null && message.contains("[code]: ")) {
                var matcher = Pattern.compile("\\[code]:\\s+\\[(\\d+)]").matcher(message);

                if(matcher.find()) {
                    code = Integer.parseInt(matcher.group(1));

                    message = message.replaceAll("\\s+\\[code]:\\s+\\[(\\d+)]", "");
                }
            }
        }

        if(includeMessage.equals("always") || ex instanceof RuntimeException) {
            wrap.put("message", message);
        }

        if(scope != null) {
            wrap.put(scope, body);
        }

        if(status.value() > 299 || status.value() < 200) {
            wrap.put("error", status.getReasonPhrase());
            wrap.put("code", code);
        }

        ex.printStackTrace();

        return new ResponseEntity<>(wrap, status);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> handleMethodArgumentNotValid(@NotNull MethodArgumentNotValidException ex, HttpServletRequest request) {
        var status = HttpStatus.BAD_REQUEST;
        var errors = new HashMap<String, String>();

        for(var error: ex.getBindingResult().getFieldErrors()) {
            errors.put(error.getField(), error.getDefaultMessage());
        }

        return this.handleExceptionInternalSuccess(ex, errors, request, status, "errors");
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<Object> handleServiceException(@NotNull RuntimeException ex, HttpServletRequest request) {
        var clazz = ex.getClass();
        var annotation = clazz.getAnnotation(ResponseStatus.class);
        var status = HttpStatus.BAD_REQUEST;

        if(ex instanceof UsernameNotFoundException) {
            status = HttpStatus.UNAUTHORIZED;
        } else if(ex instanceof AccessDeniedException) {
            status = HttpStatus.FORBIDDEN;
        } else if(ex instanceof iStatusProvider statusProvider) {
            status = statusProvider.getStatus();
        } else if(annotation != null) {
            status = annotation.code();
        }

        return this.handleExceptionInternalSuccess(ex, null, request, status, null);
    }
}
