package pl.mkorcz;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import pl.mkorcz.entity.Employee;

import java.util.List;

public class WhereApp {
    public static void main  (String[]args)  {

        Configuration configuration  = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        configuration.addAnnotatedClass(Employee.class);

        SessionFactory factory = configuration.buildSessionFactory();
        Session session = factory.getCurrentSession();

        session.beginTransaction();
        String where = "FROM Employee WHERE first_name='Adam'";

        Query query = session.createQuery(where);

        List<Employee> employeeList = query.getResultList();

        for (Employee employee : employeeList) {
            System.out.println(employee);
        }

        session.getTransaction().commit();

        factory.close();
    }
}
