package com.formation.app.dao;

import java.sql.SQLException;
import java.util.List;

public interface CrudDao<ID, T> {

    T create(T object);

    T findById(ID id);

    List<T> findAll() throws SQLException;

    boolean update(T object);

    boolean delete(ID id);

}
