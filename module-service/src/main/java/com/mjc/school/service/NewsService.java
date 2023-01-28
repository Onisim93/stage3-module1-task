package com.mjc.school.service;

import com.mjc.school.repository.impl.AuthorRepository;
import com.mjc.school.repository.impl.NewsRepository;
import com.mjc.school.repository.entity.News;
import com.mjc.school.service.dto.NewsDTO;
import com.mjc.school.service.exception.InvalidDataException;
import com.mjc.school.service.exception.NoSuchEntityException;
import com.mjc.school.service.exception.ErrorNotification;
import com.mjc.school.service.mapper.NewsMapper;
import com.mjc.school.service.validation.NewsValidator;

import java.util.List;


public class NewsService implements AbstractService<NewsDTO> {
    private final NewsRepository newsRepository = NewsRepository.getInstance();
    private final AuthorRepository authorRepository = AuthorRepository.getInstance();

    @Override
    public NewsDTO create(NewsDTO entity) {
        ErrorNotification errorNotification = NewsValidator.validate(entity);
        if (errorNotification.hasErrors()) {
            throw new InvalidDataException(errorNotification.getErrorList().toString());
        }
        if (authorRepository.get(entity.getAuthorId()) == null) {
            throw new NoSuchEntityException("Author with id " + entity.getAuthorId() + " does not exist.");
        }

        News created = newsRepository.create(NewsMapper.INSTANCE.toEntity(entity));
        return NewsMapper.INSTANCE.toDto(created);
    }

    @Override
    public List<NewsDTO> getAll() {
        return NewsMapper.INSTANCE.toListDto(newsRepository.getAll());
    }

    @Override
    public NewsDTO get(long id) throws NoSuchEntityException{
        News entity = newsRepository.get(id);
        if (entity == null) {
            throw new NoSuchEntityException("News with id " + id + " does not exist.");
        }
        return NewsMapper.INSTANCE.toDto(newsRepository.get(id));
    }

    @Override
    public boolean delete(long id) {
        if (!newsRepository.delete(id)) {
            throw new NoSuchEntityException("News with id " + id + " does not exist.");
        }
        return true;
    }

    @Override
    public NewsDTO update(NewsDTO entity) {
        News updated = newsRepository.get(entity.getId());
        if (updated == null) {
            throw new NoSuchEntityException("News with id " + entity.getId() + " does not exist.");
        }

        if (authorRepository.get(entity.getAuthorId()) == null) {
            throw new NoSuchEntityException("Author with id " + entity.getAuthorId() + " does not exist.");
        }

        ErrorNotification errorNotification = NewsValidator.validate(entity);
        if (errorNotification.hasErrors()) {
            throw new InvalidDataException(errorNotification.getErrorList().toString());
        }

        entity.setCreateDate(updated.getCreateDate());

        return NewsMapper.INSTANCE.toDto(newsRepository.update(NewsMapper.INSTANCE.toEntity(entity)));
    }
}
