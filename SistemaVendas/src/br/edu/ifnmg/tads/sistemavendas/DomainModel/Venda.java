/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.tads.sistemavendas.DomainModel;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author Diego
 */
public class Venda {
     private int codigo;
    private Date data;
    private double valorTotal;
    private List<ItemVenda> itemVendas;
    private Pessoa pessoa;
    
    public int getCodigo() {
        return codigo;
    }

    public Venda() {
        this.valorTotal =0;
        this.itemVendas = new ArrayList<ItemVenda>();
    }

    public void setCodigo(int codigoVenda)throws Exception {
        if(codigo>=0){
          this.codigo = codigoVenda;
        }else{
             throw new Exception("codigo inválido!");
            
        }
    }

    public List<ItemVenda> getItemVendas() {
        return itemVendas;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        
        this.data = data;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        
        this.valorTotal += valorTotal;
    }

    public void addItemVenda (ItemVenda itemVenda){
        
        if(!this.itemVendas.contains(itemVenda)){
            this.itemVendas.add(itemVenda);
        }
    }
    
     public void removeItemVenda (ItemVenda itemVenda){
        if (this.itemVendas.contains(itemVenda)){
            this.itemVendas.remove(itemVenda);
        }
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        if(pessoa != null){
           this.pessoa = pessoa;
        }
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + this.codigo;
        hash = 97 * hash + Objects.hashCode(this.data);
        hash = 97 * hash + (int) (Double.doubleToLongBits(this.valorTotal) ^ (Double.doubleToLongBits(this.valorTotal) >>> 32));
        hash = 97 * hash + Objects.hashCode(this.itemVendas);
        hash = 97 * hash + Objects.hashCode(this.pessoa);
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
        final Venda other = (Venda) obj;
        if (this.codigo != other.codigo) {
            return false;
        }
        if (!Objects.equals(this.data, other.data)) {
            return false;
        }
        if (Double.doubleToLongBits(this.valorTotal) != Double.doubleToLongBits(other.valorTotal)) {
            return false;
        }
        if (!Objects.equals(this.itemVendas, other.itemVendas)) {
            return false;
        }
        if (!Objects.equals(this.pessoa, other.pessoa)) {
            return false;
        }
        return true;
    }

    public Iterable<ItemVenda> getItemVenda() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
     
    
}
