package com.formation.app.dao;

import com.formation.app.dao.jdbc.JdbcDao;

import java.sql.SQLException;
import java.util.List;

public interface PlaceDao<T> extends CrudDao<Long, T>{

    T create(T place);

    T findById(Long ID);

    List<T> findAll() throws SQLException;

    boolean update(T place);

    boolean delete(Long id);

}
