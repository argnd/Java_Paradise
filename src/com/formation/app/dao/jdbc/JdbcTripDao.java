package com.formation.app.dao.jdbc;

import com.formation.app.dao.TripDao;
import com.formation.app.model.Place;
import com.formation.app.model.Trip;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JdbcTripDao extends JdbcDao implements TripDao<Trip, Place> {

    public JdbcTripDao() {
        this.connection = this.getConnection();
    }

    @Override
    public Boolean create(Trip t) {
        int isCreated  = 0;
        String query = "INSERT INTO trips (name, ID,destId,dptId) VALUES(?,?,?,?)";
        try (PreparedStatement pst = this.connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            pst.setString(1, t.getName());
            pst.setObject(2, t.getID());
            pst.setObject(3, t.getDpt_id());
            pst.setObject(4, t.getArrival_id());
            isCreated = pst.executeUpdate();

            // Fetching generated id from database during insert
            ResultSet resultSet = pst.getGeneratedKeys();
            resultSet.next();
            Long id = resultSet.getLong(1);

            t.setID(id);

            this.connection.commit();

        } catch (SQLException e1) {
            System.out.println("mauvaise ID");
            e1.printStackTrace();
            try {
                this.connection.rollback();
            } catch (SQLException e2) {
                e2.printStackTrace();
            }
        }
        return isCreated > 0;
    }

    @Override
    public Trip findById(Long ID) {
        String query = "SELECT * FROM trips WHERE id = ?";
        Trip foundtrip = null;
        try (PreparedStatement pst = this.connection.prepareStatement(query)) {
            pst.setLong(1, ID);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                foundtrip = mapToTrip(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return foundtrip;
    }

    @Override
    public List<Trip> findAll() {
        List<Trip> tripList = new ArrayList<>();

        String query = "SELECT * FROM Trips";
        try (Statement st = this.connection.createStatement()) {
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                tripList.add(mapToTrip(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tripList;
    }

    @Override
    public Boolean update(Trip t) {
        int isUpdated = 0;
        String query = "UPDATE trips SET name= ?,destId = ?, dptId = ?  WHERE id=?";
        try (PreparedStatement pst = this.connection.prepareStatement(query)) {
            pst.setString(1, t.getName());
            pst.setLong(2, t.getArrival_id());
            pst.setLong(3, t.getDpt_id());
            pst.setLong(4, t.getID());

            isUpdated = pst.executeUpdate();

            connection.commit();

        } catch (SQLException e1) {
            e1.printStackTrace();
            try {
                connection.rollback();
            } catch (SQLException e2) {
                e2.printStackTrace();
            }
        }
        return isUpdated > 0;
    }

    @Override
    public Boolean delete(Long id) {
        return super.delete(id,"trips");
    }

    @Override
    public List<Trip> findByDest(Place place) {
        return null;
    }

    @Override
    public List<Trip> findByDeparture(Place place) {
        return null;
    }

    @Override
    public void pleaseImpMe() {
        System.out.println("Hello trip");
    }

    private Trip mapToTrip(ResultSet rs)throws SQLException{
        return new Trip(rs.getLong(1),rs.getString(2),
                rs.getLong(4),rs.getLong(3));
    }
}
