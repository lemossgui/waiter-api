package org.example.rest.controller.response;

public enum ResponseStatus {
    SUCCESS("success"),
    FAILURE("failure");

    private final String value;

    ResponseStatus(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
