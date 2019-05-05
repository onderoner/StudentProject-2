package admin;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class student_address {
    private final StringProperty city;
    private final StringProperty street;
    private final IntegerProperty postalCode;
    private final StringProperty country;
    private final IntegerProperty studentID;

    public student_address(String city, String street,Integer postalCode,String country,Integer studentID){


        this.city= new SimpleStringProperty(city);
        this.street= new SimpleStringProperty(street);
        this.postalCode= new SimpleIntegerProperty(postalCode);
        this.country=new SimpleStringProperty(country);
        this.studentID=new SimpleIntegerProperty(studentID);


    }
    public String getCity() {
        return city.get();
    }

    public StringProperty cityProperty() {
        return city;
    }

    public void setCity(String city) {
        this.city.set(city);
    }

    public String getStreet() {
        return street.get();
    }

    public StringProperty streetProperty() {
        return street;
    }

    public void setStreet(String street) {
        this.street.set(street);
    }

    public int getPostal_code() {
        return postalCode.get();
    }

    public IntegerProperty postal_codeProperty() {
        return postalCode;
    }

    public void setPostal_code(int postal_code) {
        this.postalCode.set(postal_code);
    }

    public String getCountry() {
        return country.get();
    }

    public StringProperty countryProperty() {
        return country;
    }

    public void setCountry(String country) {
        this.country.set(country);
    }
    public int getStudentID() {
        return studentID.get();
    }

    public IntegerProperty studentIDProperty() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID.set(studentID);
    }

}
