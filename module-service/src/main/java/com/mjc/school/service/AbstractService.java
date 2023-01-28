package com.mjc.school.service;

import java.util.List;

public interface AbstractService<E> {
    E create (E entity);

    List<E> getAll();

    E get (long id);

    boolean delete (long id);

    E update (E entity);

}
