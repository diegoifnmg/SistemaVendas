/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.

package br.edu.ifnmg.tads.sistemavendas.DataAcess;

import br.edu.ifnmg.tads.sistemavendas.DomainModel.Funcionario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Diego

public class LoginDAO {
    private DAO bd;
    
    public LoginDAO(){
        bd = new DAO();
    }
    
    public int Login(Funcionario funcionario){
        try {
            PreparedStatement comando = bd.getConexao().
                    prepareStatement("select * from funcionario where login = ? and senha = md5(?) and funcionarioativo = 1");
            comando.setString(1, funcionario.getLogin());
            comando.setString(2, funcionario.getSenha());
            ResultSet resultado = comando.executeQuery();
            if(resultado.first()){
                Funcionario funcionarioativo = new Funcionario();
                funcionarioativo.setCodFuncionario(resultado.getInt("codfuncionario"));
                return funcionarioativo.getCodFuncionario();
            } else {
                return 0;
            }
        } catch (SQLException ex) {
            Logger.getLogger(LoginDAO.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }   
    }
}


*/