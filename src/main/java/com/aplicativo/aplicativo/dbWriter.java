package com.aplicativo.aplicativo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class dbWriter {

    private static final String JDBC_URL = "jdbc:h2:.\\src\\main\\resources\\bd";
    private static final String USER = "admin";
    private static final String PASSWORD = "admin";

    private static void executaQuery(String sql) throws SQLException {
        try (Connection connection = DriverManager.getConnection(JDBC_URL, USER, PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.executeUpdate();
        }
    }

    public static void criaCliente(String codigo, String nome, String email){
        String sql = "INSERT INTO Cliente (codigo, nome, email) VALUES (" + codigo + ", " + nome + ", " + email + ")";
        executaQuery(sql);
    }
}
