package br.pucrs.lucaslanger.exemplo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class dbFinder {

    private static final String JDBC_URL = "jdbc:h2:.\\src\\main\\resources\\bd";
    private static final String USER = "admin";
    private static final String PASSWORD = "admin";

    public static ResultSet select(String columns, String tabela) throws SQLException {
        String sql = "SELECT " + columns + " FROM " + tabela;
        return Table(sql);
    }

    public static ResultSet selectCodigo(String columns, String tabela, String codigo) throws SQLException {
        String sql = "SELECT " + columns + " FROM " + tabela + " WHERE " + tabela + " = ?";
        return Finder(sql, codigo);
    }


    private static ResultSet Table(String sql) throws SQLException {
        Connection connection = DriverManager.getConnection(JDBC_URL, USER, PASSWORD);
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        return preparedStatement.executeQuery();
    }

    private static ResultSet Finder(String sql, Object codigo) throws SQLException {
        Connection connection = DriverManager.getConnection(JDBC_URL, USER, PASSWORD);
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setObject(1, codigo);
        return preparedStatement.executeQuery();
    }
}

