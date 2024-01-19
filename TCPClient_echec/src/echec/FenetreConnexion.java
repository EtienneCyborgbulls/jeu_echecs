/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package echec;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 *
 * @author etien
 */
public class FenetreConnexion {
    Fenetre fen;
    Echiquier e;
    public FenetreConnexion(Stage st,Echiquier e){
        this.e = e;
        GridPane root = new GridPane();
        root.setHgap(10);
        root.setVgap(10);
        root.setPadding(new Insets(10));
        Scene scene = new Scene(root);
        st.setScene(scene);

        st.setTitle("comm client");

        // première ligne : adresse du serveur
        Label l1 = new Label("ip serveur");
        root.add(l1, 0, 0);
        // saisie de l'adresse IP du serveur et bouton de connexion
            TextField tf = new TextField();
            tf.setPrefWidth(150);
            root.add(tf, 1, 0);
            Button bcnx = new Button("Connexion");
            root.add(bcnx, 2, 0);
            bcnx.setOnAction(eh -> {
                
                fen = new Fenetre(st,tf.getText(),e);
                e.setFenetre(fen);
                //e.connecter(tf.getText());
            });
        st.show();
    }
}
