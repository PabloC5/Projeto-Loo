package controller;

import dao.CarroDao;
import dao.ClientDao;
import dao.ProdutoDao;
import model.Carro;
import model.Cliente;
import model.Veiculo;

public class Register {

    public void saveClient(Cliente cliente){
        ClientDao clientDao = new ClientDao();
        clientDao.saveProduto(cliente);
    }

    public void saveCarro(Carro carro){
        CarroDao carroDao = new CarroDao();
        carroDao.saveProduto(carro);
    }
}
