package Project2.version1.person;

import java.io.Serializable;

public class Person implements Serializable {

    private String name = "边帝行";

    private String address = "郑州";

    private String phoneNumber = "12345";

    private String emailAddress = "12345.com";

    public Person() {
    }

    public Person(String name,String address,String phoneNumber,String emailAddress) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    @Override
    public String toString() {
        return "Person类\n姓名:" + name;
    }
}
