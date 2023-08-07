/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Objects;

/**
 *
 * @author 13828523633
 */
public class Funcionario implements Serializable {
    private Integer codigoFuncionario;
    private String nomeFuncionario;
    private Double salarioFUncionario;
    private Calendar nascimentoFuncionario;
    private Cidade objCidadeFuncionario;
    private Funcionario(){}

    public Integer getCodigoFuncionario() {
        return codigoFuncionario;
    }

    public void setCodigoFuncionario(Integer codigoFuncionario) {
        this.codigoFuncionario = codigoFuncionario;
    }

    public String getNomeFuncionario() {
        return nomeFuncionario;
    }

    public void setNomeFuncionario(String nomeFuncionario) {
        this.nomeFuncionario = nomeFuncionario;
    }

    public Double getSalarioFUncionario() {
        return salarioFUncionario;
    }

    public void setSalarioFUncionario(Double salarioFUncionario) {
        this.salarioFUncionario = salarioFUncionario;
    }

    public Calendar getNascimentoFuncionario() {
        return nascimentoFuncionario;
    }

    public void setNascimentoFuncionario(Calendar nascimentoFuncionario) {
        this.nascimentoFuncionario = nascimentoFuncionario;
    }

    public Cidade getObjCidadeFuncionario() {
        return objCidadeFuncionario;
    }

    public void setObjCidadeFuncionario(Cidade objCidadeFuncionario) {
        this.objCidadeFuncionario = objCidadeFuncionario;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + Objects.hashCode(this.codigoFuncionario);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Funcionario other = (Funcionario) obj;
        if (!Objects.equals(this.codigoFuncionario, other.codigoFuncionario)) {
            return false;
        }
        return true;
    }
}
