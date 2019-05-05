package admin;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class studentData {
    private final IntegerProperty studentID;
    private final StringProperty name;
    private final StringProperty surname;
    private final IntegerProperty yearOnClass;
    private final IntegerProperty age;
    private final IntegerProperty lectureID;



    public studentData(Integer id, String firstname, String lastname, Integer yearOnClass,Integer age,Integer lectureID){
        this.studentID =new SimpleIntegerProperty(id);
        this.name=new SimpleStringProperty(firstname);
        this.surname=new SimpleStringProperty(lastname);
        this.yearOnClass=new SimpleIntegerProperty(yearOnClass);
        this.age=new SimpleIntegerProperty(age);
        this.lectureID=new SimpleIntegerProperty(lectureID);


    }

    public int getStudentID() {
        return studentID.get();
    }


    public IntegerProperty studentIDProperty() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID.set(Integer.parseInt(studentID));
    }

    public String getName() {
        return name.get();
    }

    public StringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public String getSurname() {
        return surname.get();
    }

    public void setStudentID(int studentID) {
        this.studentID.set(studentID);
    }

    public void setYearOnClass(int yearOnClass) {
        this.yearOnClass.set(yearOnClass);
    }

    public StringProperty surnameProperty() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname.set(surname);
    }

    public int getYearOnClass() {
        return yearOnClass.get();
    }

    public IntegerProperty yearOnClassProperty() {
        return yearOnClass;
    }

    public void setYearOnClass(String yearOnClass) {
        this.yearOnClass.set(Integer.parseInt(yearOnClass));
    }


    public int getAge() {
        return age.get();
    }

    public IntegerProperty ageProperty() {
        return age;
    }

    public void setAge(int age) {
        this.age.set(age);
    }

    public int getLectureID() {
        return lectureID.get();
    }

    public IntegerProperty lectureIDProperty() {
        return lectureID;
    }

    public void setLectureID(int lectureID) {
        this.lectureID.set(lectureID);
    }



}
