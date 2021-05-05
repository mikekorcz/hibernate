package pl.mkorcz;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import pl.mkorcz.entity.Employee;

public class GetEntityApp {

    public static void main(String[] args) {

        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        configuration.addAnnotatedClass(Employee.class);

        SessionFactory factory = configuration.buildSessionFactory();
        Session session = factory.getCurrentSession();

        Employee employee = new Employee();
        employee.setFirstName("Mikołaj");
        employee.setLastName("Krawczuk");
        employee.setSalary(50000);

        session.beginTransaction();
        Integer id = (Integer) session.save(employee);
        session.getTransaction().commit();

        session = factory.getCurrentSession();
        session.beginTransaction();
        Employee retrieveEmployee = session.get(Employee.class, id);
        session.getTransaction().commit();

        System.out.println("Employee: " + retrieveEmployee);

        factory.close();
    }
}
