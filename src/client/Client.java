/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import client.guiControllers.LoginFrameController;
import client.guiControllers.RegisterFrameController;
import java.io.IOException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author Israel Dago
 */
public class Client extends Application {
    private Stage window;
    private Scene scene;
    private AnchorPane root;
    private static LoginFrameController lfc;
    
    @Override
    public void start(Stage primaryStage){
        try { 
            this.showLoginFrame(primaryStage);
            lfc.setClient(this);
        } catch (IOException ex) {
            ex.printStackTrace();
        }        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
    
    private void showLoginFrame(Stage stage) throws IOException{
        this.window= stage;
        FXMLLoader fxml = new FXMLLoader();
        fxml.setLocation(Client.class.getResource("gui/LoginFrame.fxml"));
        this.root = fxml.load();
        this.lfc= fxml.getController();
        this.scene= new Scene(root);
        this.window.setScene(scene);
        this.window.setTitle("Login Frame");
        this.window.setResizable(false);
        this.window.show();        
    }
    
    public static RegisterFrameController showRegisterFrame(ActionEvent ev) throws IOException {
        Stage stage = new Stage();
        FXMLLoader fxml = new FXMLLoader();   
        fxml.setLocation(Client.class.getResource("gui/RegisterFrame.fxml"));
        AnchorPane root = fxml.load();
        RegisterFrameController rfc = fxml.getController();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.initModality(Modality.WINDOW_MODAL);
        stage.initOwner( ((Node)ev.getSource()).getScene().getWindow() );
        stage.show();
        return rfc;
    }
    
    
    
}
