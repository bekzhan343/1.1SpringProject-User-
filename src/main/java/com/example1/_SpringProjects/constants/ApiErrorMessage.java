package com.example1._SpringProjects.constants;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ApiErrorMessage {

    USER_INFO_NOT_FOUND("USER WITH ID->%s NOT FOUND!");

    private final String errorMessage;

    public String getErrorMessage(Object... args) {
        return String.format(errorMessage,args);
    }
}
