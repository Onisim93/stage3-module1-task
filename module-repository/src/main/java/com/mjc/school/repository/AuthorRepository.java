package com.mjc.school.repository;

import com.mjc.school.repository.entity.Author;
import com.mjc.school.repository.util.SequenceGenerator;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


public class AuthorRepository implements CrudRepository<Author> {

    private static AuthorRepository repository;
    private Map<Long, Author> dataSource;

    private AuthorRepository() {
        dataSource = new ConcurrentHashMap<>();
    }

    public static AuthorRepository getRepository() {
        if (repository == null) {
            repository = new AuthorRepository();
        }


        return repository;
    }

    @Override
    public Author create(Author entity) {
        entity.setId(SequenceGenerator.getNextSequence());
        return dataSource.putIfAbsent(entity.getId(), entity) == null ? entity : null;
    }

    @Override
    public Author get(long id) {
        return dataSource.get(id);
    }

    @Override
    public List<Author> getAll() {
        return List.copyOf(dataSource.values());
    }

    @Override
    public Author update(Author entity) {
        return dataSource.computeIfPresent(entity.getId(), (key, value) -> entity);
    }

    @Override
    public boolean delete(long id) {
        return dataSource.remove(id) != null;
    }
}
