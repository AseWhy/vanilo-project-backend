package ru.astecom.exceptions.base;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import ru.astecom.exceptions.support.iFullErrorInfoProvider;

@Getter
public class CustomException extends RuntimeException implements iFullErrorInfoProvider {
    private final HttpStatus status;
    private final Integer code;
    private final String message;

    public CustomException(String message, HttpStatus status, Integer code) {
        this.status = status;
        this.code = code;
        this.message = message;
    }

    public CustomException(String message, HttpStatus status) {
        this.status = status;
        this.code = 0;
        this.message = message;
    }

    public CustomException(String message) {
        this.status = HttpStatus.BAD_REQUEST;
        this.code = 0;
        this.message = message;
    }
}
