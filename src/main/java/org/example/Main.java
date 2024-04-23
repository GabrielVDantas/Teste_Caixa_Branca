package org.example;

/**
 * @author Gabriel Viegas Dantas
 * @version 1.0
 * @since Release 1.0 da aplicacao
 */

public class Main {
    public static void main(String[] args) {

        var conexaoDB = new ConexaoDB();

        conexaoDB.verifica("loginTeste", "senhaTeste");
    }
}