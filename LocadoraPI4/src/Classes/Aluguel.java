/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.sql.Date;

/**
 *
 * @author Rafael
 */
public class Aluguel {
    private int id;
    private Date data_retirada;
    private Date date_entrega;
    private int prazo;
    private int atraso;
    private double valor_parcial;
    private double valor_atraso;
    private int status_id;
    private int carro_id;
    private boolean assegurado;
    private int cliente_id;
    private Carro carro;
    private Usuario cliente;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getData_retirada() {
        return data_retirada;
    }

    public void setData_retirada(Date data_retirada) {
        this.data_retirada = data_retirada;
    }

    public Date getDate_entrega() {
        return date_entrega;
    }

    public void setDate_entrega(Date date_entrega) {
        this.date_entrega = date_entrega;
    }

    public int getPrazo() {
        return prazo;
    }

    public void setPrazo(int prazo) {
        this.prazo = prazo;
    }

    public int getAtraso() {
        return atraso;
    }

    public void setAtraso(int atraso) {
        this.atraso = atraso;
    }

    public double getValor_parcial() {
        return valor_parcial;
    }

    public void setValor_parcial(double valor_parcial) {
        this.valor_parcial = valor_parcial;
    }

    public double getValor_atraso() {
        return valor_atraso;
    }

    public void setValor_atraso(double valor_total) {
        this.valor_atraso = valor_total;
    }

    public int getStatus_id() {
        return status_id;
    }

    public void setStatus_id(int status_id) {
        this.status_id = status_id;
    }

    public int getCarro_id() {
        return carro_id;
    }

    public void setCarro_id(int carro_id) {
        this.carro_id = carro_id;
    }

    public boolean isAssegurado() {
        return assegurado;
    }

    public void setAssegurado(boolean assegurado) {
        this.assegurado = assegurado;
    }

    public int getCliente_id() {
        return cliente_id;
    }

    public void setCliente_id(int cliente_id) {
        this.cliente_id = cliente_id;
    }

    public Carro getCarro() {
        return carro;
    }

    public void setCarro(Carro carro) {
        this.carro = carro;
    }

    public Usuario getCliente() {
        return cliente;
    }

    public void setCliente(Usuario cliente) {
        this.cliente = cliente;
    }
    
    
}
