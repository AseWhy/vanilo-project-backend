package ru.astecom.secure;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;
import ru.astecom.RestExceptionHandler;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class JwtFilter extends GenericFilterBean {
    public static final String AUTHORIZATION = "Authorization";

    @Autowired
    protected JwtProvider jwtProvider;
    @Autowired
    protected AuthService authService;
    @Autowired
    protected RestExceptionHandler restExceptionHandler;
    @Autowired
    protected ObjectMapper objectMapper;

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws ServletException, IOException {
        var request = (HttpServletRequest) servletRequest;
        var response = (HttpServletResponse) servletResponse;
        var token = getTokenFromRequest(request);

        try {
            if (token != null && jwtProvider.validateToken(token)) {
                var userLogin = jwtProvider.getLoginFromToken(token);
                var customUserDetails = authService.loadUserByUsername(userLogin);
                var auth = new UsernamePasswordAuthenticationToken(customUserDetails, null, customUserDetails.getAuthorities());

                SecurityContextHolder.getContext().setAuthentication(auth);
            }
        } catch (RuntimeException e) {
            var error = restExceptionHandler.handleServiceException(e, request);

            response.setStatus(error.getStatusCodeValue());
            response.getWriter().write(objectMapper.writeValueAsString(error.getBody()));

            return;
        }

        filterChain.doFilter(servletRequest, servletResponse);
    }

    private @Nullable String getTokenFromRequest(@NotNull HttpServletRequest request) {
        var bearer = request.getHeader(AUTHORIZATION);

        if (bearer != null && bearer.length() > 7 && bearer.startsWith("Bearer ")) {
            return bearer.substring(7);
        }

        return null;
    }
}