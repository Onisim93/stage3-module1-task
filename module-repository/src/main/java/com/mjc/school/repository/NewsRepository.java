package com.mjc.school.repository;

import com.mjc.school.repository.entity.News;
import com.mjc.school.repository.util.SequenceGenerator;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class NewsRepository implements CrudRepository<News> {
    private static NewsRepository repository;

    private Map<Long, News> dataSource;

    private NewsRepository() {
        dataSource = new ConcurrentHashMap<>();
    }

    public static NewsRepository getRepository() {
        if (repository == null) {
            repository = new NewsRepository();
        }

        return repository;
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
