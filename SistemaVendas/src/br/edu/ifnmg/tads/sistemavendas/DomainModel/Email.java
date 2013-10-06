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
public class Email {

    private int codigo;
    private String email;

    public Email() {
        codigo = 0;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) throws Exception {
        if (codigo >= 0) {
            this.codigo = codigo;
        } else {
            throw new Exception("Codigo Inválido!");

        }
    }

    public String getEmail() {

        return email;
    }

    public void setEmail(String email) {
        Pattern patternEmail;
        patternEmail = Pattern.compile("[a-zA-Z0-9\\-_.]{3,250}@[\\d\\w]+.[\\w.]+");
        Matcher comparar;
        comparar = patternEmail.matcher(email);
        if (comparar.matches()) {
            this.email = email;
        }

    }
    //hash code

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + this.codigo;
        hash = 53 * hash + Objects.hashCode(this.email);
        return hash;
    }

    //equals
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Email other = (Email) obj;
        if (this.codigo != other.codigo) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        return true;
    }
}
