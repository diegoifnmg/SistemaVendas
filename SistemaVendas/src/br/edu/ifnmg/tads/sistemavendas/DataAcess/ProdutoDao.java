/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.tads.sistemavendas.DataAcess;

import br.edu.ifnmg.tads.sistemavendas.DomainModel.Produto;
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
public class ProdutoDAO extends DAO {

    private DAO bd;

    public ProdutoDAO() {
        super();
        bd = new DAO();
    }

    //Salvar Produto
    public boolean SalvarProduto(Produto obj) {
        if (obj.getCodigo() == 0) {
            try {
                PreparedStatement sql = getConexao().prepareStatement("insert into produto(nome,preco) values(?,?)");
                sql.setString(1, obj.getNome());
                sql.setDouble(2, obj.getPreco());
                sql.executeUpdate();


                PreparedStatement sql2 = getConexao().prepareStatement("select codProduto from Produto where nome= ? and preco=?");
                sql2.setString(1, obj.getNome());
                sql2.setDouble(2, obj.getPreco());

                ResultSet resultado = sql2.executeQuery();

                if (resultado.next()) {
                    obj.setCodigo(resultado.getInt("codProduto"));
                }

                return true;
            } catch (Exception ex) {
                System.err.println(ex.getMessage());
                return false;
            }
        } else {
            try {
                Connection con = getConexao();
                PreparedStatement sql = con.prepareStatement("update Produto set nome=?, preco=? where codProduto=?");
                sql.setString(1, obj.getNome());
                sql.setDouble(2, obj.getPreco());
                sql.setInt(3, obj.getCodigo());
                sql.executeUpdate();
                return true;

            } catch (Exception ex) {
                System.err.println(ex.getMessage());
                return false;
            }
        }
    }//salvar

    public boolean Remover(Produto obj) {
        if (obj.getCodigo() >= 0) {
            try {
                PreparedStatement sql = getConexao().prepareStatement("delete from produto where codProduto=?");
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

    public Produto Abrir(int id) {
        try {
            PreparedStatement sql = getConexao().prepareStatement("select * from produto where codProduto=?");
            sql.setInt(1, id);

            ResultSet resultado = sql.executeQuery();

            if (resultado.next()) {
                Produto obj = new Produto();

                obj.setCodigo(resultado.getInt("codProduto"));
                obj.setPreco(resultado.getDouble("preco"));
                obj.setNome(resultado.getString("nome"));


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

    public List<Produto> ListarTodos() {
        try {
            PreparedStatement sql = getConexao().prepareStatement("select * from produto");

            ResultSet resultado = sql.executeQuery();

            List<Produto> lista = new ArrayList<Produto>();

            while (resultado.next()) {
                Produto obj = new Produto();

                obj.setCodigo(resultado.getInt("codProduto"));
                obj.setNome(resultado.getString("nome"));
                obj.setPreco(resultado.getDouble("preco"));

                lista.add(obj);
            }

            return lista;
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            return null;
        }
    }

    public List<Produto> buscar(Produto filtro) {
        try {

            String sql = "select * from produto ";
            String where = "";

            if (filtro.getNome().length() > 0) {
                where = "nome like '%" + filtro.getNome() + "%'";
            }

            if (filtro.getPreco() > 0) {
                if (where.length() > 0) {
                    where = where + " and ";
                }
                where = where + " preco = " + filtro.getPreco();
            }
            if (filtro.getCodigo() > 0) {
                if (where.length() > 0) {
                    where = where + " and ";
                }
                where = where + " coproduto = " + filtro.getCodigo();
            }

            if (where.length() > 0) {
                sql = sql + " where " + where;
            }

            Statement comando = bd.getConexao().createStatement();

            ResultSet resultado = comando.executeQuery(sql);
            // Cria uma lista de produtos vazia
            List<Produto> produtos = new LinkedList<>();
            while (resultado.next()) {
                // Inicializa um objeto de produto vazio
                Produto tmp = new Produto();
                // Pega os valores do retorno da consulta e coloca no objeto

                try {
                    tmp.setCodigo(resultado.getInt("codproduto"));
                    tmp.setNome(resultado.getString("nome"));

                    tmp.setPreco(resultado.getDouble("Preco"));
                } catch (Exception ex) {
                    Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
                }

                // Pega o objeto e coloca na lista
                produtos.add(tmp);
            }
            return produtos;
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
}//fim classe
