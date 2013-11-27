/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 
package br.edu.ifnmg.tads.sistemavendas.DataAcess;

import br.edu.ifnmg.tads.sistemavendas.DomainModel.Funcionario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Diego

public class FuncionarioDAO extends DAO{
    private DAO bd;
    
    public FuncionarioDAO(){
        bd = new DAO();
    }
    
    public boolean Salvar(Funcionario funcionario){
        try{
            if (funcionario.getCodFuncionario() == 0){
                PreparedStatement comando = bd.getConexao().
                        prepareStatement("insert into funcionario (login, senha, codpessoa, ativo) values (?,?,?,?)");
                comando.setString(1, funcionario.getSiape());
                comando.setString(2, funcionario.getCargo());
                comando.setInt(3, funcionario.getPessoa().getCodpessoa());
                comando.setInt(4, 1);
                comando.executeUpdate();
            } else {
                PreparedStatement comando = bd.getConexao().
                        prepareStatement("update funcionarios set siape = ?, cargo = ? where codfuncionario = ?");
                comando.setString(1, funcionario.getSiape());
                comando.setString(2, funcionario.getCargo());
                comando.setInt(3, funcionario.getCodfuncionario());
                comando.executeUpdate();
            }   
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } 
    }
    
    public Funcionario Abrir (int cod){
        try {
            PreparedStatement comando = bd.getConexao().prepareStatement("select * from funcionarios where codfuncionario = ?");
            comando.setInt(1, cod);
            ResultSet resultado = comando.executeQuery();
            resultado.first();
            Funcionario funcionario = new Funcionario();
            funcionario.setCodfuncionario(resultado.getInt("codfuncionario"));
            funcionario.setSiape(resultado.getString("siape"));
            funcionario.setCargo(resultado.getString("cargo"));
            funcionario.setCodpessoa(resultado.getInt("codpessoa"));
            return funcionario;
            
        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public List<Funcionario> BuscarFuncionario(Funcionario filtro){
        try {
            List<Funcionario> funcionarios = new LinkedList<>();
            String sql = "select * from funcionarios";
            String where = "";
            String order = " order by codfuncionario asc";

            if (filtro.getCodfuncionario() > 0){
                where = "codfuncionario = " + filtro.getCodfuncionario();
            }

            if (filtro.getSiape().length() > 0){
                where = "siape like '%" + filtro.getSiape() + "%'";
            }

            if (filtro.getCargo().length() > 0){
                where = "cargo like '%" + filtro.getCargo() + "%'";
            }

            if (where.length() > 0){
                sql = sql + " where " + where + " and ativo = 1";
            } else {
                sql = sql + " where ativo = 1";
            }

            sql = sql + order;

            Statement comando = bd.getConexao().createStatement();
            ResultSet resultado = comando.executeQuery(sql);
            
            while(resultado.next()){
                Funcionario funcionario = new Funcionario();
                funcionario.setCodfuncionario(resultado.getInt("codfuncionario"));
                funcionario.setSiape(resultado.getString("siape"));
                funcionario.setCargo(resultado.getString("cargo"));
                funcionario.setCodpessoa(resultado.getInt("codpessoa"));
                funcionarios.add(funcionario);
            }
            
            return funcionarios;
        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    
    public List<Funcionario> ListarTodos(){
        List<Funcionario> funcionarios = new LinkedList<>();
        
        try {
            PreparedStatement comando = bd.getConexao().prepareStatement("select * from funcionarios where ativo = 1 order by codfuncionario asc");
            ResultSet resultado = comando.executeQuery();
            while(resultado.next()){
                Funcionario funcionario = new Funcionario();
                funcionario.setCodfuncionario(resultado.getInt("codfuncionario"));
                funcionario.setSiape(resultado.getString("siape"));
                funcionario.setCargo(resultado.getString("cargo"));
                funcionario.setCodpessoa(resultado.getInt("codpessoa"));
                funcionarios.add(funcionario);
            }
            return funcionarios;
        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        
        
    }
    
    public boolean Apagar(int cod){
        try {
            PreparedStatement comando = bd.getConexao().
                    prepareStatement("update funcionarios set ativo = 0 where codfuncionario = ?");
            comando.setInt(1, cod);
            comando.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
  
}
*/