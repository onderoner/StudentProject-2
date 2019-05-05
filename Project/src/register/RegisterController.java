package register;

import Login.loginController;
import connectivity.ConnectionClass;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import sample.Controller;


import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;
import java.util.ResourceBundle;

public class RegisterController implements Initializable {

    @FXML
    private TextField tfUsername;
    @FXML
    private PasswordField pfPassword;
    @FXML
    private PasswordField pfDefaultPass;
    @FXML
    private RadioButton rbAdmin;
    @FXML
    private RadioButton rbStudent;
    @FXML
    private Button button1;
    @FXML
    private Button button2;

    private ConnectionClass db;
    private ResultSet rs;
    private PreparedStatement ps;

    Random rand = new Random();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.db = new ConnectionClass();
    }

    @FXML
    public void signUp(ActionEvent event) throws  SQLException{
        String query = "INSERT INTO log(logID,division,userName,password)VALUES(?,?,?,?)";
        String checkQuery = "SELECT username FROM log";
        ps = ConnectionClass.getConnection().prepareStatement(checkQuery);
        rs = ps.executeQuery();

        int empID = rand.nextInt(100000000);
        empID = (empID % 1000) + 1000;

        if(rbAdmin.isSelected()){
            try {
                ps = ConnectionClass.getConnection().prepareStatement(query);

                ps.setInt(1,empID);
                ps.setString(2,"Admin");
                ps.setString(3,this.tfUsername.getText());
                ps.setString(4,this.pfPassword.getText());

                if(pfDefaultPass.getText().equals("x")){
                    ps.execute();
                    JOptionPane.showMessageDialog(null,"You have successfully made changes in database!");
                }
                else
                    JOptionPane.showMessageDialog(null,"Wrong default admin password entered!");
            }
            catch (SQLException sql){
                sql.printStackTrace();
            }
        }

        if(rbStudent.isSelected()){
            try{
                ps = ConnectionClass.getConnection().prepareStatement(query);

                ps.setInt(1,empID);
                ps.setString(2,"Student");
                ps.setString(3,this.tfUsername.getText());
                ps.setString(4,this.pfPassword.getText());

                ps.execute();

                JOptionPane.showMessageDialog(null,"You have successfully made changes in database!");
            }
            catch (SQLException sql){
                sql.printStackTrace();
            }
        }
    }

    @FXML
    public void goBack(ActionEvent event){
        Stage stage = (Stage)this.button2.getScene().getWindow();
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
}