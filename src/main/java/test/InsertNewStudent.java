package test;

import beans.NewStudent;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class InsertNewStudent {
    public static void main(String[] args) {
        Configuration cfg = new Configuration();

        cfg.configure("oracle.cfg.xml");
        SessionFactory sf = cfg.buildSessionFactory();
        Session s = sf.openSession();

        Transaction transaction = s.beginTransaction();
        NewStudent ns= new NewStudent();

        ns.setId("101");
        ns.setName("Mark");
        ns.setEmail("james@gmail.com");
        ns.setAddress("NY");
        s.persist(ns);

        transaction.commit();
        s.close();
        sf.close();
        System.out.println("Data Inserted Successfully");
    }
}
