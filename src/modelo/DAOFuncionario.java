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
import java.util.Calendar;
import javax.swing.JOptionPane;

/**
 *
 * @author 13828523633
 */
public class DAOFuncionario {
    public List<Funcionario> getLista() {
        DAOCidade daoCidade = new DAOCidade();
        String sql = "select * from funcionario;";
        List<Funcionario> listaFuncionario = new ArrayList<>();
        try{
            PreparedStatement st = Conexao.getPreparedStatement(sql);
            st.execute();
            ResultSet rs = st.getResultSet();
            while(rs.next()) {
                Funcionario f = new Funcionario();
                f.setCodigoFuncionario(rs.getInt("codigo"));
                f.setNomeFuncionario(rs.getString("nome"));
                f.setSalarioFuncionario(rs.getDouble("salario"));
                Calendar c = Calendar.getInstance();
                c.setTime(rs.getDate("dataNascimento"));
                f.setNascimentoFuncionario(c);
                Integer cod_cidade = rs.getInt("cidade");
                f.setObjCidadeFuncionario(daoCidade.localizar(cod_cidade));
                listaFuncionario.add(f);
            }
        } catch(SQLException e) {
            System.out.println("Deu tudo errado! Soem os sinos do apocalipse! Em DAOFuncionario.getLista(): "+e.getMessage());
            return null;
        }
        return listaFuncionario;
    }
    
    public boolean incluir(Funcionario obj) {
        String sql = "insert into funcionario (nome,salario,dataNascimento,cidade) values (?,?,?,?)";
        try (PreparedStatement pst = Conexao.aplicar(sql, obj.getNomeFuncionario(), obj.getSalarioFuncionario(),
                obj.getNascimentoFuncionario(), obj.getObjCidadeFuncionario().getCodigoCidade())) {
            if(pst.executeUpdate() > 0) {
                // Separação de papeis! Isso não deveria estar aqui!
                JOptionPane.showMessageDialog(null, "Funcionário cadastrado com sucesso");
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "Funcionário não cadastrado");
                return true;
            }
        } catch(SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro de SQL: " + e.getMessage());
            return false;
        }
    }
    
    public boolean alterar(Funcionario obj) {
        String sql = "update funcionario set nome=?,salario=?,dataNascimento=?,cidade=? where codigo=?";
        try (PreparedStatement pst = Conexao.aplicar(sql, obj.getNomeFuncionario(), obj.getSalarioFuncionario(),
                obj.getNascimentoFuncionario(), obj.getObjCidadeFuncionario().getCodigoCidade(), obj.getCodigoFuncionario())) {
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
    
    public boolean salvar(Funcionario obj) {
        System.out.println("salvando");
        if(obj.getCodigoFuncionario()==null) {
            return incluir(obj);
        } else {
            return alterar(obj);
        }
    }
    
    public boolean remover(Funcionario obj) {
        try(PreparedStatement pst = Conexao.aplicar("delete from funcionario where codigo=?", obj.getCodigoFuncionario())) {
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
}
