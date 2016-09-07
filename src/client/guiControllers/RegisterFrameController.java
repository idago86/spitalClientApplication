/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.guiControllers;

import client.Client;
import client.servicesController.ServicesController;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller clgo
 */
public class RegisterFrameController implements Initializable {
    
    @FXML
    private AnchorPane root;

    @FXML
    private TextField userFld;

    @FXML
    private TextField parolaFld;

    @FXML
    private Button registerBTN;
    
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
    private void onRegisterBTNClick(ActionEvent e){
        try {
            String user = userFld.getText();
            String parola = parolaFld.getText();
            boolean rez = ServicesController.getInstance().register(user, parola);
            if(rez){
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setResizable(false);
                alert.setContentText("New Admin Registered");
                alert.showAndWait();                     
            }else{
                Alert alert = new Alert(Alert.AlertType.WARNING); 
                alert.setHeaderText("Action Failed");
                alert.setResizable(false);
                alert.setContentText("you maybe had already an account...try to login");
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
