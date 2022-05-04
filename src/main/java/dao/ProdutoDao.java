package dao;

import java.util.List;

import model.Carro;
import model.Veiculo;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

public class ProdutoDao {
    public void saveProduto(Veiculo produto) {
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

    public List<Veiculo> listAllProduto() {

        Transaction transaction = null;
        List<Veiculo> produtos = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            //start the transaction
            transaction = session.beginTransaction();
            //get the studendts
            produtos = session.createQuery("from Veiculo").list();
//            for (int i = 0; i <produtos.size(); i++) {
//                System.out.println(produtos.get(i));
//            }
            for(Veiculo produto: produtos){
                System.out.println(produto.getNomePoduto());
            }
            //commit the transaction
            System.out.println(produtos);
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

//    public void listAllProduto(){
////        Session session = factory.openSession();
//        Transaction tx = null;
//        List produtos = null;
//        Session session = HibernateUtil.getSessionFactory().openSession();
//        try {
//            tx = session.beginTransaction();
//             produtos = session.createQuery("FROM Produto").list();
//            System.out.println(produtos);
////            for (Iterator iterator = employees.iterator(); iterator.hasNext();){
////                Carro carro = (Carro) iterator.next();
////                System.out.print("First Name: " + carro.getNomePoduto());
////                System.out.print("  Last Name: " + carro.getAroRodas());
////                System.out.println("  Salary: " + carro.getPreco());
////            }
//            tx.commit();
//        } catch (HibernateException e) {
//            if (tx!=null) tx.rollback();
//            e.printStackTrace();
//        } finally {
//            session.close();
//        }
//    }

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
