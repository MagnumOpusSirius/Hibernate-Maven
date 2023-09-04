package test;

import beans.mapping.Laptop;
import beans.mapping.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class OneToOneMapping {
    public static void main(String[] args) {
        //mapping:
        Configuration cfg = new Configuration();
        cfg.configure("oracle.cfg.xml");
        SessionFactory sf = cfg.buildSessionFactory();
        Session s = sf.openSession();

        Transaction transaction = s.beginTransaction();
        Student s1= new Student();
        s1.setRollNo(2);
        s1.setStudName("Allen");
        s1.setMarks(90);

        Laptop l1 = new Laptop();
        l1.setLid(102);
        l1.setLname("Macbook");
        l1.setStudent(s1);

        s1.setLaptop(l1);

        s.persist(s1);
        transaction.commit();
        s.close();
        sf.close();
    }
}
