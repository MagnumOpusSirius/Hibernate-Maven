package test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.Query;

public class DeleteRecord {
    public static void main(String[] args) {
        Configuration cfg = new Configuration();
        cfg.configure("oracle.cfg.xml");
        SessionFactory sf = cfg.buildSessionFactory();
        Session s = sf.openSession();

        Transaction t= s.beginTransaction();
        String hql= "delete from NewStudent where id= '101'";
        Query q= s.createQuery(hql);
        int i = q.executeUpdate();
        t.commit();
        s.close();
        sf.close();
        System.out.println("row deleted "+ i);
    }
}
