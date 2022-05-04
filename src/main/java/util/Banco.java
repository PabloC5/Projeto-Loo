package util;
import model.Cliente;
import model.Veiculo;

import java.util.ArrayList;
import java.util.Iterator;

public class Banco {

    private ArrayList<Cliente> clientes = new ArrayList<>();
    private ArrayList<Veiculo> produtos = new ArrayList<>();

    public void addCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    public void addProduto(Veiculo produto) {
        produtos.add(produto);
    }

    public void imprimeClientes() {
        for (Iterator iterator = clientes.iterator(); iterator.hasNext();) {
            Cliente cliente = (Cliente) iterator.next();
            System.out.println("Nome: "+cliente.getNome()+", idade: "+cliente.getIdade() + " cpf: "
                    + cliente.getCpf());
        }
    }

    public void imprimeProdutos(){
        for (Iterator iterator = produtos.iterator(); iterator.hasNext();) {
            Veiculo produto = (Veiculo) iterator.next();
            System.out.println("Nome do produto: "+produto.getNomePoduto()+", Preço: "+produto.getPreco());
        }
    }
}
