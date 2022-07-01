package Project2.version1.person;

public class Employee extends Person{

    private String office;

    private double salary;

    private MyDate date = new MyDate();

    public Employee() {
    }

    public Employee(String name,String address,String phoneNumber,String emailAddress,String office,double salary) {
        super(name,address,phoneNumber,emailAddress);
        this.office = office;
        this.salary = salary;
    }

    public String getOffice() {
        return office;
    }

    public void setOffice(String office) {
        this.office = office;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public MyDate getDate() {
        return date;
    }

    public void setDate(MyDate date) {
        this.date = date;
    }

    public String toString() {
        return "employee类\n姓名:" + getName();
    }

}