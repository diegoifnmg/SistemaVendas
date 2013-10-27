/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.tads.sistemavendas.DataAcess;

import br.edu.ifnmg.tads.sistemavendas.DomainModel.Email;
import br.edu.ifnmg.tads.sistemavendas.DomainModel.Endereco;
import br.edu.ifnmg.tads.sistemavendas.DomainModel.Pessoa;
import br.edu.ifnmg.tads.sistemavendas.DomainModel.Telefone;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Diego
 */
public class PessoaDao extends DAO {

    private DAO bd;
    
    public PessoaDao() {
        super();
        bd = new DAO();
    }
    //Salvar

    public boolean Salvar(Pessoa obj) {
        if (obj.getCodigo() == 0) {
            try {
                PreparedStatement sql = getConexao().prepareStatement("insert into pessoa(Nome,DataNascimento) values(?,?)");
                sql.setString(1, obj.getNome());
                sql.setDate(2, new java.sql.Date(obj.getDataNascimento().getTime()));

                sql.executeUpdate();

                PreparedStatement sql2 = getConexao().prepareStatement("select codPessoa from pessoa where nome = ? and DataNascimento = ?");
                sql2.setString(1, obj.getNome());
                sql2.setDate(2, new java.sql.Date(obj.getDataNascimento().getTime()));
                ResultSet resultado = sql2.executeQuery();
                if (resultado.next()) {
                    obj.setCodigo(resultado.getInt("codPessoa"));
                }

                // Salva o email
                for (Email e : obj.getEmails()) {
                    SalvarEmail(obj, e);
                }
                //Salva o Endereco 
                for (Endereco e : obj.getEnderecos()) {
                    SalvarEndereco(obj, e);
                }
                // Salva o Telefone 
                for (Telefone e : obj.getTelefones()) {
                    SalvarTelefone(obj, e);
                }
                return true;
            } catch (Exception ex) {
                System.err.println(ex.getMessage());
                return false;
            }
        } else {
            try {
                Connection con = getConexao();
                PreparedStatement sql = con.prepareStatement("update Pessoa set nome=?, DataNascimento=? where codPessoa=?");
                sql.setString(1, obj.getNome());
                sql.setDate(2, new java.sql.Date(obj.getDataNascimento().getTime()));
                sql.setInt(3, obj.getCodigo());
                sql.executeUpdate();
                
                // Salva o email
                for (Email e : obj.getEmails()) {
                    SalvarEmail(obj, e);
                }
                //Salva o Endereco 
                for (Endereco e : obj.getEnderecos()) {
                    SalvarEndereco(obj, e);
                }
                // Salva o Telefone 
                for (Telefone e : obj.getTelefones()) {
                    SalvarTelefone(obj, e);
                }

                return true;

            } catch (Exception ex) {
                System.err.println(ex.getMessage());
                return false;
            }
        }
    }
    // Método Remover 

    public boolean Remover(Pessoa obj) {
        if (obj.getCodigo() >= 0) {
            try {
                PreparedStatement sql = getConexao().prepareStatement("delete from pessoa where codPessoa=?");
                sql.setInt(1, obj.getCodigo());
                //sql.setDate(2, new java.sql.Date( obj.getDataNascimento().getTime() ));
                sql.executeUpdate();
                return true;

            } catch (Exception ex) {
                System.err.println(ex.getMessage());
                return false;
            }
        }
        return true;
    }
    //Abrir

    public Pessoa Abrir(int id) {
        try {
            PreparedStatement sql = getConexao().prepareStatement("select * from Pessoa where codPessoa=?");
            sql.setInt(1, id);

            ResultSet resultado = sql.executeQuery();

            if (resultado.next()) {
                Pessoa obj = new Pessoa();

                obj.setCodigo(resultado.getInt("codPessoa"));
                obj.setNome(resultado.getString("Nome"));
                obj.setDataNascimento(resultado.getDate("DataNascimento"));

                AbrirTelefones(obj);
                //AbrirEmails(obj);
                //AbrirEnderecos(obj);
                
                return obj;
            } else {
                return null;
            }
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            return null;
        }
    }
    // Listar 

