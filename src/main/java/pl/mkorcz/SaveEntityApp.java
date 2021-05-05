package pl.mkorcz;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import pl.mkorcz.entity.Employee;

public class SaveEntityApp {
    public static void main(String[] args) {
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        configuration.addAnnotatedClass(Employee.class);

        SessionFactory factory = configuration.buildSessionFactory();
        Session session = factory.getCurrentSession();

        Employee employee = new Employee();
        employee.setIdEmployee(1);
        employee.setFirstName("Mike");
        employee.setLastName("Kowalski");
        employee.setSalary(25000);

        session.beginTransaction();
        session.save(employee);
        session.getTransaction().   commit();
        factory.close();
    }
}
