package com.mjc.school.controller.impl;

import com.mjc.school.controller.Controller;
import com.mjc.school.service.Service;
import com.mjc.school.service.dto.NewsDto;

import java.util.List;

public class NewsController implements Controller<NewsDto> {
    private final Service<NewsDto> newsService;
    public NewsController(Service<NewsDto> newsService) {
        this.newsService = newsService;
    }

    @Override
    public NewsDto create(NewsDto entity) {
        return newsService.create(entity);
    }

    @Override
    public NewsDto update(NewsDto entity) {
        return newsService.update(entity);
    }

    @Override
    public NewsDto readById(Long id) {
        return newsService.readById(id);
    }

    @Override
    public List<NewsDto> readAll() {
        return newsService.readAll();
    }

    @Override
    public Boolean delete(Long id) {
        return newsService.delete(id);
    }
}
