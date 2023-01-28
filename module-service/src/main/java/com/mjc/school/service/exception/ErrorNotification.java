package com.mjc.school.service.exception;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class ErrorNotification {
    private final StringBuilder errorList;

    public ErrorNotification() {
        errorList = new StringBuilder();
    }

    public void addError(String error) {
        errorList.append(error).append("\n");
    }

    public boolean hasErrors() {
        return errorList.length() != 0;
    }

}
