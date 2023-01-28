package com.mjc.school.service.exception;

public class NoSuchEntityException extends RuntimeException{

    public NoSuchEntityException(String message) {
        super(message);
    }

    public String getERROR_CODE() {
        return "ERROR_CODE: 000001";
    }
}
