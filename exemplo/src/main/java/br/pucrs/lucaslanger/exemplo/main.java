package br.pucrs.lucaslanger.exemplo;

import br.pucrs.lucaslanger.exemplo.h2bd;
import br.pucrs.lucaslanger.exemplo.dbFinder;

public class main {
    
    public static void main(String[] args){
        System.out.println("teste");
        h2bd.iniciaBD();
        dbFinder.select("nome, senha", "Usuario");
    }
}
