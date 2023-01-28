package com.mjc.school.repository;

import com.mjc.school.repository.entity.AbstractBaseEntity;

import java.util.List;

public interface CrudRepository<E extends AbstractBaseEntity> {

    E create(E entity);

    E readById(long id);

    List<E> readAll();

    E update (E entity);

    Boolean delete (long id);
}
