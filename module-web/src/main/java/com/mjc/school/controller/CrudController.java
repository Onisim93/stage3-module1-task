package com.mjc.school.controller;

import java.util.List;

public interface CrudController<E> {

    E create(E entity);

    E update(E entity);

    E get(long id);

    List<E> getAll();

    Boolean delete(long id);



}
