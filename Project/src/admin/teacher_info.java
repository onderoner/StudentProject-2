package admin;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class teacher_info {
    private final IntegerProperty teacher_ID;
    private final StringProperty teacher_name;
    private final StringProperty teacher_surname;
    private final IntegerProperty teacher_Office_number;
    private final IntegerProperty teacher_Phone_number;

    public teacher_info(Integer teacher_ID, String teacher_name, String teacher_surname, Integer teacher_Office_number, Integer teacher_Phone_number){

        this.teacher_ID= new SimpleIntegerProperty(teacher_ID);
        this.teacher_name= new SimpleStringProperty(teacher_name);
        this.teacher_surname= new SimpleStringProperty(teacher_surname);
        this.teacher_Office_number= new SimpleIntegerProperty(teacher_Office_number);
        this.teacher_Phone_number= new SimpleIntegerProperty(teacher_Phone_number);

    }
    public int getTeacher_ID() {
        return teacher_ID.get();
    }

    public IntegerProperty teacher_IDProperty() {
        return teacher_ID;
    }

    public void setTeacher_ID(int teacher_ID) {
        this.teacher_ID.set(teacher_ID);
    }

    public String getTeacher_name() {
        return teacher_name.get();
    }

    public StringProperty teacher_nameProperty() {
        return teacher_name;
    }

    public void setTeacher_name(String teacher_name) {
        this.teacher_name.set(teacher_name);
    }

    public String getTeacher_surname() {
        return teacher_surname.get();
    }

    public StringProperty teacher_surnameProperty() {
        return teacher_surname;
    }

    public void setTeacher_surname(String teacher_surname) {
        this.teacher_surname.set(teacher_surname);
    }

    public int getTeacher_Office_number() {
        return teacher_Office_number.get();
    }

    public IntegerProperty teacher_Office_numberProperty() {
        return teacher_Office_number;
    }

    public void setTeacher_Office_number(int teacher_Office_number) {
        this.teacher_Office_number.set(teacher_Office_number);
    }

    public int getTeacher_Phone_number() {
        return teacher_Phone_number.get();
    }

    public IntegerProperty teacher_Phone_numberProperty() {
        return teacher_Phone_number;
    }

    public void setTeacher_Phone_number(int teacher_Phone_number) {
        this.teacher_Phone_number.set(teacher_Phone_number);
    }



}
