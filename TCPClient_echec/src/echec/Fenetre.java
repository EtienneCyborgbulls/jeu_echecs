package echec;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */




import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javafx.stage.Stage;

import javafx.scene.*;
import javafx.scene.control.ChoiceBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.*;
import javafx.scene.shape.Rectangle;
import tcp.Connectable;

/**
 *
 * @author marc
 */
public class Fenetre {
    Case c;
    Echiquier e;
    
    private Stage st;
    VBox vb = new VBox();
    GridPane gp = new GridPane();
    StackPane[][] tab = new StackPane[8][8];
    Case caseDepart;
    
   
    
    // Group root = new Group();
    public Fenetre(Stage stage,String connexion,Echiquier e) {
        this.e = e;
        e.connecter(connexion);
        st = stage;
        st.setTitle("Best échec(blanc)");
        VBox vb=new VBox();
        Scene sc = new Scene(vb,800,800);
        st.setScene(sc);
        vb.getChildren().add(gp);
        remplir();
        
        
        gp.setOnMouseClicked(eh->clic(eh));
        st.show();
    }
    int compteur_clic = 0;
    int nbtour = 0;
    
    
    private void clic(MouseEvent ev){
        compteur_clic++;
        //System.out.println(Math.floor(ev.getX()/100)+" "+Math.floor(ev.getY()/100));
        //Point2D coord = new Point2D(Math.floor(ev.getX()/100),Math.floor(ev.getY()/100));
        int x = (int) Math.floor(ev.getX()/100); //colonne
        int y = (int) Math.floor(ev.getY()/100); //ligne
        //System.out.println(x + " " + y);
        
        
        if(compteur_clic == 1){
            if(e.echiquier[x][y].piece != null){
            /*
               Le joueur 1 est celui qui commence et qui joue tous les tours pairs
                Il joue les pièces blanches (les pièces en bas de l'interface graphique)
             
                */
                System.out.println(nbtour);
                if(nbtour%2==0 && e.echiquier[x][y].piece.numcouleur == 1){ 
                    caseDepart= e.echiquier[x][y];                          
            
                    //System.out.println(caseDepart.colonne + " " + caseDepart.ligne);
                    //System.out.println(caseDepart.piece);
                }
            /*
                Le joueur 2 joue tous les tous impairs et joues les pièces noires
                Ce sont les pièces en haut de l'interface graphique
            */
                //else if (nbtour%2!=0 && e.echiquier[x][y].piece.numcouleur == 0){
                    //caseDepart= e.echiquier[x][y];
            
                    //System.out.println(caseDepart.colonne + " " + caseDepart.ligne);
                    //System.out.println(caseDepart.piece);
                //}
                else{
                    System.out.println("La pièce que vous essayez de déplacer n'est pas la votre");
                    compteur_clic = 0;
                }
            }
            else{
                System.out.println("Case vide");
                compteur_clic = 0;
            }
        }
            
        else if (compteur_clic == 2){
            boolean echec = false;
            //Case caseDeLaPieceQuiMetEnEchec = null;
            Case caseArrivee = e.echiquier[x][y];
            
            //System.out.println(caseArrivee.colonne + " " + caseArrivee.ligne);
            //System.out.println(caseArrivee.piece); 
            boolean mouvementPossible = caseDepart.piece.mouvement(caseDepart,caseArrivee,e);
            //System.out.println(caseArrivee.piece + "");
//             for(int i =0;i<8;i++){
//                    for(int j=0;j<8;j++){
//                        if(nbtour%2 == 0){
//                           
//                           if(e.MetEnEchec(e.echiquier[i][j].piece, e.Rb, e)){
//                              caseDeLaPieceQuiMetEnEchec = e.echiquier[i][j];
//                              echec = true;
//                           }
//                        }
//                        else{ 
//                           if(e.MetEnEchec(e.echiquier[i][j].piece, e.Rn, e)){
//                               caseDeLaPieceQuiMetEnEchec = e.echiquier[i][j];
//                               echec = true;
//                           }
//                        }       
//                            
//                        
//                    }
//                }
             
            
//            if(mouvementPossible && echec == false){
//                
//                
//                caseArrivee.piece = caseDepart.piece; //on déplace la pièce sur la case désirée
//                caseArrivee.piece.c = caseArrivee;
//                caseDepart.piece=null; //il n'y alors plus de pièce sur la case de départ
//                remplir(); //actualisation de l'interface graphique
//                nbtour++;
//                //System.out.println(nbtour);
//            }
//            else if(mouvementPossible && caseArrivee == caseDeLaPieceQuiMetEnEchec){
//                caseArrivee.piece = caseDepart.piece; //on déplace la pièce sur la case désirée
//                caseArrivee.piece.c = caseArrivee;
//                caseDepart.piece=null; //il n'y alors plus de pièce sur la case de départ
//                remplir(); //actualisation de l'interface graphique
//                nbtour++;
//                
//            }
            if(mouvementPossible){
                
                Piece copie = caseArrivee.piece;
                caseArrivee.piece = caseDepart.piece;
                caseArrivee.piece.c = caseArrivee;
                caseDepart.piece=null;
                for(int i =0;i<8;i++){
                    for(int j=0;j<8;j++){
                        if(nbtour%2 == 0){
                           
                           if(e.MetEnEchec(e.echiquier[i][j].piece, e.Rb, e)){
                              //caseDeLaPieceQuiMetEnEchec = e.echiquier[i][j];
                              echec = true;
                           }
                        }
                        else{ 
                           if(e.MetEnEchec(e.echiquier[i][j].piece, e.Rn, e)){
                               
                               echec = true;
                           }
                        }       
                            
                        
                    }
                }
                if(echec == false){
                    remplir();
                    if(caseArrivee.piece instanceof Pion){
                        Pion p = (Pion) caseArrivee.piece;
                    if(caseArrivee.ligne == 0 || caseArrivee.ligne == 7){
                        
                        ChoiceBox cb = new ChoiceBox();
                        cb.getItems().addAll("Dame", "Cavalier", "Fou","Tour");
                        cb.getSelectionModel();
                        tab[caseArrivee.colonne][caseArrivee.ligne].getChildren().add(cb);
                        cb.setOnAction((ae) -> {
                            if(cb.getSelectionModel().getSelectedItem().equals("Dame")){
                                
                                int numcouleur = caseArrivee.piece.numcouleur;
                                
                                Piece d = new Dame(numcouleur,caseArrivee);
                                caseArrivee.piece =d;
                                d.c = caseArrivee;
                                remplir();
                            }
                            else if(cb.getSelectionModel().getSelectedItem().equals("Cavalier")){
                                int numcouleur = caseArrivee.piece.numcouleur;
                                
                                Piece c = new Cavalier(numcouleur,caseArrivee);
                                caseArrivee.piece =c;
                                c.c = caseArrivee;
                                remplir();
                            }
                            else if(cb.getSelectionModel().getSelectedItem().equals("Fou")){
                                int numcouleur = caseArrivee.piece.numcouleur;
                                
                                Piece f = new Fou(numcouleur,caseArrivee);
                                caseArrivee.piece =f;
                                f.c = caseArrivee;
                                remplir();
                            }
                            else if(cb.getSelectionModel().getSelectedItem().equals("Tour")){
                                int numcouleur = caseArrivee.piece.numcouleur;
                                
                                Piece t = new Tour(numcouleur,caseArrivee);
                                caseArrivee.piece =t;
                                t.c = caseArrivee;
                                remplir();
                                
                            }
                           
                        });
                        

                        
                    }
                    e.envoyer(caseArrivee.piece.nom + " " + caseDepart.colonne + ""+ caseDepart.ligne + " "+ caseArrivee.colonne + ""+ caseArrivee.ligne + " "+ p.numDuTourOuAEteFaitLavanceeDeDeuxCases );
                    }
                    else{
                        e.envoyer(caseArrivee.piece.nom + " " + caseDepart.colonne + ""+ caseDepart.ligne + " "+ caseArrivee.colonne + ""+ caseArrivee.ligne);
                    }
                    
                    nbtour++;
                }
                else{
                    caseDepart.piece=caseArrivee.piece;
                    caseArrivee.piece = copie;
                    caseDepart.piece.c = caseDepart;
                    if(caseDepart.piece instanceof Pion){
                        Pion pion = (Pion) caseDepart.piece;
                        pion.nbtourpion--;
                    }
                    if(e.EchecEtMat(nbtour, e)){
                        System.out.println("Fin de partie");
                    }
                    else{
                        System.out.println("Il n'y a pas echec et mat");
                    }
                }
            }
            else{
                System.out.println("Mouvement non possible");
            }
            compteur_clic = 0;
            
        }
    }   
    
