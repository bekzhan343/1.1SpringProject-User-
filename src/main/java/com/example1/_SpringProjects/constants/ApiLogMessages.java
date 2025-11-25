package com.example1._SpringProjects.constants;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ApiLogMessages {
    USER_INFO_BY_ID("RECEIVING USER BY ID: %s"),

    GET_CURRENT_METHOD_NAME("log{CURRENT METHOD NAME: {}}");
    private final String value;

}
