package test;

import beans.NewStudent;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class SelectMultipleRow {
    public static void main(String[] args) {
        Configuration cfg = new Configuration();
        cfg.configure("oracle.cfg.xml");
        SessionFactory sf = cfg.buildSessionFactory();
        Session s = sf.openSession();

        //multiple record will be returned -> a list of all the students in the DB
        String hql= "from NewStudent";
        Query q= s.createQuery(hql);
        //to fetch multiple rows
        List<NewStudent> list= (List<NewStudent>)q.list();
        for(NewStudent ns1: list){
            System.out.println("Id=" + ns1.getId());
            System.out.println("Name=" + ns1.getName());
            System.out.println("Email=" + ns1.getEmail());
            System.out.println("Address=" + ns1.getAddress());
        }
        s.close();
        sf.close();
    }
}
