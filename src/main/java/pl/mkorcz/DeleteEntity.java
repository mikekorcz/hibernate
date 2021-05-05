package pl.mkorcz;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import pl.mkorcz.entity.Employee;

public class DeleteEntity {

    public static void main(String[] args) {

        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        configuration.addAnnotatedClass(Employee.class);

        SessionFactory factory = configuration.buildSessionFactory();
        Session session = factory.getCurrentSession();

        session.beginTransaction();
        Employee employee = session.get(Employee.class, 12);
        session.delete(employee);


        session.getTransaction().commit();

        factory.close();
    }
}
