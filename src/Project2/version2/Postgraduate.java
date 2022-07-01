package Project2.version2;

import Project2.version1.person.Student;

public class Postgraduate extends Student {

    private String researchField;

    private String tutor;

    Postgraduate() {
    }

    Postgraduate(String name,String address,String phoneNumber,String emailAddress,String researchField,String tutor) {
        super(name,address,phoneNumber,emailAddress);
        this.researchField = researchField;
        this.tutor = tutor;
    }

    public String getResearchField() {
        return researchField;
    }

    public void setResearchField(String researchField) {
        this.researchField = researchField;
    }

    public String getTutor() {
        return tutor;
    }

    public void setTutor(String tutor) {
        this.tutor = tutor;
    }

    @Override
    public String toString() {
        return "Postgraduate类" + getName();
    }
}
