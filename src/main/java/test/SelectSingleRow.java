package test;

import beans.NewStudent;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;
public class SelectSingleRow {
    public static void main(String[] args) {
        try{
            Configuration cfg = new Configuration();
            cfg.configure("oracle.cfg.xml");
            SessionFactory sf = cfg.buildSessionFactory();
            Session s = sf.openSession();

            //"Select * " is optional in HQL
            String hql= "from NewStudent where id='101'";
            //will return the type of query
            Query q= s.createQuery(hql);

            //downcasting uniqueResult will call the setter methods of NewStudent...works like getXXX
            //All we get from the DB will be resulted.
            //to fetch a single result based on the id
            NewStudent ns= (NewStudent) q.uniqueResult();
            System.out.println("Id=" + ns.getId());
            System.out.println("Name=" + ns.getName());
            System.out.println("Email=" + ns.getEmail());
            System.out.println("Address=" + ns.getAddress());

            s.close();
            sf.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}