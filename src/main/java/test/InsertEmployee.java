package test;

import beans.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class InsertEmployee {
    public static void main(String[] args) {
        Configuration cfg = new Configuration();
        cfg.configure("oracle.cfg.xml");
        SessionFactory sf = cfg.buildSessionFactory();
        Session s = sf.openSession();
        Transaction t = s.beginTransaction();
        Employee e = new Employee();
        e.setId(101);
        e.setName("Mark");
        e.setEmail("Mark@gmail.com");
        e.setSalary(100000);
        s.persist(e);
        t.commit();
        s.close();
        sf.close();
        System.out.println("Employee Data Inserted");

    }
}
