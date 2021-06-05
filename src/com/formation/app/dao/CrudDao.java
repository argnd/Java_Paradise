package com.formation.app.dao;

import java.util.List;

public interface CrudDao<ID, T> {

    Boolean create(T o);

    T findById(ID id);

    List<T> findAll();

    Boolean update(T o);

    Boolean delete(ID id);

}
