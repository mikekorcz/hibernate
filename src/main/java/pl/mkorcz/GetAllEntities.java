package pl.mkorcz;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import pl.mkorcz.entity.Employee;

import java.util.List;

public class GetAllEntities {
    public static void main(String[] args) {

        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        configuration.addAnnotatedClass(Employee.class);

        SessionFactory factory = configuration.buildSessionFactory();
        Session session = factory.getCurrentSession();


        session.beginTransaction();
        List<Employee> resultList = session.createQuery("from Employee").getResultList();

        for (Employee employee : resultList)  {
            System.out.println(employee);
        }

        session.getTransaction().   commit();
        factory.close();
    }
}
