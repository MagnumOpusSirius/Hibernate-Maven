package test;

import beans.Customer;
import beans.CustomerAddress;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.HashSet;
import java.util.Set;

public class OneToMany {
    public static void main(String[] args) {
        Configuration cfg = new Configuration();
        cfg.configure("oracle.cfg.xml");
        SessionFactory sessionFactory = cfg.buildSessionFactory();
        Session session = sessionFactory.openSession();

        Transaction transaction = session.beginTransaction();
        // Create a CustomerAddress instance
        CustomerAddress customerAddress = new CustomerAddress();
        customerAddress.setAddress_details("123 Main St, City");
        // Create a Customer instance and associate with the CustomerAddress
        Customer customer = new Customer();
        customer.setCname("John");
        customer.setCustomerAddress(customerAddress);

        Customer customer1 = new Customer();
        customer1.setCname("max");
        customer1.setCustomerAddress(customerAddress);

        Set<Customer> set= new HashSet<Customer>();
        set.add(customer);
        set.add(customer1);
        customerAddress.setCustomer(set);
        session.save(customerAddress);
        transaction.commit();
        session.close();
        sessionFactory.close();

        System.out.println("Data saved successfully!");

    }
}
