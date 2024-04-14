package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main {

    public static void main(String[] args) {
        var main = new Main();
        var resultado = main.verifica("root", "sql123");
        System.out.println(resultado);
    }

    private Connection con = null;

    // o metodo conexao, que estabelece a conexao com o db, pode retornar void
    public Connection conexao() {
        try {
            Class.forName("org.gjt.mm.mysql.Driver").newInstance();
            String url = "jdbc:mysql://127.0.0.1/caixaBranca?user=root&password=sql123";
            con = DriverManager.getConnection(url);
        } catch (Exception e) {
            return null;
        }
        return con;
    }

    public boolean verifica(String login, String senha) {
        conexao();
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from usuarios where login='" + login + "' and senha='" + senha + "'");

            if(rs.next()) {
                return true;
            }

        } catch(Exception e) {
            return false;
        }
        return false;
    }
}