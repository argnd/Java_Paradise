package com.formation.app.dao.jdbc;


import com.formation.app.util.ConnectionManager;

import java.sql.*;


public abstract class JdbcDao {

    protected Connection connection;

    public JdbcDao() {
        this.connection = this.getConnection();
    }

    public Connection getConnection() {
        if (this.connection == null) setConnection(ConnectionManager.getConnection());
        return this.connection;
    }

    public void closeConnection() {
        this.connection = null;
    }

    private void setConnection(Connection connection) {
        this.connection = connection;
    }

    public boolean delete(Long id,String tablename) {
        int isDeleted = 0;
        String query = "DELETE FROM "+tablename+" WHERE id = ?";
        try (PreparedStatement pst = this.connection.prepareStatement(query)) {
            pst.setLong(1, id);
            isDeleted = pst.executeUpdate();
            connection.commit();
        } catch (SQLException e1) {
            e1.printStackTrace();
            try {
                connection.rollback();
            } catch (SQLException e2) {
                e2.printStackTrace();
            }
        }
        return isDeleted > 0;
    }

    public abstract void pleaseImpMe();

}
