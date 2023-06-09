package com.microservice.api.Connection;



import java.sql.*;

public class Database {


    private static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/c2ouf?useSSL=false";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";

    private static Connection conn = null;

    public Database() {
        try {

            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            System.out.println("**********************");

            System.out.println("**********************"+conn);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        System.out.println("Database Connection Initialized.");
    }

    public void closeConnection() {
        if (conn == null) return;
        try {
            conn.close();
            conn = null;
        } catch(SQLException ex) {
            ex.printStackTrace();
        }
    }

    public boolean execute(String sql) throws SQLException {
        if (conn == null)
            throw new SQLException("Connection null!");
        Statement statement = conn.createStatement();
        boolean res = statement.execute(sql);
        statement.close();
        return res;
    }

    public int executeUpdate(String sql) throws SQLException {
        if (conn == null)
            throw new SQLException("Connection null!");
        Statement statement = conn.createStatement();
        int res = statement.executeUpdate(sql);
        statement.close();
        return res;
    }

    public ResultSet executeQuery(String sql) throws SQLException {
        if (conn == null)
            throw new SQLException("Connection null!");
        Statement statement = conn.createStatement();
        ResultSet res = statement.executeQuery(sql);
        statement.close();
        return res;
    }
}
