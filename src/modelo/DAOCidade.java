/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.List;

/**
 *
 * @author 13828523633
 */
public class DAOCidade {
    public List<Cidade> getLista() {
        return Dados.listaCidade;
    }
    
    public boolean salvar(Cidade obj) {
        if(obj.getCodigoCidade()==null) {
            Integer codigo = Dados.listaCidade.size()-1;
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
