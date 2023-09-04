package beans.mapping;

import javax.persistence.*;

@Entity
@Table(name="Student3")
public class Student {
    @Id
    private int rollNo;
    private String studName;
    private int marks;

    @OneToOne(targetEntity = Laptop.class, cascade = CascadeType.ALL)
    private Laptop laptop;

    public Student() {
    }

    public Student(int rollNo, String studName, int marks, Laptop laptop) {
        this.rollNo = rollNo;
        this.studName = studName;
        this.marks = marks;
        this.laptop = laptop;
    }

    public int getRollNo() {
        return rollNo;
    }

    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }

    public String getStudName() {
        return studName;
    }

    public void setStudName(String studName) {
        this.studName = studName;
    }

    public int getMarks() {
        return marks;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }

    public Laptop getLaptop() {
        return laptop;
    }

    public void setLaptop(Laptop laptop) {
        this.laptop = laptop;
    }
}
