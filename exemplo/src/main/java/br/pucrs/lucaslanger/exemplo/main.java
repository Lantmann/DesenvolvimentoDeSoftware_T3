package br.pucrs.lucaslanger.exemplo;

import br.pucrs.lucaslanger.exemplo.h2bd;
import br.pucrs.lucaslanger.exemplo.dbFinder;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;

public class main {
    
    public static void main(String[] args){
        h2bd.iniciaBD();
        System.out.println(dbFinder.select("Aplicativos", "codigo, nome"));
    }
}
