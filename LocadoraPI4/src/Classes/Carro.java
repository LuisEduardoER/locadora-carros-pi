/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

/**
 *
 * @author Rafael
 */
public class Carro {
    
    private int id;
    private String modelo;
    private int fabricante_id;
    private int ano;
    private double preco;
    private int portas_id;
    private int lugares_id;
    private int motor_id;
    private int carroceria_id;
    private int combustivel_id;
    private int cambio_id;
    private int direcao_id;
    private String categoria;   
    private String placa;
    private Motor motor;
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getFabricante_id() {
        return fabricante_id;
    }

    public void setFabricante_id(int fabricante_id) {
        this.fabricante_id = fabricante_id;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getPortas_id() {
        return portas_id;
    }

    public void setPortas_id(int portas_id) {
        this.portas_id = portas_id;
    }

    public int getLugares_id() {
        return lugares_id;
    }

    public void setLugares_id(int lugares_id) {
        this.lugares_id = lugares_id;
    }

    public int getMotor_id() {
        return motor_id;
    }

    public void setMotor_id(int motor_id) {
        this.motor_id = motor_id;
    }

    public int getCarroceria_id() {
        return carroceria_id;
    }

    public void setCarroceria_id(int carroceria_id) {
        this.carroceria_id = carroceria_id;
    }

    public int getCombustivel_id() {
        return combustivel_id;
    }

    public void setCombustivel_id(int combustivel_id) {
        this.combustivel_id = combustivel_id;
    }

    public int getCambio_id() {
        return cambio_id;
    }

    public void setCambio_id(int cambio_id) {
        this.cambio_id = cambio_id;
    }

    public int getDirecao_id() {
        return direcao_id;
    }

    public void setDirecao_id(int direcao_id) {
        this.direcao_id = direcao_id;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public Motor getMotor() {
        return motor;
    }

    public void setMotor(Motor motor) {
        this.motor = motor;
    }
    
    
}
