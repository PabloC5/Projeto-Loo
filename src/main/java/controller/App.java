package controller;

import dao.ClientDao;
import dao.ProdutoDao;
import dao.StudentDao;
import model.Cliente;
import model.Veiculo;
import model.Student;
import view.FrameBase;

public class App {
    public static void main(String[] args) {
        new FrameBase();

//        StudentDao dao = new StudentDao();
        ProdutoDao produtoDao = new ProdutoDao();
//        System.out.println(produtoDao.listAllProduto());
//        produtoDao.listAllProduto();
        produtoDao.listAllProduto();

//        ClientDao clientDao = new ClientDao();
//        Student student = new Student("pablo" , "aaaa" , "teste@gmail.com");
//        Veiculo produto = new Veiculo(10, "motor");
//        Cliente cliente = new Cliente("Anderson", 25, "99990329");
//        dao.saveStudent(student);
//        clientDao.saveProduto(cliente);
//        produtoDao.saveProduto(produto);
    }
}
