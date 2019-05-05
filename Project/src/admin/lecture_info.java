package admin;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class lecture_info {
    private final IntegerProperty lectureID;
    private final StringProperty lecture_name;
    private final IntegerProperty lecture_classnumber;
    private final IntegerProperty teacher_ID;



    public lecture_info(Integer lectureID, String lecture_name,Integer lecture_classnumber,Integer teacher_ID){


        this.lectureID= new SimpleIntegerProperty(lectureID);
        this.lecture_name= new SimpleStringProperty(lecture_name);
        this.lecture_classnumber= new SimpleIntegerProperty(lecture_classnumber);
        this.teacher_ID=new SimpleIntegerProperty(teacher_ID);


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

    public String getLecture_name() {
        return lecture_name.get();
    }

    public StringProperty lecture_nameProperty() {
        return lecture_name;
    }

    public void setLecture_name(String lecture_name) {
        this.lecture_name.set(lecture_name);
    }

    public int getLecture_classnumber() {
        return lecture_classnumber.get();
    }

    public IntegerProperty lecture_classnumberProperty() {
        return lecture_classnumber;
    }

    public void setLecture_classnumber(int lecture_classnumber) {
        this.lecture_classnumber.set(lecture_classnumber);
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

}
