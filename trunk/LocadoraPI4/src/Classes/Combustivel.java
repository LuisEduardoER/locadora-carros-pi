/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

/**
 *
 * @author Rafael
 */
public class Combustivel {
    private int id;
    private String nome;

    public int getId() {
        return id;
    }

    @Override
    public String toString(){
        return this.getNome();
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
}