    public List<Pessoa> ListarTodos() {
        try {
            PreparedStatement sql = getConexao().prepareStatement("select * from Pessoa");

            ResultSet resultado = sql.executeQuery();

            List<Pessoa> lista = new ArrayList<Pessoa>();

            while (resultado.next()) {
                Pessoa obj = new Pessoa();

                obj.setCodigo(resultado.getInt("codPessoa"));
                obj.setNome(resultado.getString("Nome"));
                obj.setDataNascimento(resultado.getDate("DataNascimento"));

                lista.add(obj);
            }

            return lista;
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            return null;
        }
    }
    
    public List<Telefone> ListarTodosTelefones() {
        try {
            PreparedStatement sql = getConexao().prepareStatement("select * from Telefone");

            ResultSet resultado = sql.executeQuery();

            List<Telefone> lista = new ArrayList<Telefone>();

            while (resultado.next()) {
                Telefone obj = new Telefone();

                obj.setCodigo(resultado.getInt("codTelefone"));
                obj.setTelefone(resultado.getInt("telefone"));
                

                lista.add(obj);
            }

            return lista;
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            return null;
        }
    }
    
    public List<Endereco> ListarTodosEnderecos() {
        try {
            PreparedStatement sql = getConexao().prepareStatement("select * from Enderecos");

            ResultSet resultado = sql.executeQuery();

            List<Endereco> lista = new ArrayList<Endereco>();

            while (resultado.next()) {
                Endereco obj = new Endereco();

                obj.setCodigo(resultado.getInt("codEndereco"));
                obj.setBairro(resultado.getString("bairro"));
                obj.setCidade(resultado.getString("cidade"));
                obj.setCep(resultado.getString("cep"));
                obj.setRua(resultado.getString("rua"));
                obj.setNumero(resultado.getInt("numero"));
                
                lista.add(obj);
            }

            return lista;
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            return null;
        }
    }
    

    // Salvar Email 
    private void SalvarEmail(Pessoa pessoa, Email obj) {
        if (obj.getCodigo() == 0) {
            try {
                PreparedStatement sql = getConexao().prepareStatement("insert into emails(codPessoa,email) values(?,?)");
                sql.setInt(1, pessoa.getCodigo());
                sql.setString(2, obj.getEmail());
                sql.executeUpdate();

            } catch (Exception ex) {
                System.err.println(ex.getMessage());
            }
        } else {
            try {
                PreparedStatement sql = getConexao().prepareStatement("update emails set codPessoa = ?, email = ? where codEmail= ?");
                sql.setInt(1, pessoa.getCodigo());
                sql.setString(2, obj.getEmail());
                sql.setInt(3, obj.getCodigo());
                sql.executeQuery();
            } catch (Exception ex) {
                System.err.println(ex.getMessage());
            }
        }
    }
    //Salvar Endereco 

    private void SalvarEndereco(Pessoa pessoa, Endereco obj) {
        if (obj.getCodigo() == 0) {
            try {
                PreparedStatement sql = getConexao().prepareStatement("insert into enderecos(codPessoa,numero,rua,bairro,cidade,cep) values(?,?,?,?,?,?)");
                sql.setInt(1, pessoa.getCodigo());
                sql.setInt(2, obj.getNumero());
                sql.setString(3, obj.getRua());
                sql.setString(4, obj.getBairro());
                sql.setString(5, obj.getCidade());
                sql.setString(6, obj.getCep());
                sql.executeUpdate();
            } catch (Exception ex) {
                System.err.println(ex.getMessage());
            }
        } else {
            try {
                PreparedStatement sql = getConexao().prepareStatement("update enderecos set codPessoa=?, numero=?, rua=?, bairro=?,cidade=? where codEndereco = ?");
                sql.setInt(1, pessoa.getCodigo());
                sql.setInt(2, obj.getNumero());
                sql.setString(3, obj.getRua());
                sql.setString(4, obj.getBairro());
                sql.setString(5, obj.getCidade());
                sql.setInt(6, obj.getCodigo());
                sql.executeQuery();
            } catch (Exception ex) {
                System.err.println(ex.getMessage());
            }
        }
    }
    //Salvar Telefones 

