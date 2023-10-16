/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author 13828523633
 */
public class DAOCidade {
    public List<Cidade> getLista() {
        String sql = "select * from cidade;";
        List<Cidade> listaCidade = new ArrayList<>();
        try{
            PreparedStatement st = Conexao.getPreparedStatement(sql);
            st.execute();
            ResultSet rs = st.getResultSet();
            while(rs.next()) {
                listaCidade.add(rsParaCidade(rs));
            }
        }catch(SQLException e) {
            System.out.println("Deu tudo errado! Soem os sinos do apocalipse! "+e.getMessage());
        }
        return listaCidade;
    }
    
    public boolean incluir(Cidade obj) {
        String sql = "insert into cidade (nome,uf) values (?,?)";
        try (PreparedStatement pst = Conexao.aplicar(sql, obj.getNomeCidade(), obj.getUfCidade())) {
            if(pst.executeUpdate() > 0) {
                // Separação de papeis! Isso não deveria estar aqui!
                JOptionPane.showMessageDialog(null, "Cidade cadastrada com sucesso");
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "Cidade não cadastrada");
                return true;
            }
        } catch(SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro de SQL: " + e.getMessage());
            return false;
        }
    }
    
    public boolean alterar(Cidade obj) {
        String sql = "update cidade set nome=?,uf=? where codigo=?";
        try (PreparedStatement pst = Conexao.aplicar(sql, obj.getNomeCidade(), obj.getUfCidade(), obj.getCodigoCidade())) {
            if(pst.executeUpdate() > 0) {
                // Separação de papeis! Isso não deveria estar aqui!
                JOptionPane.showMessageDialog(null, "Cidade atualizada com sucesso");
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "Cidade não atualizada");
                return true;
            }
        } catch(SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro de SQL em DAOCidade.alterar: " + e.getMessage());
            return false;
        }
    }
    
    public boolean salvar(Cidade obj) {
        System.out.println("salvando");
        if(obj.getCodigoCidade()==null) {
            return incluir(obj);
        } else {
            return alterar(obj);
        }
    }
    
    public boolean remover(Cidade obj) {
        try(PreparedStatement pst = Conexao.aplicar("delete from cidade where codigo=?", obj.getCodigoCidade())) {
            if(pst.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(null, "Cidade apagada com sucesso");
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "Cidade não foi apagada");
                return false;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro de SQL em DAOCidade.remover: " + e.getMessage());
            return false;
        }
    }
    
    public static Cidade rsParaCidade(ResultSet rs) throws SQLException {
        Cidade c = new Cidade();
        c.setCodigoCidade(rs.getInt("codigo"));
        c.setNomeCidade(rs.getString("nome"));
        c.setUfCidade(rs.getString("uf"));
        return c;
    }
    public Cidade localizar(Integer id) throws SQLException {
        try(PreparedStatement pst = Conexao.aplicar("select * from cidade where codigo=?", id)) {
            ResultSet rs = pst.executeQuery();
            rs.next();
            return rsParaCidade(rs);
        }
    }
}
