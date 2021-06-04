package com.formation.app.dao.jdbc;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

//public class ExampleDao implements CrudDao<Long, Fruit> {
//    @Override
//    public List<Fruit> findAll() {
//        List<Fruit> fruitList = new ArrayList<>();
//
//        String query = "SELECT * FROM fruits";
//        try (Statement st = ConnectionManager.getConnection().createStatement()) {
//            ResultSet rs = st.executeQuery(query);
//            while (rs.next()) {
//                fruitList.add(mapToFruit(rs));
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return fruitList;
//    }
//
//    private Fruit mapToFruit(ResultSet rs) throws SQLException {
//        Long id = rs.getLong("id");
//        String name = rs.getString("name");
//        LocalDate date = rs.getObject("expirationDate", LocalDate.class);
//        return new Fruit(id, name, date);
//    }
//
//
//    @Override
//    public Fruit create(Fruit fruitToCreate) {
//        Fruit createdFruit = null;
//        String query = "INSERT INTO fruits (name, expirationDate) VALUES(?,?)";
//        Connection connection = ConnectionManager.getConnection();
//        try (PreparedStatement pst = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
//            pst.setString(1, fruitToCreate.getName());
//            pst.setObject(2, fruitToCreate.getExpirationDate());
//            pst.execute();
//
//            // Fetching generated id from database during insert
//            ResultSet resultSet = pst.getGeneratedKeys();
//            resultSet.next();
//            Long id = resultSet.getLong(1);
//
//            createdFruit = findById(id);
//
//            connection.commit();
//
//        } catch (SQLException e1) {
//            e1.printStackTrace();
//            try {
//                connection.rollback();
//            } catch (SQLException e2) {
//                e2.printStackTrace();
//            }
//        }
//        return createdFruit;
//    }
//
//    @Override
//    public Fruit findById(Long id) {
//        String query = "SELECT * FROM fruits WHERE id = ?";
//        Fruit foundFruit = null;
//        try (PreparedStatement pst = ConnectionManager.getConnection().prepareStatement(query)) {
//            pst.setLong(1, id);
//            ResultSet rs = pst.executeQuery();
//
//            if (rs.next()) {
//                foundFruit = mapToFruit(rs);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return foundFruit;
//    }
//
//    @Override
//    public boolean update(Fruit fruitToUpdate) {
//        int updateRows = 0;
//        String query = "UPDATE fruits SET name= ?, expirationDate= ? WHERE id=?";
//        Connection connection = ConnectionManager.getConnection();
//        try (PreparedStatement pst = connection.prepareStatement(query)) {
//            pst.setString(1, fruitToUpdate.getName());
//            pst.setObject(2, fruitToUpdate.getExpirationDate());
//            pst.setLong(3, fruitToUpdate.getId());
//
//            updateRows = pst.executeUpdate();
//
//            connection.commit();
//
//        } catch (SQLException e1) {
//            e1.printStackTrace();
//            try {
//                connection.rollback();
//            } catch (SQLException e2) {
//                e2.printStackTrace();
//            }
//        }
//        return updateRows > 0;
//    }
//
//    @Override
//    public boolean delete(Long id) {
//        boolean isDeleted = false;
//        String query = "DELETE FROM fruits WHERE id = ?";
//        Connection connection = ConnectionManager.getConnection();
//        try (PreparedStatement pst = connection.prepareStatement(query)) {
//            pst.setLong(1, id);
//            isDeleted = pst.execute();
//            connection.commit();
//        } catch (SQLException e1) {
//            e1.printStackTrace();
//            try {
//                connection.rollback();
//            } catch (SQLException e2) {
//                e2.printStackTrace();
//            }
//        }
//        return isDeleted;
//    }
//}//class
