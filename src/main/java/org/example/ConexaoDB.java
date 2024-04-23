package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ConexaoDB {

    private Connection con = null;

    /**
     *
     * @return Retorna a conexao caso seja estabelecida ou retorna null caso nao consiga
     */
    public Connection conexao() {
        try {
            Class.forName("org.gjt.mm.mysql.Driver").newInstance();
            String url = "jdbc:mysql://localhost:3306/caixaBranca?user=root&password=sql123";
            con = DriverManager.getConnection(url);
        } catch (Exception e) {
            return null;
        }
        return con;
    }

    /**
     *
     * @param login Recebe a informacao de login passada pelo usuario
     * @param senha Recebe a informacao de senha passada pelo usuario
     * @return Verifica login e senha no DB, retorna verdadeiro se existir, falso se nao existir
     */
    public boolean verifica(String login, String senha) {
        conexao();
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery
                    ("select * from usuarios where login= '" + login + "' and senha= '" + senha + "'");
            if(rs.next()) {
                return true;
            }
        } catch(Exception e) {
            return false;
        }
        return false;
    }
}
