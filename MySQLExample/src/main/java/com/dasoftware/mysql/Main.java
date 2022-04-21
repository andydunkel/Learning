package com.dasoftware.mysql;

import java.sql.*;

public class Main {

    public static void main(String[] args) {
        readDataFromDatabase();
        System.out.println("-----------------------------------------------------");

        updateDataInDatabase(3, "Peter");

        System.out.println("-----------------------------------------------------");

        readDataFromDatabase();

        System.out.println("-----------------------------------------------------");

        updateDataInDatabase(3, "Ebe");

        System.out.println("-----------------------------------------------------");

        int id = insertDataInDatabase("Wolfrahm", "Trinkt täglich");

        System.out.println("-----------------------------------------------------");

        readDataFromDatabase();

        System.out.println("-----------------------------------------------------");

        deleteDataFromDatabase(id);

        System.out.println("-----------------------------------------------------");

        readDataFromDatabase();
    }

    public static void deleteDataFromDatabase(int id) {
        System.out.println("Daten löschen");
        System.out.println("---------------");
        try {
            Connection conn = getConnection();
            String sql = "DELETE FROM example_table WHERE ID = ?";
            PreparedStatement statement = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            statement.setInt(1, id);
            int affectedRows = statement.executeUpdate();

            System.out.println("Anzahl Datensätze gelöscht: " + affectedRows);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static int insertDataInDatabase(String name, String comment) {
        System.out.println("Daten einfügen");
        System.out.println("---------------");
        try {
            Connection conn = getConnection();
            String sql = "INSERT INTO example_table (name, comment) VALUES (?,?)";
            PreparedStatement statement = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            statement.setString(1, name);
            statement.setString(2, comment);

            int affectedRows = statement.executeUpdate();
            int newId = -1;

            ResultSet rs = statement.getGeneratedKeys();
            if (rs.next()){
                newId = rs.getInt(1);
            }

            System.out.println("Einfügen durchgeführt, eingefügte Datensätze: " + affectedRows + " - ID des Datensatzes: " + newId);
            return newId;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void updateDataInDatabase(int id, String name) {
        System.out.println("Daten verändern");
        System.out.println("---------------");
        try {
            Connection conn = getConnection();
            String sql = "UPDATE example_table SET name = ? WHERE ID = ?";
            PreparedStatement statement = conn.prepareStatement(sql);

            statement.setString(1, name);
            statement.setInt(2, id);

            int affectedRows = statement.executeUpdate();
            System.out.println("Update durchgeführt, veränderte Datensätze: " + affectedRows);


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static void readDataFromDatabase() {
        System.out.println("Daten abfragen");
        System.out.println("--------------");
        try {
            Connection conn = getConnection();
            String sql = "SELECT * FROM example_table order by id DESC";
            PreparedStatement statement = conn.prepareStatement(sql);

            ResultSet rs = statement.executeQuery();
            while(rs.next()) {
                String line = Integer.toString(rs.getInt("id"));
                line += " - " + rs.getString("name");
                line += " - " + rs.getString("comment");

                System.out.println(line);
            }
            rs.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static Connection getConnection() throws SQLException {
        String databaseName = "java";
        String user = "root";
        String password = "";
        String dbString = "jdbc:mysql://localhost:3306/" + databaseName;
        Connection conn = DriverManager.getConnection(dbString, user, password);
        return conn;
    }
}
