package pl.mkorcz;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import pl.mkorcz.entity.Employee;

public class PrimaryKeyApp {

    public static void main(String[] args) {
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        configuration.addAnnotatedClass(Employee .class);

        SessionFactory factory = configuration.buildSessionFactory();
        Session session = factory.getCurrentSession();

        Employee employee1 = new Employee();
        employee1.setFirstName("Piotruś");
        employee1.setLastName("Pan");
        employee1.setSalary(1000);

        Employee employee2 = new Employee();
        employee2.setFirstName("Pan");
        employee2.setLastName("Tadeusz");
        employee2.setSalary(35000);

        Employee employee3 = new Employee();
        employee3.setFirstName("Henryk");
        employee3.setLastName("Sienkiewicz");
        employee3.setSalary(15000);



        session.beginTransaction();
        session.save(employee1);
        session.save(employee2);
        session.save(employee3);
        session.getTransaction().   commit();
        factory.close();
    }
}
