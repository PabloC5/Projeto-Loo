package model;

import javax.persistence.*;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Carro")
public class Carro extends Veiculo{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private long id;

    @Column(name = "Aro Rodas")
    private int aroRodas;

    @Column(name = "Numero de portas")
    private int portas;

    public Carro() {
        super();
    }

    public Carro(double preco, String nomePoduto, int aroRodas, int portas) {
        super(preco, nomePoduto);
        aroRodas = getAroRodas();
        portas = getPortas();
    }

    @Override
    public long getId() {
        return id;
    }

    @Override
    public void setId(long id) {
        this.id = id;
    }

    public void setAroRodas(int aroRodas) {
        this.aroRodas = aroRodas;
    }

    public void setPortas(int portas) {
        this.portas = portas;
    }

    public int getAroRodas() {
        return aroRodas;
    }

    public int getPortas() {
        return portas;
    }
}
