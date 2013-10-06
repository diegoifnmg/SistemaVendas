/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.tads.sistemavendas.DomainModel;

/**
 *
 * @author Diego
 */
public class Telefone {

    private int Telefone;
    private int Codigo;

    public Telefone() {
    }

    public int getTelefone() {
        return Telefone;
    }

    public void setTelefone(int Telefone) {
        this.Telefone = Telefone;
    }

    public int getCodigo() {
        return Codigo;
    }

    public void setCodigo(int Codigo) {
        this.Codigo = Codigo;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 47 * hash + this.Telefone;
        hash = 47 * hash + this.Codigo;
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
        final Telefone other = (Telefone) obj;
        if (this.Telefone != other.Telefone) {
            return false;
        }
        if (this.Codigo != other.Codigo) {
            return false;
        }
        return true;
    }
}