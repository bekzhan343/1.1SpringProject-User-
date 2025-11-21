package com.example1._SpringProjects.constants;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ApiLogMessages {
    USER_INFO_BY_ID("RECEIVING USER BY ID: %s");

    private final String message;

    public String getMessage(Object... args) {
        return String.format(message, args);
    }
}
