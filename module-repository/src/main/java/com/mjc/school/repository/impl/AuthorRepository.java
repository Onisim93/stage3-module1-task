package com.mjc.school.repository.impl;

import com.mjc.school.repository.CrudRepository;
import com.mjc.school.repository.entity.AuthorModel;
import com.mjc.school.repository.source.DataSource;
import com.mjc.school.repository.util.SequenceGenerator;

import java.util.List;


public class AuthorRepository implements CrudRepository<AuthorModel> {
    private final DataSource dataSource;

    public AuthorRepository() {
        dataSource = DataSource.getInstance();
    }

    @Override
    public AuthorModel create(AuthorModel entity) {
        entity.setId(SequenceGenerator.getNextSequence());
        return dataSource.getAuthorMap().putIfAbsent(entity.getId(), entity) == null ? entity : null;
    }

    @Override
    public AuthorModel readById(long id) {
        return dataSource.getAuthorMap().get(id);
    }

    @Override
    public List<AuthorModel> readAll() {
        return List.copyOf(dataSource.getAuthorMap().values());
    }

    @Override
    public AuthorModel update(AuthorModel entity) {
        return dataSource.getAuthorMap().computeIfPresent(entity.getId(), (key, value) -> entity);
    }

    @Override
    public Boolean delete(long id) {
        return dataSource.getAuthorMap().remove(id) != null;
    }
}
