package pl.mkorcz;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import pl.mkorcz.entity.Employee;

import java.util.List;

public class SelectApp {

    public static void main(String[] args) {

        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        configuration.addAnnotatedClass(Employee.class);

        SessionFactory factory = configuration.buildSessionFactory();
        Session session = factory.getCurrentSession();

        session.beginTransaction();

        String selectHql = "SELECT firstName, lastName FROM Employee";
        String selectHql1 = "SELECT e.firstName, e.lastName FROM Employee as e";
        String selectHql2 = "SELECT e.firstName, e.lastName FROM Employee e";

        Query query = session.createQuery(selectHql2);

        List<Object[]> resultList  = query.getResultList();

        for (Object[] value : resultList) {
            System.out.println("Firstname: " + value[0] + ", Lastname " + value[1]);
        }

        session.getTransaction().commit();

        factory.close();
    }
}
