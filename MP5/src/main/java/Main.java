import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        StandardServiceRegistry registry = null;
        SessionFactory sessionFactory = null;

        try {
            registry = new StandardServiceRegistryBuilder()
                    .configure()
                    .build();
            sessionFactory = new MetadataSources(registry)
                    .buildMetadata()
                    .buildSessionFactory();

            // Test data
            Restaurant restaurant1 = new Restaurant("Mirazur", "30 Avenue Aristide Briand, 06500 Menton");
            Restaurant restaurant2 = new Restaurant("Noma", "Refshalevej 96, 1432 Copenhagen");

            Employee employee1 = new Employee("First", "First", "12345678", "first@gmail.com", 1000, LocalDate.of(1990, 1, 1));
            Employee employee2 = new Employee("Second", "Second" , "Second", "12345679", "second@gmail.com", 1500, LocalDate.of(1995, 2, 2));
            Employee employee3 = new Employee("Third", "Third", "12345670", "third@gmail.com", 2000, LocalDate.of(1989, 3, 3));

            restaurant1.addEmployee(employee1);
            restaurant1.addEmployee(employee2);
            restaurant1.addEmployee(employee3);

            // Write data to DB
            Session session = sessionFactory.openSession();
            session.beginTransaction();

            session.save(restaurant1);
            session.save(restaurant2);
            session.save(employee1);
            session.save(employee2);
            session.save(employee3);

            session.getTransaction().commit();
            session.close();

            // Read data from DB
            session = sessionFactory.openSession();
            session.beginTransaction();

            List<Restaurant> restaurantsFromDb = session.createQuery("from Restaurant").list();

            for (Restaurant restaurant : restaurantsFromDb) {
                System.out.println(restaurant);
            }

            List<Employee> employeesFromDb = session.createQuery("from Employee").list();

            for (Employee employee : employeesFromDb) {
                System.out.println(employee);
            }

            session.getTransaction().commit();
            session.close();

        } catch (Exception e) {
            e.printStackTrace();
            StandardServiceRegistryBuilder.destroy(registry);
        } finally {
            if (sessionFactory != null) {
                sessionFactory.close();
            }
        }
    }
}
