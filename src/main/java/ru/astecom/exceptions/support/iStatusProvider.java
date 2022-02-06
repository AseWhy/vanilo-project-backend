package ru.astecom.exceptions.support;

import org.springframework.http.HttpStatus;

public interface iStatusProvider {
    HttpStatus getStatus();
}
