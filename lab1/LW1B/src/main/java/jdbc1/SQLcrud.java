package jdbc1;

import Entity.Refugees;
import Servlets.HelpJson;
import Servlets.LabCRUDInterface;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import javax.security.auth.login.Configuration;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SQLcrud implements LabCRUDInterface<Refugees> {
    Connection connection;
    List<Refugees> list_ref =new ArrayList<>();

    public SQLcrud() {
        this.connection = new Connect().getCon();
        System.out.println(connection);
    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void create(Refugees refugees) {
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure()
                .build();
        try (SessionFactory sessionFactory = new MetadataSources(registry)
                .addAnnotatedClass(Refugees.class)
                .buildMetadata()
                .buildSessionFactory()) {

            Session session = sessionFactory.openSession();
            session.beginTransaction();

            int id = HelpJson.getNextId(list_ref);

            session.save(new Refugees(
                    id,
                    refugees.getName(),
                    refugees.getAge(),
                    refugees.getCity())
            );

            session.getTransaction().commit();
        }
    }

    @Override
    public List<Refugees> read() {
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure()
                .build();
        try (SessionFactory sessionFactory = new MetadataSources(registry)
                .addAnnotatedClass(Refugees.class)
                .buildMetadata()
                .buildSessionFactory()) {

            Session session = sessionFactory.openSession();
            session.beginTransaction();

            list_ref = (List<Refugees>) session.createQuery("from Refugees").list();

            session.getTransaction().commit();
        }

        return list_ref;
    }

    @Override
    public void update(int id, Refugees refugees) {
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure()
                .build();
        try (SessionFactory sessionFactory = new MetadataSources(registry)
                .addAnnotatedClass(Refugees.class)
                .buildMetadata()
                .buildSessionFactory()) {

            Session session = sessionFactory.openSession();
            session.beginTransaction();

            Refugees updateRef = new Refugees(
                    id,
                    refugees.getName(),
                    refugees.getAge(),
                    refugees.getCity()
            );

            session.update(updateRef);

            session.getTransaction().commit();
        }
    }

    @Override
    public void delete(int id) {
        try (PreparedStatement st = connection
                .prepareStatement("DELETE FROM refugees_table WHERE id=?;")) {
            st.setInt(1, id);
            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
