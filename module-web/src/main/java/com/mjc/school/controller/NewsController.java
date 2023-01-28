package com.mjc.school.controller;

import com.mjc.school.service.AbstractService;
import com.mjc.school.service.impl.NewsService;
import com.mjc.school.service.dto.NewsDto;

import java.util.List;

public class NewsController implements CrudController<NewsDto> {
    private static NewsController instance;
    private AbstractService<NewsDto> service;
    public NewsController(AbstractService<NewsDto> service) {
        this.service = service;
    }

    public static NewsController getInstance() {
        if (instance == null) {
            instance = new NewsController(new NewsService());
        }

        return instance;
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
    public NewsDto get(long id) {
        return service.readById(id);
    }

    @Override
    public List<NewsDto> getAll() {
        return service.readAll();
    }

    @Override
    public Boolean delete(long id) {
        return service.delete(id);
    }
}
