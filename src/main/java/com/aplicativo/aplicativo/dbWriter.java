package com.aplicativo.aplicativo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class dbWriter {

    private static final String JDBC_URL = "jdbc:h2:.\\src\\main\\resources\\bd";
    private static final String USER = "admin";
    private static final String PASSWORD = "admin";

    private static void executaQuery(String sql, Object... params) {
        try (Connection connection = DriverManager.getConnection(JDBC_URL, USER, PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            
            for (int i = 0; i < params.length; i++) {
                preparedStatement.setObject(i + 1, params[i]);
            }
            
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public static void criaCliente(Integer codigo, String nome, String email) {
        String sql = "INSERT INTO Cliente (codigo, nome, email) VALUES (?, ?, ?)";
        executaQuery(sql, codigo, nome, email);
    }

    public static void criaAplicativo(Integer codigo, String nome, Double custoMensal) {
        String sql = "INSERT INTO Aplicativo (codigo, nome, custoMensal) VALUES (?, ?, ?)";
        executaQuery(sql, codigo, nome, custoMensal);
    }
}