    //Button pat= new Button("pat");
    //pat.setPrefSize(80,80);
    //Hbox hb =new HBox();
    //hb.getChildren().addAll(pat) ;

    public void remplir() {
        
        int c = 0;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                Rectangle r = new Rectangle(100, 100);
        
                tab[i][j] = new StackPane();
                if (i%2==0){
                    if (j % 2 == 0) {
                        r.setFill(Color.BURLYWOOD);

                    } 
                    else {
                    r.setFill(Color.BEIGE);
                    }
                }
                else{
                    if (j % 2 == 0) {
                        r.setFill(Color.BEIGE);

                    } 
                    else {
                    r.setFill(Color.BURLYWOOD);
                    }
                }
                tab[i][j].getChildren().add(r);
                gp.add(tab[i][j], i, j);
                
                

            }

        }
        try {
     
            Image im1 = new Image(new FileInputStream("pion-blanc.png"));
            Image im2 = new Image(new FileInputStream("pion-noir.png"));
       
            Image im3 = new Image(new FileInputStream("cavalier-noir.png"));
            
           
            Image im4 = new Image(new FileInputStream("fou-blanc.png"));
            
           
            Image im5 = new Image(new FileInputStream("fou-noir.png"));
            
           
            Image im6 = new Image(new FileInputStream("tour-noire.png"));
            
           
            Image im7 = new Image(new FileInputStream("tour-blanche.png"));
            
           
            Image im8 = new Image(new FileInputStream("reine-blanche.png"));
           
           
            Image im9 = new Image(new FileInputStream("reine-noire.png"));
            
           
            Image im10 = new Image(new FileInputStream("roi-noir.png"));
            
           
            Image im11 = new Image(new FileInputStream("roi-blanc.png"));
            
           
            Image im12 = new Image(new FileInputStream("cavalier-blanc.png"));
            
            for(int i=0;i<8;i++){
                for(int j=0;j<8;j++){
                    if(e.echiquier[i][j].piece!=null){
                        if(e.echiquier[i][j].piece.nom == "P"){
                            if(e.echiquier[i][j].piece.numcouleur == 1){
                                ImageView ipb = new ImageView(im1);
                                ipb.setScaleX(1.4);
                                ipb.setScaleY(1.4);
                                tab[i][j].getChildren().add(ipb);
                                //e.MetEnEchec(e.echiquier[i][j].piece,e.Rn, e);
                                
                            }
                            else{
                                ImageView ipn = new ImageView(im2);
                                ipn.setScaleX(1.4);
                                ipn.setScaleY(1.4);
                                tab[i][j].getChildren().add(ipn);
                                //boolean echec =e.MetEnEchec(e.echiquier[i][j].piece,e.Rb, e);
                                
                            }
                            
                        }
                        else if(e.echiquier[i][j].piece.nom == "T"){
                            if(e.echiquier[i][j].piece.numcouleur == 1){
                                ImageView itb = new ImageView(im7);
                                itb.setScaleX(1.4);
                                itb.setScaleY(1.4);
                                tab[i][j].getChildren().add(itb);
                                //boolean echec =e.MetEnEchec(e.echiquier[i][j].piece,e.Rn, e);
                                
                            }
                            else{
                                ImageView itn = new ImageView(im6);
                                itn.setScaleX(1.4);
                                itn.setScaleY(1.4);
                                tab[i][j].getChildren().add(itn);
                                //boolean echec = e.MetEnEchec(e.echiquier[i][j].piece,e.Rb, e);
                                
                            }
                        }
                        else if(e.echiquier[i][j].piece.nom == "C"){
                            if(e.echiquier[i][j].piece.numcouleur == 1){
                                ImageView icb = new ImageView(im12);
                                icb.setScaleX(1.4);
                                icb.setScaleY(1.4);
                                tab[i][j].getChildren().add(icb);
                                //boolean echec =e.MetEnEchec(e.echiquier[i][j].piece,e.Rn, e);
                                
                            }
                            else{
                                ImageView icn = new ImageView(im3);
                                icn.setScaleX(1.4);
                                icn.setScaleY(1.4);
                                tab[i][j].getChildren().add(icn);
                                //boolean echec =e.MetEnEchec(e.echiquier[i][j].piece,e.Rb, e);
                                
                                
                            }
                        }
                        else if(e.echiquier[i][j].piece.nom == "F"){
                            if(e.echiquier[i][j].piece.numcouleur == 1){
                                ImageView ifb = new ImageView(im4);
                                ifb.setScaleX(1.4);
                                ifb.setScaleY(1.4);
                                tab[i][j].getChildren().add(ifb);
                                //boolean echec =e.MetEnEchec(e.echiquier[i][j].piece,e.Rn, e);
                                
                            }
                            else{
                                ImageView ifn = new ImageView(im5);
                                ifn.setScaleX(1.4);
                                ifn.setScaleY(1.4);
                                tab[i][j].getChildren().add(ifn);
                                //boolean echec =e.MetEnEchec(e.echiquier[i][j].piece,e.Rb, e);
                                
                            }
                        }
                        else if(e.echiquier[i][j].piece.nom == "R"){
                            if(e.echiquier[i][j].piece.numcouleur == 1){
                                ImageView irb = new ImageView(im8);
                                irb.setScaleX(1.4);
                                irb.setScaleY(1.4);
                                tab[i][j].getChildren().add(irb);
                            }
                            else{
                                ImageView irn = new ImageView(im9);
                                irn.setScaleX(1.4);
                                irn.setScaleY(1.4);
                                tab[i][j].getChildren().add(irn);
                            }
                        }
                        else if(e.echiquier[i][j].piece.nom == "D"){
                            if(e.echiquier[i][j].piece.numcouleur == 1){
                                ImageView idb = new ImageView(im11);
                                idb.setScaleX(1.4);
                                idb.setScaleY(1.4);
                                tab[i][j].getChildren().add(idb);
                                //boolean echec = e.MetEnEchec(e.echiquier[i][j].piece,e.Rn, e);
                                
                            }
                            else{
                                ImageView idn = new ImageView(im10);
                                idn.setScaleX(1.4);
                                idn.setScaleY(1.4);
                                tab[i][j].getChildren().add(idn);
                                //boolean echec =e.MetEnEchec(e.echiquier[i][j].piece,e.Rb, e);
                                
                            }
                        }
                        
                    
                }
            }
            
        }
            
        }
   
    catch(FileNotFoundException e1){
System.out.println("le fichier demandé n'existe pas");
    }        
       /* avec les lettres */
        //for(int i=0;i<8;i++){
            //for(int j=0;j<8;j++){
                
                //if(e.echiquier[i][j].piece!=null){
                    //Text t = new Text(10,50,e.echiquier[i][j].piece.nom);
                    //tab[i][j].getChildren().add(t);
                    
               // }
            //}
        
        }
    }
    //public void MOUSE_CLICKED(MouseEvent e) {
        //Point pt = new Point();
        //pt.x = (int) e.getSceneX();
        //pt.y = (int) e.getSceneY();
        //pt.x/=100; //echelle de largeur = 800/8=100
        //pt.y/=100; //echelle de hauteur = 800/8 = 100
        //System.out.println("Ca marche");
        
        
    //}

    
    
   
    
   
        
        
        
        
 

