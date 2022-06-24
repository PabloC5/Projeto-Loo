package dao;

import java.util.ArrayList;
import java.util.List;

import model.Carro;
import model.Veiculo;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;
import model.Tabelas;

public class VeiculoDao {
    public void saveProduto(Carro produto) {
        Transaction transaction = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            //start the transaction
            transaction = session.beginTransaction();
            //save the studendt object
            session.evict(produto);
            session.save(produto);
            //commit the transaction
            transaction.commit();


        } catch (Exception e) {
            if(transaction != null) {
                System.out.println(e);
                transaction.rollback();
                System.out.println("abriu transaction mas falhou");
            }
        }
    }
    public void updateProduto(Veiculo produto) {

        Transaction transaction = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            //start the transaction
            transaction = session.beginTransaction();
            //save the studendt object
            session.saveOrUpdate(produto);
            //commit the transaction
            transaction.commit();


        } catch (Exception e) {
            if(transaction != null) {
                transaction.rollback();
                System.out.println("abriu transaction mas falhou");
            }
        }
    }
    public Veiculo getProdutoById(long id) {

        Transaction transaction = null;
        Veiculo produto = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            //start the transaction
            transaction = session.beginTransaction();
            //get the studendt object
            produto = session.get(Veiculo.class, id);
            //commit the transaction
            transaction.commit();


        } catch (Exception e) {
            if(transaction != null) {
                transaction.rollback();
                System.out.println("abriu transaction mas falhou");
            }
        }
        return produto;
    }

//    public List<Veiculo> listAllVeiculos() {
//        Tabelas tabelas = Tabelas.VEICULO;
//        Transaction transaction = null;
//        List<Veiculo> produtos = null;
//        try {
//            Session session = HibernateUtil.getSessionFactory().openSession();
//            //start the transaction
//            transaction = session.beginTransaction();
//            //get the studendts
//            produtos = session.createQuery("FROM " + tabelas.getNomeTabelas()).list();
//
////            for (int i = 0; i <produtos.size(); i++) {
////                System.out.println(produtos.get(i));
////            }
//            for(Veiculo produto: produtos){
//                System.out.println(produto.getNomePoduto());
//            }
//            //commit the transaction
//            System.out.println(produtos);
//            transaction.commit();
//
//
//        } catch (Exception e) {
//            if(transaction != null) {
//                System.out.println(e);
//                transaction.rollback();
//                System.out.println("abriu transaction mas falhou");
//            }
//        }
//
//        return produtos;
//    }

//    teste tabela carros
public List<Carro> listAllVeiculos() {
    Tabelas tabelas = Tabelas.VEICULO;
    Transaction transaction = null;
//    List<Carro> produtos = null;
    ArrayList<Carro> produtos = null;

    try {
        Session session = HibernateUtil.getSessionFactory().openSession();
        //start the transaction
        transaction = session.beginTransaction();
        //get the studendts
        produtos = (ArrayList<Carro>) session.createQuery("FROM " + tabelas.getNomeTabelas()).list();

        for(Carro produto: produtos){
            produto.setPreco(produto.getPreco());
            produto.setNomePoduto(produto.getNomePoduto());
        }
        transaction.commit();
    } catch (Exception e) {
        if(transaction != null) {
            System.out.println(e);
            transaction.rollback();
            System.out.println("abriu transaction mas falhou");
        }
    }

    return produtos;
}
//    fim teste

    public void deleteProduto(long id) {

        Transaction transaction = null;
        Veiculo produto = null;

        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            //start the transaction
            transaction = session.beginTransaction();
            //delete the studendt object
            produto = session.get(Veiculo.class, id);
            session.delete(produto);

//            Query q = session.createQuery("delete Entity where id = X");
//            q.executeUpdate();
            //commit the transaction
            transaction.commit();


        } catch (Exception e) {
            if(transaction != null) {
                transaction.rollback();
                System.out.println("abriu transaction mas falhou");
            }
        }
    }
}
