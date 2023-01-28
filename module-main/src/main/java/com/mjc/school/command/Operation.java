package com.mjc.school.command;

public enum Operation {
    EXIT("0 - Exit."),
    GET_ALL("1 - Get all news."),
    GET("2 - Get news by id."),
    CREATE("3 - Create news."),
    UPDATE("4 - Update news."),
    DELETE("5 - Remove news by id.");

    private String description;
    Operation(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
