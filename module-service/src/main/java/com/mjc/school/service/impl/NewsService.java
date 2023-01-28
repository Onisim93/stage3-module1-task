package com.mjc.school.service.impl;

import com.mjc.school.repository.Repository;
import com.mjc.school.repository.impl.NewsRepository;
import com.mjc.school.repository.entity.NewsModel;
import com.mjc.school.service.Service;
import com.mjc.school.service.dto.NewsDto;
import com.mjc.school.service.exception.InvalidDataException;
import com.mjc.school.service.exception.NoSuchEntityException;
import com.mjc.school.service.exception.ErrorNotification;
import com.mjc.school.service.mapper.NewsMapper;
import com.mjc.school.service.validation.NewsValidator;

import java.util.List;


public class NewsService implements Service<NewsDto> {
    private final String NO_SUCH_ENTITY_MSG = "%s with id %d does not exist.";
    private final Repository<NewsModel> newsRepository;
    private final NewsValidator newsValidator;

    public NewsService() {
        newsRepository = new NewsRepository();
        newsValidator = new NewsValidator();
    }

    @Override
    public NewsDto create(NewsDto entity) {
        ErrorNotification errorNotification = newsValidator.validate(entity);
        if (errorNotification.hasErrors()) {
            throw new InvalidDataException(errorNotification.getErrorList().toString());
        }
        NewsModel created = newsRepository.create(NewsMapper.INSTANCE.toEntity(entity));
        return NewsMapper.INSTANCE.toDto(created);
    }

    @Override
    public List<NewsDto> readAll() {
        return NewsMapper.INSTANCE.toListDto(newsRepository.readAll());
    }

    @Override
    public NewsDto readById(Long id) throws NoSuchEntityException{
        NewsModel entity = newsRepository.readById(id);
        if (entity == null) {
            throw new NoSuchEntityException(String.format(NO_SUCH_ENTITY_MSG, "News", id));
        }
        return NewsMapper.INSTANCE.toDto(newsRepository.readById(id));
    }

    @Override
    public Boolean delete(Long id) {
        if (!newsRepository.delete(id)) {
            throw new NoSuchEntityException(String.format(NO_SUCH_ENTITY_MSG, "News", id));
        }
        return true;
    }

    @Override
    public NewsDto update(NewsDto entity) {
        NewsModel updated = newsRepository.readById(entity.getId());
        if (updated == null) {
            throw new NoSuchEntityException(String.format(NO_SUCH_ENTITY_MSG, "News", entity.getId()));
        }

        ErrorNotification errorNotification = newsValidator.validate(entity);
        if (errorNotification.hasErrors()) {
            throw new InvalidDataException(errorNotification.getErrorList().toString());
        }

        entity.setCreateDate(updated.getCreateDate());

        return NewsMapper.INSTANCE.toDto(newsRepository.update(NewsMapper.INSTANCE.toEntity(entity)));
    }
}
