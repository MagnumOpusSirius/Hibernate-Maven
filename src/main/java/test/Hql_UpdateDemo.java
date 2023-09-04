package test;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Hql_UpdateDemo {
    public static void main(String[] args) {
        Configuration cfg = new Configuration();
        cfg.configure("oracle.cfg.xml");
        SessionFactory sf = cfg.buildSessionFactory();
        Session s = sf.openSession();

        Transaction t= s.beginTransaction();

        String hql= "update NewStudent set name= 'Irfan', email= 'Irfan@gmail.com' where id='101'";
        Query q= s.createQuery(hql);
        int i = q.executeUpdate();
        t.commit();
        s.close();
        sf.close();
        System.out.println("No of row affected "+ i);
    }


}
