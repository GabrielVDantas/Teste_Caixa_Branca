package org.example;

public class Main {
    public static void main(String[] args) {

        var conexaoDB = new ConexaoDB();

        var resultado = conexaoDB.verifica("loginTeste", "senhaTeste");
        System.out.println(resultado);
    }
}