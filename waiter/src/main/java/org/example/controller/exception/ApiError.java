package org.example.controller.exception;

import lombok.Data;

import java.util.Collections;
import java.util.List;

@Data
public class ApiError {
    private List<String> errors;

    public ApiError(List<String> errors) {
        this.errors = errors;
    }

    public ApiError(String message) {
        this.errors = Collections.singletonList(message);
    }
}
