package com.formation.app.dao;

import java.util.List;

public interface TripDao<T, U> extends CrudDao<Long, T>{

    Boolean create(T trip);

    T findById(Long id);

    List<T> findAll();

    boolean update(T trip);

    boolean delete(Long id);

    List<T> findByDest(U place);

    List<T> findByDeparture(U place);

}
