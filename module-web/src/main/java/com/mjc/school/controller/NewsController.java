package com.mjc.school.controller;

import com.mjc.school.service.AbstractService;
import com.mjc.school.service.NewsService;
import com.mjc.school.service.dto.NewsDTO;

import java.util.List;

public class NewsController implements CrudController<NewsDTO> {
    private static NewsController instance;
    private AbstractService<NewsDTO> service;
    public NewsController(AbstractService<NewsDTO> service) {
        this.service = service;
    }

    public static NewsController getInstance() {
        if (instance == null) {
            instance = new NewsController(new NewsService());
        }

        return instance;
    }

    @Override
    public NewsDTO create(NewsDTO entity) {
        return service.create(entity);
    }

    @Override
    public NewsDTO update(NewsDTO entity) {
        return service.update(entity);
    }

    @Override
    public NewsDTO get(long id) {
        return service.get(id);
    }

    @Override
    public List<NewsDTO> getAll() {
        return service.getAll();
    }

    @Override
    public Boolean delete(long id) {
        return service.delete(id);
    }
}
