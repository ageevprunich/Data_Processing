package jdbc1;

import Entity.Refugees;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class Main {
    public static void main(String[] args) {

        // A SessionFactory is set up once for an application!
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure() // configures settings from hibernate.cfg.xml
                .build();
        try (SessionFactory sessionFactory = new MetadataSources(registry)
                .addAnnotatedClass(Refugees.class)
                .buildMetadata()
                .buildSessionFactory()) {
            Session session = sessionFactory.openSession();
            session.beginTransaction();

            session.delete(new Refugees(1,"Kyrylo",24,"Zaporizhzhia"));
            session.delete(new Refugees(2,"Lena",35,"Kyiv"));

            session.getTransaction().commit();
        }
    }
}
