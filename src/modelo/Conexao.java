/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.*;

/**
 *
 * @author 13828523633
 */
public class Conexao {

    private static final String banco = "jdbc:mysql://localhost:3306/2infoclp2";
    private static final String driver = "com.mysql.jdbc.Driver";
    private static final String usuario = "lp2";
    private static final String senha = "senha123";
    private static Connection con = null;

    public Conexao() {
    }

    public static Connection getConexao() {
        if (con == null) {
            try {
                Class.forName(driver);
                con = DriverManager.getConnection(banco, usuario, senha);
            } catch (ClassNotFoundException e) {
                System.out.println("Não encontrou o driver: " + e.getMessage());
            } catch(SQLException e) {
                System.out.println("Erro de conexão: "+e.getMessage());
            }
        }
        return con;
    }
    
    public static PreparedStatement getPreparedStatement(String sql) {
        if(con == null) {
            con = getConexao();
        }
        try {
            return con.prepareStatement(sql);
        } catch(SQLException e) {
            System.out.println("Erro de sql: "+e.getMessage());
            return null;
        }
    }
}
