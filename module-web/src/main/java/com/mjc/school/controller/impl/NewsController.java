package com.mjc.school.controller.impl;

import com.mjc.school.controller.Controller;
import com.mjc.school.service.Service;
import com.mjc.school.service.dto.NewsDto;

import java.util.List;

public class NewsController implements Controller<NewsDto> {
    private final Service<NewsDto> service;
    public NewsController(Service<NewsDto> service) {
        this.service = service;
    }

    @Override
    public NewsDto create(NewsDto entity) {
        return service.create(entity);
    }

    @Override
    public NewsDto update(NewsDto entity) {
        return service.update(entity);
    }

    @Override
    public NewsDto readById(Long id) {
        return service.readById(id);
    }

    @Override
    public List<NewsDto> readAll() {
        return service.readAll();
    }

    @Override
    public Boolean delete(Long id) {
        return service.delete(id);
    }
}
