package test;

import beans.NewStudent;
import org.hibernate.Criteria;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class SelectUsingRestrictions {
    public static void main(String[] args) {
        Configuration cfg = new Configuration();
        cfg.configure("oracle.cfg.xml");
        SessionFactory sf = cfg.buildSessionFactory();
        Session s = sf.openSession();
        Criteria c = s.createCriteria(NewStudent.class);
        Criterion cr = Restrictions.gt("id", "101");
        c.add(cr);
        NewStudent emp = (NewStudent) c.uniqueResult();

        System.out.print(emp.getName() + "," + emp.getEmail());
    }
}
