package com.mjc.school.repository;

import java.util.List;

public interface Repository<E> {

    E create(E entity);

    E readById(Long id);

    List<E> readAll();

    E update (E entity);

    Boolean delete (Long id);
}
