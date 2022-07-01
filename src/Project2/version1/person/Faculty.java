package Project2.version1.person;

public class Faculty extends Employee {

    private int workTime;

    private String rank;

    public Faculty() {
    }

    public Faculty(String name,String address,String phoneNumber,String emailAddress,String office,double salary,int workTime,String rank) {
        super(name,address,phoneNumber,emailAddress,office,salary);
        this.workTime = workTime;
        this.rank = rank;
    }

    public int getWorkTime() {
        return workTime;
    }

    public void setWorkTime(int workTime) {
        this.workTime = workTime;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    @Override
    public String toString() {
        return "Faculty类\n姓名:" + getName();
    }

}