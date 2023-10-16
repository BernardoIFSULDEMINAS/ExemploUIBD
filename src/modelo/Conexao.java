/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.*;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;

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
    
    public static PreparedStatement aplicar(String sql, Object... params) throws SQLException {
        PreparedStatement pst = getPreparedStatement(sql);
        for(int i = 0; i < params.length; i++) {
            Object par = params[i];
            Class<?> classe = par.getClass();
            if(classe.equals(String.class)) {
                pst.setString(i+1, (String)par);
            } else if (classe.equals(Integer.class)) {
                pst.setInt(i+1, (Integer)par);
            } else if (Calendar.class.isAssignableFrom(classe)) {
                java.util.Date d = ((Calendar)par).getTime();
                pst.setDate(i+1, new java.sql.Date(d.getTime()));
            } else if (classe.equals(Double.class)) {
                pst.setDouble(i+1, (Double)par);
            } else {
                throw new IllegalArgumentException("Tipo " + par.getClass() + " não suportado!");
            }
        }
        return pst;
    }
}
