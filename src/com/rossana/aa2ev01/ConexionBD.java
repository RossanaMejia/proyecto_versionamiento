package com.rossana.aa2ev01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Gestionar la conexión JDBC a MySQL.
 * Ajustar URL, USER y PASSWORD al entorno local.
 */
public class ConexionBD {
    private static final String URL = "jdbc:mysql://localhost:3306/proyecto_db?useSSL=false&serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASSWORD = "Jeonghan1995";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}