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

    public static ResultSet select(String tabela, String colunas) throws SQLException {
        String sql = "SELECT " + colunas + " FROM " + tabela;
        return Table(sql);
    }

    public static ResultSet selectCodigo(String tabela, String colunas, String codigo) throws SQLException {
        String sql = "SELECT " + colunas + " FROM " + tabela + " WHERE " + tabela + " = ?";
        return Finder(sql, codigo);
    }


    private static ResultSet Table(String sql) {
        try(Connection connection = DriverManager.getConnection(JDBC_URL, USER, PASSWORD);){
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            return preparedStatement.executeQuery();
        }
        catch (SQLException bd){
            System.out.println(bd);
            return null;
        }
    }

    private static ResultSet Finder(String sql, Object codigo) throws SQLException {
        try(Connection connection = DriverManager.getConnection(JDBC_URL, USER, PASSWORD)){
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setObject(1, codigo);
            return preparedStatement.executeQuery();
        }
        catch (SQLException bd){
            System.out.println(bd);
            return null;
        }
    }
}

