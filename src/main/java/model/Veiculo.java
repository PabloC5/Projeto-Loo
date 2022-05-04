package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Produto")
public class Veiculo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private long id;

    @Column(name = "PRECO")
    private double preco;

    @Column(name = "NOME")
    private String nomePoduto;

    public Veiculo() {
        super();
    }

    public Veiculo(double preco, String nomePoduto) {
        super();
        setPreco(preco);
        setNomePoduto(nomePoduto);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getNomePoduto() {
        return nomePoduto;
    }

    public void setNomePoduto(String nomePoduto) {
        this.nomePoduto = nomePoduto;
    }
}
