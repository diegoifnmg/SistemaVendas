/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.tads.sistemavendas.DomainModel;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Diego
 */
public class Produto {

    private int codigo;
    private String nome;
    private double preco;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) throws Exception {
        if (codigo >= 0) {
            this.codigo = codigo;
        } else {
            throw new Exception("Código Inválido!");
        }
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) throws Exception {
        Pattern patternNome = Pattern.compile("[a-z A-Z\\w\\s]{1,250}");
        Matcher comparar = patternNome.matcher(nome);

        if (comparar.matches()) {
            this.nome = nome;
        } else {
            throw new Exception("Formato de nome Inválido!(informe nomes com 3 ou mais caracteres)");

        }
    }

    public double getPreco() {

        return preco;

    }

    public void setPreco(double preco) throws Exception {
        if (preco > 0) {
            this.preco = preco;
        } else {
            throw new Exception("Valor Insuficiente!(informe valores maiores que 0)!");
        }


    }
}