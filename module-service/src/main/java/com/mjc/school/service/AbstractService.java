package com.mjc.school.service;

import java.util.List;

public interface AbstractService<E> {
    E create (E entity);

    List<E> readAll();

    E readById(Long id);

    Boolean delete (Long id);

    E update (E entity);

}
