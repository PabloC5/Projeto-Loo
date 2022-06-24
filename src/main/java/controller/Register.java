package controller;

import dao.CarroDao;
import dao.ClientDao;
import model.Carro;
import model.Cliente;

public class Register {

    public void saveClient(Cliente cliente){
        ClientDao clientDao = new ClientDao();
        clientDao.saveProduto(cliente);
    }

    public void saveCarro(Carro carro){
        CarroDao carroDao = new CarroDao();
        carroDao.saveProduto(carro);
    }

    public void deleteCar(Carro carro){
        CarroDao veiculoDao = new CarroDao();
        veiculoDao.deleteCarro(carro);
    }
}
