package br.pucrs.lucaslanger.exemplo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.nio.file.Files;
import java.nio.file.Path;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.sql.ResultSet;

public class h2bd {
    private static final String JDBC_URL = "jdbc:h2:.\\src\\main\\resources\\bd";
    private static final String JDBC_USER = "user";            
    private static final String JDBC_PASSWORD = "1234";          

    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD)) {
            System.out.println("Conexão estabelecida com sucesso!");

            try (Statement statement = connection.createStatement()) {
                statement.execute(Files.readString(Path.of(".\\src\\main\\resources\\tabelas.sql"), StandardCharsets.UTF_8));
                System.out.println("Tabelas criadas");

                statement.execute(Files.readString(Path.of(".\\src\\main\\resources\\inserts.sql"), StandardCharsets.UTF_8));
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
}

