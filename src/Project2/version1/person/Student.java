package Project2.version1.person;

public class Student extends Person {

    public static final int FRESHMAN = 1;

    public static final int SOPHOMORE = 2;

    public static final int JUNIOR = 3;

    public static final int SENIOR = 4;

    public Student() {
    }

    public Student(String name,String address,String phoneNumber,String emailAddress){
        super(name,address,phoneNumber,emailAddress);
    }

    @Override
    public String toString() {
        return "Student类\n姓名:" + getName();
    }

}