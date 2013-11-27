/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.tads.sistemavendas.DomainModel;

import java.util.Objects;

/**
 *
 * @author Diego
 */
public class Funcionario {
    
    int CodFuncionario;
    String login;
    String senha;
    String Cargo;
    int Ativo;

    public Funcionario(int CodFuncionario, String login, String senha, String Cargo, int Ativo) {
        this.CodFuncionario = CodFuncionario;
        this.login = login;
        this.senha = senha;
        this.Cargo = Cargo;
        this.Ativo = Ativo;
    }

    public int getCodFuncionario() {
        return CodFuncionario;
    }

    public void setCodFuncionario(int CodFuncionario) {
        this.CodFuncionario = CodFuncionario;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getCargo() {
        return Cargo;
    }

    public void setCargo(String Cargo) {
        this.Cargo = Cargo;
    }

    public int getAtivo() {
        return Ativo;
    }

    public void setAtivo(int Ativo) {
        this.Ativo = Ativo;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + this.CodFuncionario;
        hash = 67 * hash + Objects.hashCode(this.login);
        hash = 67 * hash + Objects.hashCode(this.senha);
        hash = 67 * hash + Objects.hashCode(this.Cargo);
        hash = 67 * hash + this.Ativo;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Funcionario other = (Funcionario) obj;
        if (this.CodFuncionario != other.CodFuncionario) {
            return false;
        }
        if (!Objects.equals(this.login, other.login)) {
            return false;
        }
        if (!Objects.equals(this.senha, other.senha)) {
            return false;
        }
        if (!Objects.equals(this.Cargo, other.Cargo)) {
            return false;
        }
        if (this.Ativo != other.Ativo) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Funcionario{" + "CodFuncionario=" + CodFuncionario + ", login=" + login + ", senha=" + senha + ", Cargo=" + Cargo + ", Ativo=" + Ativo + '}';
    }

    
}
