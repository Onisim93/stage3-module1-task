package com.mjc.school.controller;

import java.util.List;

public interface Controller<E> {

    E create(E entity);

    E update(E entity);

    E readById(Long id);

    List<E> readAll();

    Boolean delete(Long id);



}
