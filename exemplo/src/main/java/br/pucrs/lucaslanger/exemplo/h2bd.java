package br.pucrs.lucaslanger.exemplo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.nio.file.Files;
import java.nio.file.Path;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class h2bd {
    private static final String JDBC_URL = "jdbc:h2:.\\exemplo\\src\\main\\resources\\bd";
    private static final String JDBC_USER = "admin";            
    private static final String JDBC_PASSWORD = "admin";          

    public static void iniciaBD() {
        try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD)) {
            System.out.println("Conexão estabelecida com sucesso!");

            try (Statement statement = connection.createStatement()) {
                statement.execute(Files.readString(Path.of(".\\exemplo\\src\\main\\resources\\tabelas.sql"), StandardCharsets.UTF_8));
                System.out.println("Tabelas criadas");

                statement.execute(Files.readString(Path.of(".\\exemplo\\src\\main\\resources\\inserts.sql"), StandardCharsets.UTF_8));
                System.out.println("Dados criados");
            }
            catch (IOException io){
                System.out.println(io);
            }
            catch (SQLException bd){
                System.out.println(bd);
            }
        } 
        
        catch (SQLException bd) {
            System.out.println(bd);
        }

        try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD)) {
            printTabelas(connection, "Usuario");
            printTabelas(connection, "Aplicativos");
            printTabelas(connection, "Cliente");
            printTabelas(connection, "Assinatura");
            printTabelas(connection, "Pagamento");
            printTabelas(connection, "Promocao");
        } catch (SQLException bd) {
            System.out.println(bd);
        }
    }

    private static void printTabelas(Connection connection, String tabela) throws SQLException {
        String query = "SELECT * FROM " + tabela;
        try (Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query)) {
            int colunas = rs.getMetaData().getColumnCount();
            System.out.println("Tabela:  " + tabela);
            while (rs.next()) {
                for (int i = 1; i <= colunas; i++) {
                    System.out.print(rs.getString(i) + " ");
                }
                System.out.println();
            }
            System.out.println("----------------------------");
        }
    }

    public static String convertRs(ResultSet resultSet){
        try {
            StringBuilder resultString = new StringBuilder();

            // Get metadata to retrieve column count
            ResultSetMetaData metaData = resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();

            // Loop through the result set
            while (resultSet.next()) {
                // Loop through each column in the current row
                for (int i = 1; i <= columnCount; i++) {
                    // Append column value to the string
                    resultString.append(resultSet.getString(i));
                    if (i < columnCount) {
                        resultString.append("\t"); // Append tab if not the last column
                    }
                }
                resultString.append("\n"); // Append new line after each row
            }

            // Convert StringBuilder to String
            return resultString.toString();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}

