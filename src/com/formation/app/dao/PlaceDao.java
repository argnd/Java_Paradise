package com.formation.app.dao;

import java.util.List;

public interface PlaceDao<T> extends CrudDao<Long, T>{

    Boolean create(T place);

    T findById(Long id);

    List<T> findAll();

    Boolean update(T place);

    Boolean delete(Long id);

}