    private void SalvarTelefone(Pessoa pessoa, Telefone obj) {
        if (obj.getCodigo() == 0) {
            try {
                PreparedStatement sql = getConexao().prepareStatement("insert into telefones(codPessoa,telefone) values(?,?)");
                sql.setInt(1, pessoa.getCodigo());
                sql.setInt(2, obj.getTelefone());
                sql.executeUpdate();

            } catch (Exception ex) {
                System.err.println(ex.getMessage());
            }
        } else {
            try {
                PreparedStatement sql = getConexao().prepareStatement("update telefones set codPessoa = ?, telefone = ? where codTelefone=?");
                sql.setInt(1, pessoa.getCodigo());
                sql.setInt(2, obj.getTelefone());
                sql.setInt(3, obj.getCodigo());
                sql.executeQuery();
            } catch (Exception ex) {
                System.err.println(ex.getMessage());
            }
        }
    }
    
    public List<Pessoa> buscar(Pessoa filtro) {
        try {

            String sql = "select * from pessoa ";
            String where = "";

            if (filtro.getNome().length() > 0) {
                where = "nome like '%" + filtro.getNome() + "%'";
            }
            
            if (filtro.getCodigo() > 0) {
                if (where.length() > 0) {
                    where = where + " and ";
                }
                where = where + " codpessoa = " + filtro.getCodigo();
            }

            if (where.length() > 0) {
                sql = sql + " where " + where;
            }

            Statement comando = bd.getConexao().createStatement();

            ResultSet resultado = comando.executeQuery(sql);
            // Cria uma lista de produtos vazia
            List<Pessoa> pessoas = new LinkedList<>();
            while (resultado.next()) {
                // Inicializa um objeto de produto vazio
                Pessoa tmp = new Pessoa();
                // Pega os valores do retorno da consulta e coloca no objeto

                try {
                    tmp.setCodigo(resultado.getInt("codpessoa"));
                    tmp.setNome(resultado.getString("nome"));
                    tmp.setDataNascimento(resultado.getDate("DataNascimento"));
                } catch (Exception ex) {
                    Logger.getLogger(PessoaDao.class.getName()).log(Level.SEVERE, null, ex);
                }

                // Pega o objeto e coloca na lista
                pessoas.add(tmp);
            }
            return pessoas;
        } catch (SQLException ex) {
            Logger.getLogger(PessoaDao.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    public void AbrirTelefones(Pessoa pessoa) {
        try {
            PreparedStatement sql = getConexao().prepareStatement("select * from telefones where CodPessoa=?");
            sql.setInt(1, pessoa.getCodigo());

            ResultSet resultado = sql.executeQuery();

            while (resultado.next()) {
                pessoa.addTelefone(AbreTelefone(resultado));
            }
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
    }
    private Telefone AbreTelefone(ResultSet resultado) {
        Telefone tel = new Telefone();
        try {
            tel.setCodigo(resultado.getInt("codTelefone"));
            //tel.setDDD(resultado.getByte("DDD"));
            //tel.setOperadora(resultado.getByte("operadora"));
            tel.setTelefone(resultado.getInt("telefone"));
            return tel;
        } catch (Exception ex) {
            Logger.getLogger(PessoaDao.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }
    
    public void AbrirEnderecos(Pessoa pessoa) {
        try {
            PreparedStatement sql = getConexao().prepareStatement("select * from enderecos where CodPessoa=?");
            sql.setInt(1, pessoa.getCodigo());

            ResultSet resultado = sql.executeQuery();

            while (resultado.next()) {
                pessoa.addEndereco(AbreEndereco(resultado));
            }
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
    }
    
    private Endereco AbreEndereco(ResultSet resultado) {
        Endereco end = new Endereco();
        try {
            end.setCodigo(resultado.getInt("codEndereco"));
            end.setBairro(resultado.getString("bairro"));
            end.setCep(resultado.getString("cep"));
            end.setCidade(resultado.getString("cidade"));
            end.setNumero(resultado.getInt("numero"));
            end.setRua(resultado.getString("rua"));
            
            return end;
        } catch (Exception ex) {
            Logger.getLogger(PessoaDao.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }
   
}
