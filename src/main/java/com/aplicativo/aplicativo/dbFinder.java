package com.aplicativo.aplicativo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class dbFinder {

    private static final String JDBC_URL = "jdbc:h2:.\\src\\main\\resources\\bd";
    private static final String USER = "admin";
    private static final String PASSWORD = "admin";

    public static String select(String tabela, String colunas) {
        String sql = "SELECT " + colunas + " FROM " + tabela;
        return Table(sql);
    }

    public static List<String> selectList(String tabela, String colunas) {
        String sql = "SELECT " + colunas + " FROM " + tabela;
        return List(sql);
    }

    public static String selectCodigo(String tabela, String colunas, String codigo) {
        String sql = "SELECT " + colunas + " FROM " + tabela + " WHERE " + tabela + " = ?";
        return Finder(sql, codigo);
    }

    private static List<String> List(String sql) {
        try (Connection connection = DriverManager.getConnection(JDBC_URL, USER, PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(sql);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            return convertList(resultSet);
        } catch (SQLException bd) {
            System.out.println(bd);
            return null;
        }
    }

    private static String Table(String sql) {
        try (Connection connection = DriverManager.getConnection(JDBC_URL, USER, PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(sql);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            return convertString(resultSet);
        } catch (SQLException bd) {
            System.out.println(bd);
            return null;
        }
    }

    private static String Finder(String sql, Object codigo) {
        try (Connection connection = DriverManager.getConnection(JDBC_URL, USER, PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setObject(1, codigo);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                return convertString(resultSet);
            }
        } catch (SQLException bd) {
            System.out.println(bd);
            return null;
        }
    }


    private static String convertString(ResultSet resultSet) throws SQLException {
        StringBuilder resultString = new StringBuilder();
        ResultSetMetaData metaData = resultSet.getMetaData();
        int columnCount = metaData.getColumnCount();

        for (int i = 1; i <= columnCount; i++) {
            resultString.append(metaData.getColumnName(i)).append("\t");
        }
        resultString.append("\n");

        while (resultSet.next()) {
            for (int i = 1; i <= columnCount; i++) {
                resultString.append(resultSet.getString(i)).append("\t");
            }
            resultString.append("\n");
        }
        return resultString.toString();
    }

    private static List<String> convertList(ResultSet resultSet) throws SQLException {
        List<String> resultList = new ArrayList<>();
        ResultSetMetaData metaData = resultSet.getMetaData();
        int columnCount = metaData.getColumnCount();

        // Append rows
        while (resultSet.next()) {
            StringBuilder rowString = new StringBuilder();
            for (int i = 1; i <= columnCount; i++) {
                rowString.append(resultSet.getString(i)).append("\t");
            }
            resultList.add(rowString.toString().trim());
        }
        return resultList;
    }

    
}

