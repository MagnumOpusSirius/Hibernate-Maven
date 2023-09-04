package test;

import beans.Employee;
import org.hibernate.Criteria;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Iterator;
import java.util.List;

public class SelectWithProjection {
    public static void main(String[] args) {
        // Session session = HibernateUtil.getSessionFactory().openSession();
        Configuration cfg = new Configuration();
        cfg.configure("oracle.cfg.xml");
        SessionFactory sf = cfg.buildSessionFactory();
        Session session = sf.openSession();

        Employee user = null;

        // Creating a Criteria instance
        Criteria crit = session.createCriteria(Employee.class);
        ProjectionList prolist = Projections.projectionList();
        prolist.add(Projections.max("salary"));
        prolist.add(Projections.min("salary"));
        prolist.add(Projections.avg("salary"));
        crit.setProjection(prolist);
        List list = crit.list();
        Iterator itr = list.iterator();
        if (!itr.hasNext()) {
            System.out.println("No Data Available!");
        } else {
            while (itr.hasNext()) {
                System.out.printf("\n");

                Object[] row = (Object[]) itr.next();
                for (int i = 0; i < row.length; i++) {
                    if (i == 0) {
                        System.out.print("Max Salary is : ");
                        System.out.print(row[i]);
                        System.out.printf("\n");
                    }
                    if (i == 1) {
                        System.out.print("Min Salary is : ");
                        System.out.print(row[i]);
                        System.out.printf("\n");
                    }
                    if (i == 2) {
                        System.out.print("average sal is : ");
                        System.out.print(row[i]);
                        System.out.printf("\n");
                    }
                }
            }
        }

    }
}
