package pl.mkorcz;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import pl.mkorcz.entity.Employee;

public class UpdateEntity {
    public static void main(String[] args) {

        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        configuration.addAnnotatedClass(Employee.class);

        SessionFactory factory = configuration.buildSessionFactory();
        Session session = factory.getCurrentSession();

        session.beginTransaction();

        Employee employee= session.get(Employee.class, 10);
        employee.setFirstName("Adam");
        employee.setLastName("Mickiewicz");

        session.getTransaction().commit();


        System.out.println("Updated employee: " +employee);


        factory.close();
    }


}
