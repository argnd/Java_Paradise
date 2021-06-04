package com.formation.app.dao;

import java.sql.SQLException;
import java.util.List;

public interface CrudDao<ID, T> {

    Boolean create(T o);

    T findById(ID id);

    List<T> findAll();

    boolean update(T o);

    boolean delete(ID id);

}
