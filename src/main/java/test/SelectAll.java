package test;

import beans.NewStudent;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class SelectAll {
    public static void main(String[] args) {
        Configuration cfg = new Configuration();
        cfg.configure("oracle.cfg.xml");
        SessionFactory sf = cfg.buildSessionFactory();
        Session s = sf.openSession();
        // Transaction t = s.beginTransaction();

        Criteria c = s.createCriteria(NewStudent.class);
        List<NewStudent> list = c.list();
        System.out.println("Done" + list);
        for (NewStudent ns : list) {
            System.out.println("id=" + ns.getId() + ", name=" + ns.getName() + ", Email=" + ns.getEmail());
        }
        System.out.println("Done1");
        s.close();
    }
}
