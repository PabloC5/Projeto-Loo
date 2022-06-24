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

    public void updateCarros(Carro carro){
        CarroDao carroDao = new CarroDao();
        carroDao.updateCarro(carro);
    }

    public void updateClinte(Cliente cliente){
        ClientDao clientDao = new ClientDao();
        clientDao.updateCliente(cliente);
    }

    public void deletaCarro(long idCarro){
        CarroDao veiculoDao = new CarroDao();
        veiculoDao.deleteCarro(idCarro);
    }

    public void deletaClientes(long idCliente){
        ClientDao clientDao = new ClientDao();
        clientDao.deleteCliente(idCliente);
    }
}
