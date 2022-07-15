package org.example.security;

public enum UserTypeEnum {
    COSTUMER("COSTUMER"),
    RESTAURANT("RESTAURANT");

    private final String value;

    UserTypeEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
