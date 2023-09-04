package beans;

import javax.persistence.*;

@Entity
@Table(name="customerdata1")
public class Customer {
    @Id
    @GeneratedValue
    private int cid;
    private String cname;
    @ManyToOne(cascade = CascadeType.ALL)
    private CustomerAddress customerAddress;

    public Customer(){
        super();
    }

    public Customer(int cid, String cname, CustomerAddress customerAddress) {
        this.cid = cid;
        this.cname = cname;
        this.customerAddress = customerAddress;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public CustomerAddress getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(CustomerAddress customerAddress) {
        this.customerAddress = customerAddress;
    }
}
