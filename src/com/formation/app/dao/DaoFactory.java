package com.formation.app.dao;


import com.formation.app.dao.jdbc.JdbcPlaceDao;
import com.formation.app.dao.jdbc.JdbcTripDao;

public class DaoFactory {

    public static JdbcPlaceDao createPlaceDao(){
        return new JdbcPlaceDao();
    }

    public static JdbcTripDao createTripDao(){
        return new JdbcTripDao();
    }

}
