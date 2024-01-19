package echec;


import echec.Fenetre;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author marc
 */
public class Main extends Application {
    static Echiquier e;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        e = new Echiquier(2700);
        launch(args);
    }

    public void start(Stage st) throws Exception {
        FenetreConnexion fenc = new FenetreConnexion(st,e);
        
    }
}
