/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.tads.sistemavendas.DomainModel;

import java.util.Objects;

/**
 *
 * @author Diego
 */
public class ItemVenda {
     private int codigo;
     private Produto produto;
     private int quantidade;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
     
   

    public Produto getProduto() {
        return produto;
    }
    
    public void setProduto(Produto produto) {
        if(produto != null){
          this.produto = produto;
        }
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) throws Exception{
        if(quantidade>0){
          this.quantidade = quantidade;
        }else{
            throw new Exception(" Quantidades abaixo ou iguais a 0 não são aceitos!");
        }
    
  }

    public double getValor() {
        double valorTotal;
        valorTotal= getQuantidade()*produto.getPreco();
        return valorTotal;
    }

  

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.produto);
        hash = 53 * hash + this.quantidade;
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
        final ItemVenda other = (ItemVenda) obj;
        if (!Objects.equals(this.produto, other.produto)) {
            return false;
        }
        if (this.quantidade != other.quantidade) {
            return false;
        }
        return true;
    }

    
}
