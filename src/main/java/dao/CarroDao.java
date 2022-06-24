package dao;

import java.util.List;

import model.Carro;
import model.Cliente;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import util.HibernateUtil;

public class CarroDao {
    public void saveProduto(Carro carro) {
        Transaction transaction = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            //start the transaction
            transaction = session.beginTransaction();
            //save the studendt object
            session.save(carro);
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
    public void updateCarro(Carro carro) {

        Transaction transaction = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            //start the transaction
            transaction = session.beginTransaction();
            //save the studendt object
            session.saveOrUpdate(carro);
            //commit the transaction
            transaction.commit();


        } catch (Exception e) {
            if(transaction != null) {
                transaction.rollback();
                System.out.println("abriu transaction mas falhou");
            }
        }
    }
    public Carro getCarroById(long id) {

        Transaction transaction = null;
        Carro carro = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            //start the transaction
            transaction = session.beginTransaction();
            //get the studendt object
            carro = session.get(Carro.class, id);
            //commit the transaction
            transaction.commit();


        } catch (Exception e) {
            if(transaction != null) {
                transaction.rollback();
                System.out.println("abriu transaction mas falhou");
            }
        }
        return carro;
    }

    public List<Carro> listAllCarro() {

        Transaction transaction = null;
        List<Carro> carros = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            //start the transaction
            transaction = session.beginTransaction();
            //get the studendts
            carros = session.createQuery("from Carro").list();
            //commit the transaction
            transaction.commit();


        } catch (Exception e) {
            if(transaction != null) {
                transaction.rollback();
                System.out.println("abriu transaction mas falhou");
            }
        }

        return carros;
    }
    public void deleteCarro(Carro carros) {

        Transaction transaction = null;
        Carro carro = null;

        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            //start the transaction
            transaction = session.beginTransaction();
            //delete the studendt object
//            carro = session.get(Carro.class, carro);
            session.delete(carros);

            //commit the transaction
            transaction.commit();


        } catch (Exception e) {
            if(transaction != null) {
                transaction.rollback();
                System.out.println("abriu transaction mas falhou");
            }
        }
    }
//    public void deleteCarro(long id) {
//
//        Transaction transaction = null;
//        Carro carro = null;
//
//        try {
//            Session session = HibernateUtil.getSessionFactory().openSession();
//            //start the transaction
//            transaction = session.beginTransaction();
//            //delete the studendt object
//            carro = session.get(Carro.class, id);
//            session.delete(carro);
//
//            //commit the transaction
//            transaction.commit();
//
//
//        } catch (Exception e) {
//            if(transaction != null) {
//                transaction.rollback();
//                System.out.println("abriu transaction mas falhou");
//            }
//        }
//    }
}
