package com.formation.app.dao.jdbc;

import com.formation.app.dao.PlaceDao;
import com.formation.app.model.Place;
import com.formation.app.model.Trip;

import javax.swing.plaf.nimbus.State;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JdbcPlaceDao extends JdbcDao implements PlaceDao<Place> {

    public JdbcPlaceDao() {
        this.connection = this.getConnection();
    }

    @Override
    public Place create(Place p) {
        String query = "INSERT INTO places (name, ID) VALUES(?,?)";
        try (PreparedStatement pst = this.connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            pst.setString(1, p.getName());
            pst.setObject(2, p.getID());
            pst.execute();

            // Fetching generated id from database during insert
            ResultSet resultSet = pst.getGeneratedKeys();
            resultSet.next();
            Long id = resultSet.getLong(1);

            p.setID(id);

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
        return p;
    }

    @Override
    public List<Place> findAll() {
        List<Place> placeList = new ArrayList<>();

        String query = "SELECT * FROM places";
        try (Statement st = this.connection.createStatement()) {
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                placeList.add(mapToPlace(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return placeList;
    }




    @Override
    public boolean update(Place p) {
        String query = "UPDATE places SET name= ? WHERE id=?";
        try (PreparedStatement pst = this.connection.prepareStatement(query)) {
            pst.setString(1, p.getName());
            pst.setLong(2, p.getID());

            pst.executeUpdate();

            connection.commit();

        } catch (SQLException e1) {
            e1.printStackTrace();
            try {
                connection.rollback();
            } catch (SQLException e2) {
                e2.printStackTrace();
            }
        }
        return true;
    }

    @Override
    public Place findById(Long ID) {
        String query = "SELECT * FROM places WHERE id = ?";
        Place foundPlace = null;
        try (PreparedStatement pst = this.connection.prepareStatement(query)) {
            pst.setLong(1, ID);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                foundPlace = mapToPlace(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return foundPlace;
    }

    @Override
    public boolean delete(Long id) {
        return super.delete(id,"places");
    }

    @Override
    public void pleaseImpMe() {
        System.out.println("Hello place");
    }

    private Place mapToPlace(ResultSet rs) throws SQLException{
        return new Place(rs.getLong("ID"),rs.getString("Name"));
    }
}
