/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.tads.sistemavendas.DomainModel;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Diego
 */
public class Endereco {

    private int codigo;
    private String rua;
    private String bairro;
    private String cidade;
    private int numero;
    private String cep;

    public Endereco() {
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {

        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {

        this.cidade = cidade;
    }

    public int getNumero() {

        return numero;
    }

    public void setNumero(int numero) throws Exception{

        if (numero > 0) {
            this.numero = numero;
        } else {
            throw new Exception(" Numero inválido! (Somente são aceitos inteiros positivos)");
        }
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) throws Exception {
        Pattern padraoCep = Pattern.compile("\\d{5}-\\d{3}");
        Matcher comparar = padraoCep.matcher(cep);
        if (comparar.matches()) {
            this.cep = cep;
        } else { 
            //captura execessão
            throw new Exception("Formato de CEP Inválido!");

        }


    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) throws Exception {
        if (codigo >= 0) {
            this.codigo = codigo;
        } else {
            //captura excessão
            throw new Exception("Codigo Inválido!");
        }
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + this.codigo;
        hash = 53 * hash + Objects.hashCode(this.rua);
        hash = 53 * hash + Objects.hashCode(this.bairro);
        hash = 53 * hash + Objects.hashCode(this.cidade);
        hash = 53 * hash + this.numero;
        hash = 53 * hash + Objects.hashCode(this.cep);
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
        final Endereco other = (Endereco) obj;
        if (this.codigo != other.codigo) {
            return false;
        }
        if (!Objects.equals(this.rua, other.rua)) {
            return false;
        }
        if (!Objects.equals(this.bairro, other.bairro)) {
            return false;
        }
        if (!Objects.equals(this.cidade, other.cidade)) {
            return false;
        }
        if (this.numero != other.numero) {
            return false;
        }
        if (!Objects.equals(this.cep, other.cep)) {
            return false;
        }
        return true;
    }
}
