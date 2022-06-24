package dao;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import model.BaseEntity;
//import model.Student;
import model.Carro;
import util.HibernateUtil;

public class GenericDao<T extends BaseEntity> {
    // salvando o objeto
    public void save(T obj) {

        Transaction transaction = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            // start the transaction
            transaction = session.beginTransaction();
            // save the studendt object
            session.save(obj);
            // commit the transaction
            transaction.commit();

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
                System.out.println("abriu transaction mas falhou");
            }
        }
    }

    // atualizando o objeto
    public void update(T obj) {

        Transaction transaction = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            // start the transaction
            transaction = session.beginTransaction();
            // save the studendt object
            session.saveOrUpdate(obj);
            // commit the transaction
            transaction.commit();

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
                System.out.println("abriu transaction mas falhou");
            }
        }
    }

    public <T> T getObjectById(T obj, long id) {
        Class classe = obj.getClass();
        String className = classe.getSimpleName().toString();

        Transaction transaction = null;
        T retorno = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            //start the transaction
            transaction = session.beginTransaction();
            //get the studendt object
            retorno = (T)session.get(classe, id);
            //commit the transaction
            transaction.commit();


        } catch (Exception e) {
            if(transaction != null) {
                transaction.rollback();
                System.out.println("abriu transaction mas falhou");
            }
        }
        return retorno;
    }

    public List<T> listAll(T obj) {

        Class classe = obj.getClass();
        String className = classe.getSimpleName().toString();

        Transaction transaction = null;
        List<T> objects = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            // start the transaction
            transaction = session.beginTransaction();
            // get the studendts
            objects = session.createQuery("from " + className).list();
            // objects = session.createQuery("SELECT a FROM Student a",
            // Student.class).getResultList();
            // commit the transaction
            transaction.commit();

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
                System.out.println("abriu transaction mas falhou");
            }
        }

        return objects;
    }

    public void deleteCarro(long id) {

        Transaction transaction = null;
        Carro carro = null;

        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            // start the transaction
            transaction = session.beginTransaction();
            // delete the studendt object
            carro = session.get(Carro.class, id);
            session.delete(carro);

            // commit the transaction
            transaction.commit();

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
                System.out.println("abriu transaction mas falhou");
            }
        }
    }

}

