package beans;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="customeraddressdata1")
public class CustomerAddress {
    @Id
    @GeneratedValue
    private int address_id;
    @Column
    private String address_details;

    @OneToMany(mappedBy = "customerAddress", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Customer> customer = new HashSet<Customer>(0);

    public CustomerAddress(){
        super();
    }

    public CustomerAddress(int address_id, String address_details, Set<Customer> customer) {
        this.address_id = address_id;
        this.address_details = address_details;
        this.customer = customer;
    }

    public int getAddress_id() {
        return address_id;
    }

    public void setAddress_id(int address_id) {
        this.address_id = address_id;
    }

    public String getAddress_details() {
        return address_details;
    }

    public void setAddress_details(String address_details) {
        this.address_details = address_details;
    }

    public Set<Customer> getCustomer() {
        return customer;
    }

    public void setCustomer(Set<Customer> customer) {
        this.customer = customer;
    }
}
