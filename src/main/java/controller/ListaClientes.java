package controller;

import dao.ProdutoDao;
import model.Veiculo;

import java.util.List;

public class ListaClientes {

    private List<Veiculo> veiculos = null;

    public ProdutoDao produtoDao;

    public ListaClientes() {
    }


    public List<Veiculo> getVeiculos() {
        System.out.println(veiculos);
        return veiculos;
    }

    public void setVeiculos(List<Veiculo> veiculos) {
        this.veiculos = veiculos;
    }

//    public List<Veiculo> listAllVeiculos(){
//        return produtoDao.listAllProduto();
//    }

//    public List<Veiculo> listAllVeiculos(){
//        return produtoDao.listAllVeiculos();
//    }

}
