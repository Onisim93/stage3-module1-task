package com.mjc.school.command;

public interface Command<E> {
    void execute(E controller);
}
