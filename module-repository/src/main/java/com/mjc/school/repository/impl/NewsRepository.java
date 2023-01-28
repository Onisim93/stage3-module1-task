package com.mjc.school.repository.impl;

import com.mjc.school.repository.CrudRepository;
import com.mjc.school.repository.entity.News;
import com.mjc.school.repository.util.SequenceGenerator;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class NewsRepository implements CrudRepository<News> {
    private static NewsRepository instance;

    private Map<Long, News> dataSource;

    private NewsRepository() {
        dataSource = new ConcurrentHashMap<>();
    }

    public static NewsRepository getInstance() {
        if (instance == null) {
            instance = new NewsRepository();
        }

        return instance;
    }


    @Override
    public News create(News entity) {
        entity.setId(SequenceGenerator.getNextSequence());
        return dataSource.putIfAbsent(entity.getId(), entity) == null ? entity : null;
    }

    @Override
    public News get(long id) {
        return dataSource.get(id);
    }

    @Override
    public List<News> getAll() {
        return List.copyOf(dataSource.values());
    }

    @Override
    public News update(News entity) {
        return dataSource.computeIfPresent(entity.getId(), (key, value) -> entity);
    }

    @Override
    public boolean delete(long id) {
        return dataSource.remove(id) != null;
    }
}
