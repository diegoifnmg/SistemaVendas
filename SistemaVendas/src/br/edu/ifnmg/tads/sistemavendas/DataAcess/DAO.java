/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.tads.sistemavendas.DataAcess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author Diego
 */
public class DAO {

    private Connection conexao;

    public DAO() {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            conexao = DriverManager.getConnection("jdbc:mysql://localhost/testeconexao", "root", "");
        } catch (Exception ex) {

            System.err.print(ex.getMessage());
        }
    }

    public java.sql.Connection getConexao() {

        return conexao;


    }
}
