package Project2.version1.person;

public class Staff extends Employee {

    private String position;

    public Staff() {
    }

    public Staff(String name,String address,String phoneNumber,String emailAddress,String office,double salary,String position) {
        super(name,address,phoneNumber,emailAddress,office,salary);
        this.position = position;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String toString() {
       return "Staff类\n姓名:" + getName();
    }

}