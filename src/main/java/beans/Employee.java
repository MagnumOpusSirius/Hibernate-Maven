package beans;

import javax.persistence.*;

@Entity
@Table(name="Employee006")
public class Employee {
    @Id
    private int id;
    private String name;
    private String email;
    private int salary;

    public Employee() {
        super();

    }

    public Employee(int id, String name, String email, int i) {
        super();
        this.id = id;
        this.name = name;
        this.email = email;
        this.salary = i;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;

    }
}
