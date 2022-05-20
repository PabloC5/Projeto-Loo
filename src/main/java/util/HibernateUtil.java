package util;

import java.util.Properties;

import model.Carro;
import model.Cliente;
import model.Veiculo;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {

    private static SessionFactory sessionFactory;
    public static SessionFactory getSessionFactory() {
        if( sessionFactory==null ) {
            try {
                Configuration configuration = new Configuration();
                // equivalente ao hibernate.cfg.xml
                Properties settings = new Properties();
                settings.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
                settings.put(Environment.URL, "jdbc:mysql://localhost:3306/teste");
                settings.put(Environment.USER, "pablo");
                settings.put(Environment.PASS, "pabloc");
                settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQL8Dialect");

                settings.put(Environment.SHOW_SQL, "true");
                settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
                settings.put(Environment.HBM2DDL_AUTO, "update");

                configuration.setProperties(settings);
//                para cada classe modelo criar um novo atributo
                configuration.addAnnotatedClass(Cliente.class);
                configuration.addAnnotatedClass(Veiculo.class);
//                configuration.addAnnotatedClass(Student.class);
                configuration.addAnnotatedClass(Carro.class);

                ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
                sessionFactory = configuration.buildSessionFactory(serviceRegistry);


            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return sessionFactory;
    }
}
