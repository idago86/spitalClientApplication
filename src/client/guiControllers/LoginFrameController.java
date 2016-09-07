/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.guiControllers;

import client.Client;
import client.servicesController.ServicesController;
import dto.AdminDTO;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author Israel Dago
 */
public class LoginFrameController implements Initializable {
    
    @FXML
    private AnchorPane root;

    @FXML
    private TextField userFld;

    @FXML
    private Button loginBtn;

    @FXML
    private Button registerBtn;

    @FXML
    private PasswordField parolaFld;
    
    private Client client;

    public void setClient(Client client) {
        this.client = client;
    }
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    private void onRegisterBtnClick(ActionEvent e) throws IOException{
        this.client.showRegisterFrame(e);
    }
    
    @FXML
    private void onLoginBtnClick(ActionEvent e) throws IOException{
        try {
            String user = userFld.getText();
            String parola = parolaFld.getText();
            AdminDTO rez = ServicesController.getInstance().login(user, parola);
            if(rez!=null){
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setResizable(false);
                alert.setContentText("Login reusit");
                alert.showAndWait();                     
            }else{
                Alert alert = new Alert(Alert.AlertType.WARNING); 
                alert.setHeaderText("Login Failed");
                alert.setResizable(false);
                alert.setContentText("you maybe wrong your username or your password...try after double check");
                alert.showAndWait();
            }
        } catch (Exception ex) {
                Alert alert = new Alert(Alert.AlertType.ERROR); 
                alert.setTitle("");
                alert.setResizable(false);
                alert.setContentText("Somes errors happened during your request");
                alert.showAndWait();
        }
        userFld.setText(""); parolaFld.setText("");        
    }
    
    
}
