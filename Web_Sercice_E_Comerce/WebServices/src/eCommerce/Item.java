package eCommerce;
import java.util.ArrayList;



public class Item {
    
    private String nome;
    private Double preco;
    Item(String nome, double preco)
    {
        this.nome=nome;
        this.preco=preco;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the preco
     */
    public Double getPreco() {
        return preco;
    }

    /**
     * @param preco the preco to set
     */
    public void setPreco(Double preco) {
        this.preco = preco;
    }
       
}
