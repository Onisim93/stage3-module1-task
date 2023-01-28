package com.mjc.school.repository;

import com.mjc.school.repository.entity.AbstractBaseEntity;

import java.util.List;

public interface CrudRepository<E extends AbstractBaseEntity> {

    E create(E entity);

    E get (long id);

    List<E> getAll();

    E update (E entity);

    boolean delete (long id);
}
