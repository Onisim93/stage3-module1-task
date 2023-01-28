package com.mjc.school.repository.impl;

import com.mjc.school.repository.CrudRepository;
import com.mjc.school.repository.entity.NewsModel;
import com.mjc.school.repository.source.DataSource;
import com.mjc.school.repository.util.SequenceGenerator;

import java.util.List;

public class NewsRepository implements CrudRepository<NewsModel> {

    private final DataSource dataSource;

    public NewsRepository() {
        dataSource = DataSource.getInstance();
    }



    @Override
    public NewsModel create(NewsModel entity) {
        entity.setId(SequenceGenerator.getNextSequence());
        return dataSource.getNewsMap().putIfAbsent(entity.getId(), entity) == null ? entity : null;
    }

    @Override
    public NewsModel readById(long id) {
        return dataSource.getNewsMap().get(id);
    }

    @Override
    public List<NewsModel> readAll() {
        return List.copyOf(dataSource.getNewsMap().values());
    }

    @Override
    public NewsModel update(NewsModel entity) {
        return dataSource.getNewsMap().computeIfPresent(entity.getId(), (key, value) -> entity);
    }

    @Override
    public Boolean delete(long id) {
        return dataSource.getNewsMap().remove(id) != null;
    }
}
