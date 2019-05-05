package admin;

import Login.loginController;
import connectivity.ConnectionClass;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class adminController implements Initializable {

    @FXML
    private TextField id;
    @FXML
    private TextField firstname;
    @FXML
    private TextField lastname;
    @FXML
    private TextField yearOnClass;
    @FXML
    private TextField age;
    @FXML
    private TextField Lecture_ID1;



    @FXML
    private TextArea textA;
    @FXML
    private TextField textB;
    @FXML
    private Button buttonback;



    @FXML
    private TextField teacher_ID;
    @FXML
    private TextField teacher_name;
    @FXML
    private TextField teacher_surname;
    @FXML
    private TextField teacher_Office_number;
    @FXML
    private TextField teacher_Phone_number;

    @FXML
    private TextField lectureID;
    @FXML
    private TextField lecture_name;
    @FXML
    private TextField lecture_classnumber;
    @FXML
    private TextField teacher_ID1;




    @FXML
    private TextField city;
    @FXML
    private TextField street;
    @FXML
    private TextField postalCode;
    @FXML
    private TextField country;
    @FXML
    private TextField studentID1;


    @FXML
    private TableView<studentData> studenttable;
    @FXML
    private TableColumn<studentData, Integer> idcolumn;
    @FXML
    private TableColumn<studentData, String> firstnamecolumn;
    @FXML
    private TableColumn<studentData, String> lastnamecolumn;
    @FXML
    private TableColumn<studentData, Integer> yearOnClasscolumn;
    @FXML
    private TableColumn<studentData, Integer> agecolumn;
    @FXML
    private TableColumn<studentData, Integer> Lecture_ID10;
    @FXML
    private TableView<teacher_info> teachertable;
    @FXML
    private TableColumn<teacher_info, Integer> Tcolumn1;
    @FXML
    private TableColumn<teacher_info, String> Tcolumn2;
    @FXML
    private TableColumn<teacher_info, String> Tcolumn3;
    @FXML
    private TableColumn<teacher_info, Integer> Tcolumn4;
    @FXML
    private TableColumn<teacher_info, Integer> Tcolumn5;
    @FXML
    private TableView<lecture_info> lecturetable;
    @FXML
    private TableColumn<lecture_info, Integer> L1;
    @FXML
    private TableColumn<lecture_info, String> L2;
    @FXML
    private TableColumn<lecture_info, Integer> L3;
    @FXML
    private TableColumn<lecture_info,Integer>L5;
    @FXML
    private TableView<student_address>adresstable ;
    @FXML
    private TableColumn<student_address, String> Acolumn;
    @FXML
    private TableColumn<student_address, String> Acolumn2;
    @FXML
    private TableColumn<student_address, Integer> Acolumn3;
    @FXML
    private TableColumn<student_address, String> Acolumn4;
    @FXML
    private TableColumn<student_address, Integer> Acolumn5;




    private ConnectionClass dc;
    private ObservableList<studentData> data;
    private ObservableList<teacher_info> data1;
    private ObservableList<lecture_info> data2;
    private ObservableList<student_address> data3;
    private String sql = "SELECT * FROM  info";
    private String sql1 = "SELECT * FROM teacher_info";
    private String sql2 = "SELECT * FROM lecture_info";
    private String sql3 = "SELECT * FROM student_address ";


    public void initialize(URL url, ResourceBundle rb) {
        this.dc = new ConnectionClass();

    }

    @FXML
    private void loadStudentData(ActionEvent event) throws SQLException {
        try {
            Connection conn = ConnectionClass.getConnection();
            this.data = FXCollections.observableArrayList();

            ResultSet rs = conn.createStatement().executeQuery(sql);
            while (rs.next()) {
                this.data.add(new studentData(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5),rs.getInt(6)));
            }


        } catch (SQLException e) {
            System.err.println("eror" + e);
        }
        this.idcolumn.setCellValueFactory(new PropertyValueFactory<studentData, Integer>("studentID"));
        this.firstnamecolumn.setCellValueFactory(new PropertyValueFactory<studentData, String>("name"));
        this.lastnamecolumn.setCellValueFactory(new PropertyValueFactory<studentData, String>("surname"));
        this.agecolumn.setCellValueFactory(new PropertyValueFactory<studentData, Integer>("age"));
        this.yearOnClasscolumn.setCellValueFactory(new PropertyValueFactory<studentData, Integer>("yearOnClass"));
        this.Lecture_ID10.setCellValueFactory(new PropertyValueFactory<studentData, Integer>("lectureID"));


        this.studenttable.setItems(null);
        this.studenttable.setItems(this.data);
    }

    @FXML
    private void addStudent(ActionEvent event) {
        String sqlInsert = "INSERT INTO info(studentID,name,surname,age,yearOnClass,lectureID)VALUES(?,?,?,?,?,?)";


        try {
            Connection conn = ConnectionClass.getConnection();
            PreparedStatement stnt = conn.prepareStatement(sqlInsert);

            stnt.setInt(1, Integer.parseInt(this.id.getText()));
            stnt.setString(2, this.firstname.getText());
            stnt.setString(3, this.lastname.getText());
            stnt.setInt(5, Integer.parseInt(this.yearOnClass.getText()));
            stnt.setInt(4, Integer.parseInt(this.age.getText()));
            stnt.setInt(6, Integer.parseInt(this.Lecture_ID1.getText()));


            stnt.execute();
            conn.close();

        } catch (SQLException e) {
            e.getCause().printStackTrace();
        }

    }

    @FXML
    private void loadStudentData1(ActionEvent event) throws SQLException {
        try {
            Connection conn1 = ConnectionClass.getConnection();
            this.data1 = FXCollections.observableArrayList();

            ResultSet rs1 = conn1.createStatement().executeQuery(sql1);
            while (rs1.next()) {
                this.data1.add(new teacher_info(rs1.getInt(1), rs1.getString(2), rs1.getString(3), rs1.getInt(4), rs1.getInt(5)));
            }


        } catch (SQLException e) {
            System.err.println("eror" + e);
        }
        this.Tcolumn1.setCellValueFactory(new PropertyValueFactory<teacher_info, Integer>("teacher_ID"));
        this.Tcolumn2.setCellValueFactory(new PropertyValueFactory<teacher_info, String>("teacher_name"));
        this.Tcolumn3.setCellValueFactory(new PropertyValueFactory<teacher_info, String>("teacher_surname"));
        this.Tcolumn4.setCellValueFactory(new PropertyValueFactory<teacher_info, Integer>("teacher_Office_number"));
        this.Tcolumn5.setCellValueFactory(new PropertyValueFactory<teacher_info, Integer>("teacher_Phone_number"));


        this.teachertable.setItems(null);
        this.teachertable.setItems(this.data1);
    }


    @FXML
    private void addStudent1(ActionEvent event) {
        String sqlInsert1 = "INSERT INTO teacher_info(teacher_ID,teacher_name,teacher_surname,teacher_office_number,teacher_phone_number)VALUES(?,?,?,?,?)";

        try {
            Connection conn1 = ConnectionClass.getConnection();
            PreparedStatement stnt1 = conn1.prepareStatement(sqlInsert1);

            stnt1.setInt(1, Integer.parseInt(this.teacher_ID.getText()));
            stnt1.setString(2, this.teacher_name.getText());
            stnt1.setString(3, this.teacher_surname.getText());
            stnt1.setInt(4, Integer.parseInt(this.teacher_Office_number.getText()));
            stnt1.setInt(5, Integer.parseInt(this.teacher_Phone_number.getText()));


            stnt1.execute();
            conn1.close();
        } catch (SQLException e) {
            e.getCause().printStackTrace();
        }

    }

    @FXML
    private void loadStudentData2(ActionEvent event) throws SQLException {
        try {
            Connection conn2 = ConnectionClass.getConnection();
            this.data2 = FXCollections.observableArrayList();

            ResultSet rs2 = conn2.createStatement().executeQuery(sql2);
            while (rs2.next()) {
                this.data2.add(new lecture_info(rs2.getInt(1), rs2.getString(2), rs2.getInt(3),rs2.getInt(4)));
            }


        } catch (SQLException e) {
            System.err.println("eror" + e);
        }
        this.L1.setCellValueFactory(new PropertyValueFactory<lecture_info, Integer>("lectureID"));
        this.L2.setCellValueFactory(new PropertyValueFactory<lecture_info, String>("lecture_name"));
        this.L3.setCellValueFactory(new PropertyValueFactory<lecture_info, Integer>("lecture_classnumber"));
        this.L5.setCellValueFactory(new PropertyValueFactory<lecture_info,Integer>("teacher_ID"));


        this.lecturetable.setItems(null);
        this.lecturetable.setItems(this.data2);
    }

    @FXML
    private void addStudent2(ActionEvent event) {
        String sqlInsert2 = "INSERT INTO lecture_info(lectureID,lecture_name,lecture_classnumber,teacher_ID)VALUES(?,?,?,?)";

        try {
            Connection conn2 = ConnectionClass.getConnection();
            PreparedStatement stnt2 = conn2.prepareStatement(sqlInsert2);

            stnt2.setInt(1, Integer.parseInt(this.lectureID.getText()));
            stnt2.setString(2, this.lecture_name.getText());
            stnt2.setInt(3, Integer.parseInt(this.lecture_classnumber.getText()));
            stnt2.setInt(4,Integer.parseInt(this.teacher_ID1.getText()));



            stnt2.execute();
            conn2.close();
        } catch (SQLException e) {
            e.getCause().printStackTrace();
        }

    }
    @FXML
    private void loadStudentData3(ActionEvent event) throws SQLException {
        try {
            Connection conn3 = ConnectionClass.getConnection();
            this.data3 = FXCollections.observableArrayList();

            ResultSet rs3 = conn3.createStatement().executeQuery(sql3);
            while (rs3.next()) {
                this.data3.add(new student_address(rs3.getString(1), rs3.getString(2), rs3.getInt(3),rs3.getString(4),rs3.getInt(5)));
            }


        } catch (SQLException e) {
            System.err.println("eror" + e);
        }
        this.Acolumn.setCellValueFactory(new PropertyValueFactory<student_address, String>("city"));
        this.Acolumn2.setCellValueFactory(new PropertyValueFactory<student_address, String>("street"));
        this.Acolumn3.setCellValueFactory(new PropertyValueFactory<student_address, Integer>("postal_code"));
        this.Acolumn4.setCellValueFactory(new PropertyValueFactory<student_address, String>("country"));
        this.Acolumn5.setCellValueFactory(new PropertyValueFactory<student_address, Integer>("studentID"));


        this.adresstable.setItems(null);
        this.adresstable.setItems(this.data3);
    }
    @FXML
    private void addStudent3(ActionEvent event) {
        String sqlInsert3 = "INSERT INTO student_address (city,street,postal_code,country,studentID)VALUES(?,?,?,?,?)";

        try {
            Connection conn3 = ConnectionClass.getConnection();
            PreparedStatement stnt3 = conn3.prepareStatement(sqlInsert3);

            stnt3.setString(1, this.city.getText());
            stnt3.setString(2, this.street.getText());
            stnt3.setInt(3, Integer.parseInt(this.postalCode.getText()));
            stnt3.setString(4,this.country.getText());
            stnt3.setInt(5,Integer.parseInt(this.studentID1.getText()));



            stnt3.execute();
            conn3.close();
        } catch (SQLException e) {
            e.getCause().printStackTrace();
        }

    }
        @FXML
        private void clearField (ActionEvent event){
            this.id.setText("");
            this.firstname.setText("");
            this.lastname.setText("");
            this.yearOnClass.setText("");
            this.age.setText("");
            this.lectureID.setText("");


        } @FXML
    private void clearField2 (ActionEvent event){
        this.teacher_ID.setText("");
        this.teacher_name.setText("");
        this.teacher_surname.setText("");
        this.teacher_Phone_number.setText("");
        this.teacher_Office_number.setText("");



    } @FXML
    private void clearField3(ActionEvent event){
        this.lectureID.setText("");
        this.lecture_name.setText("");
        this.lecture_classnumber.setText("");
        this.teacher_ID1.setText("");


    } @FXML
    private void clearField4 (ActionEvent event){
        this.city.setText("");
        this.street.setText("");
        this.postalCode.setText("");
        this.country.setText("");
        this.studentID1.setText("");



    }
        @FXML
        public void procedure1 (ActionEvent event){
        String sql=" CALL student.DENEME()";
        String st = "";
        try{
            Connection conn = ConnectionClass.getConnection();
            ResultSet rs = conn.createStatement().executeQuery(sql);
            while (rs.next()) {
                st=rs.getInt(1)+rs.getString(2)+rs.getString(3)+rs.getInt(4)+rs.getInt(5)+rs.getInt(6);

            }
            textA.appendText(st+"\n");


        }
        catch (Exception e){

                System.err.println("eror" + e);
        }
        }
    @FXML
    public void procedure2 (ActionEvent event){
        String x=textB.getText();
        String sql=" CALL student.isim arama("+x+")";
        String st = "";

        try{
            Connection conn = ConnectionClass.getConnection();
            ResultSet rs = conn.createStatement().executeQuery(sql);
            while (rs.next()) {
                st=rs.getInt(1)+rs.getString(2)+rs.getString(3)+rs.getInt(4)+rs.getInt(5)+rs.getInt(6);

            }
            textA.appendText(st+"\n");


        }
        catch (Exception e){

            System.err.println("eror" + e);
        }
    }
    @FXML
    public void procedure4 (ActionEvent event){
        String sql="CALL new3()";
        String st = "";
        try{
            Connection conn = ConnectionClass.getConnection();
            ResultSet rs = conn.createStatement().executeQuery(sql);
            while (rs.next()) {
                st=rs.getString(1);

            }
            textA.appendText(st+"\n");


        }
        catch (Exception e){

            System.err.println("eror" + e);
        }
    }
    @FXML
    public void procedure5(ActionEvent event){
        String sql="call new4();";
        String st = "";
        try{
            Connection conn = ConnectionClass.getConnection();
            ResultSet rs = conn.createStatement().executeQuery(sql);
            while (rs.next()) {
                st=rs.getString(1);

            }
            textA.appendText(st+"\n");


        }
        catch (Exception e){

            System.err.println("eror" + e);
        }
    }
    @FXML
    public void func1 (ActionEvent event){
        String x=textB.getText();
        int y = Integer.parseInt(x);
        String sql=" select news("+y+")";
        String st = "";

        try{
            Connection conn = ConnectionClass.getConnection();
            ResultSet rs = conn.createStatement().executeQuery(sql);
            while (rs.next()) {
                st=rs.getString(1);

            }
            textA.appendText(st+"\n");


        }
        catch (Exception e){

            System.err.println("eror" + e);
        }
    }
    @FXML
    public void goBack(ActionEvent event){
        Stage stage = (Stage)this.buttonback.getScene().getWindow();
        stage.close();

        try{
            Stage sampleStage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Parent root = (Pane)loader.load(getClass().getResource("/Login/login.fxml").openStream());
            loginController loginController = (Login.loginController) loader.getController();
            Scene scene = new Scene(root);
            sampleStage.setScene(scene);
            sampleStage.setTitle("menu");
            sampleStage.setResizable(false);
            sampleStage.show();
        }
        catch (IOException ex){
            ex.printStackTrace();
        }

    }
    @FXML
    public void view1 (ActionEvent event){
        String sql=" SELECT * FROM student.first_view;";
        String st = "";
        try{
            Connection conn = ConnectionClass.getConnection();
            ResultSet rs = conn.createStatement().executeQuery(sql);
            while (rs.next()) {
                st=rs.getString(1)+rs.getString(2)+rs.getInt(3)+rs.getString(4)+rs.getInt(5);

            }
            textA.appendText(st+"\n");


        }
        catch (Exception e){

            System.err.println("eror" + e);
        }
    }
    @FXML
    public void view2 (ActionEvent event){
        String sql=" SELECT * FROM student.second_view;";
        String st = "";
        try{
            Connection conn = ConnectionClass.getConnection();
            ResultSet rs = conn.createStatement().executeQuery(sql);
            while (rs.next()) {
                st=rs.getInt(1)+rs.getString(2)+rs.getString(3)+rs.getInt(4)+rs.getInt(5)+rs.getInt(6);

            }
            textA.appendText(st+"\n");


        }
        catch (Exception e){

            System.err.println("eror" + e);
        }
    }

    }

