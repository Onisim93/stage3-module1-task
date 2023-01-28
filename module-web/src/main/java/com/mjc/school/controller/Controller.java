package com.mjc.school.controller;

import com.mjc.school.service.dto.NewsDto;

import java.util.List;

public interface Controller<E extends NewsDto> {

    E create(E entity);

    E update(E entity);

    E readById(Long id);

    List<E> readAll();

    Boolean delete(Long id);



}
