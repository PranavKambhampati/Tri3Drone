package com.example.demo.sqlite.models;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@Getter
@Setter
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class UserNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 1L;
    private String errorAlert;
    public UserNotFoundException(String errorAlert) {
        this.errorAlert = errorAlert;
    }
}
