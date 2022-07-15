package org.example.rest.response;

public enum StatusResponse {
    SUCCESS("success"),
    FAILURE("failure");

    private final String value;

    StatusResponse(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
