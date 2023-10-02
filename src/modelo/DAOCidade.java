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
                Cidade c = new Cidade();
                c.setCodigoCidade(rs.getInt("codigo"));
                c.setNomeCidade(rs.getString("nome"));
                c.setUfCidade(rs.getString("uf"));
                listaCidade.add(c);
            }
        }catch(SQLException e) {
            System.out.println("Deu tudo errado! Soem os sinos do apocalipse! "+e.getMessage());
        }
        return listaCidade;
    }
    
    public boolean salvar(Cidade obj) {
        System.out.println("salvando");
        if(obj.getCodigoCidade()==null) {
            System.out.println("salvando mesmo");
            Integer codigo = Dados.listaCidade.size()+1;
            obj.setCodigoCidade(codigo);
            Dados.listaCidade.add(obj);
        }
        return true;
    }
    
    public boolean remover(Cidade obj) {
        Dados.listaCidade.remove(obj);
        return true;
    }
}
