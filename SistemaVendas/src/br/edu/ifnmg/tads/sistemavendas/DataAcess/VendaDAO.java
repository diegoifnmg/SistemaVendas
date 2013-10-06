/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.tads.sistemavendas.DataAcess;


import java.sql.PreparedStatement;
import br.edu.ifnmg.tads.sistemavendas.DomainModel.ItemVenda;
import br.edu.ifnmg.tads.sistemavendas.DomainModel.Pessoa;
import br.edu.ifnmg.tads.sistemavendas.DomainModel.Produto;
import br.edu.ifnmg.tads.sistemavendas.DomainModel.Venda;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Diego
 */
public class VendaDAO extends DAO {

    public VendaDAO() {
        super();
    }

    public boolean SalvarVenda(Venda obj) {
        Pessoa pessoa = new Pessoa();
        pessoa = obj.getPessoa();
        if (obj.getCodigo() == 0) {
            try {
                //Salvar(obj.getPessoa());
                PreparedStatement sql = getConexao().prepareStatement("insert into venda(codPessoa,valor,data) values(?,?,?)");

                sql.setInt(1, obj.getPessoa().getCodigo());
                sql.setDouble(2, obj.getValorTotal());
                sql.setDate(3, new java.sql.Date(obj.getData().getTime()));
                sql.executeUpdate();


                PreparedStatement sql2 = getConexao().prepareStatement("select codVenda from venda where valor= ? and data= ?");
                sql2.setDouble(1, obj.getValorTotal());
                sql2.setDate(2, new java.sql.Date(obj.getData().getTime()));
                ResultSet resultado = sql2.executeQuery();
                if (resultado.next()) {
                    obj.setCodigo(resultado.getInt("codVenda"));
                }
                for (ItemVenda e : obj.getItemVendas()) {
                    SalvarItemVenda(obj, e);
                }
               
                //Salvar(obj.getPessoa());
                return true;
            } catch (Exception ex) {
                System.err.println(ex.getMessage());
                return false;
            }
        } else {
            try {
                // Salvar(obj.getPessoa());
                Connection con = getConexao();
                PreparedStatement sql = con.prepareStatement("update venda set codPessoa=?, data=? , valor=? where codVenda=?");
                sql.setInt(1, pessoa.getCodigo());
                sql.setDouble(3, obj.getValorTotal());
                sql.setDate(2, new java.sql.Date(obj.getData().getTime()));
                sql.setDouble(4, obj.getCodigo());

                 
                sql.executeUpdate();
                return true;

            } catch (Exception ex) {
                System.err.println(ex.getMessage());
                return false;
            }
        }

    }//salvar

    //remover venda
    public boolean RemoverVenda(Venda obj) {
        if (obj.getCodigo() >= 0) {
            try {
                PreparedStatement sql = getConexao().prepareStatement("delete from venda where codVenda=?");
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

    //salvar abrir venda
    public Venda AbrirVenda(int id) {
        try {
            PreparedStatement sql = getConexao().prepareStatement("select * from venda where codVenda=?");
            sql.setInt(1, id);

            ResultSet resultado = sql.executeQuery();

            if (resultado.next()) {
                Venda obj = new Venda();

                obj.setCodigo(resultado.getInt("codVenda"));
                obj.setValorTotal(resultado.getDouble("valor"));
                obj.setData(resultado.getDate("data"));

                return obj;
            } else {
                return null;
            }
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            return null;
        }
    }

    //Listar
    public List<Venda> ListarVendas() {
        try {
            PreparedStatement sql = getConexao().prepareStatement("select * from Venda");

            ResultSet resultado = sql.executeQuery();

            List<Venda> lista = new ArrayList<Venda>();

            while (resultado.next()) {
                Venda obj = new Venda();

                obj.setCodigo(resultado.getInt("codVenda"));
                obj.setValorTotal(resultado.getDouble("valor"));
                obj.setData(resultado.getDate("data"));



                lista.add(obj);
            }

            return lista;
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            return null;
        }
    }
    
    
     private void SalvarItemVenda(Venda venda, ItemVenda obj){
       
        Produto produto;
        produto = new Produto();
                
         produto=obj.getProduto();
        
         
        if (obj.getCodigo() == 0) {
            try {
                PreparedStatement sql = getConexao().prepareStatement("insert into itemvenda(codVenda,codProduto, quantidade) values(?,?,?)");
                sql.setInt(1, venda.getCodigo());
                sql.setInt(2, produto.getCodigo());
                sql.setInt(3, obj.getQuantidade());
                sql.executeUpdate();

            } catch (Exception ex) {
                System.err.println(ex.getMessage());
            }
        } else {
            try {
                PreparedStatement sql = getConexao().prepareStatement("update ItemVenda set codVenda = ?, codProduto = ? ,quantidade = ? where  codItemVenda = ?");
                sql.setInt(1, venda.getCodigo());
                sql.setInt(2, produto.getCodigo());
                sql.setInt(3, obj.getQuantidade());
                sql.setInt(4, obj.getCodigo());
                sql.executeQuery();
            } catch (Exception ex) {
                System.err.println(ex.getMessage());
            }
        }
    }
}
