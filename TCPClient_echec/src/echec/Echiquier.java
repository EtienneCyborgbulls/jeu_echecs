
package echec;

import javafx.application.Platform;
import tcp.Communication;
import tcp.Connectable;

/**Cette classe représente l'échiquier avec un tableau de 8 tableaux de 8 cases en attribut
 *
 * @author etienne
 * Cette classe représente l'échiquier avec un tableau de 8 tableaux de 8 cases (cela representé une matrice de taille 8x8 de cases)
 * Elle permet d'initialiser l'échiquier avec les différentes pièces sur les bonnes cases, de calculer si une pièce met en échec le roi adverse et si le roi est en échec et mat
 */
public class Echiquier implements Connectable {
    /*
    *echiquier est un tableau de 8 tableaux de 8 cases 
    *Rn est le roi noir 
    *Rn est le roi blanc
    *On a besoin de passer les rois en attributs pour connaître et utiliser leur position à chaque instant pour calculer les échecs possibles
    */
    //int nbrock = 0;
    Roi Rn;
    Roi Rb;
    Case [][] echiquier = new Case[8][8];
    
    // la fenêtre d'affichage
    Fenetre fen;
    FenetreConnexion fenc;
    // la communication
    Communication comm;
    int port;
    Echiquier e;
    
    /**
     * Constructeur d'échiquier
     * permet de créer les objets cases, de créer les objets des différentes pièces et d'initialiser leur emplacement sur les cases
     * @param port 
     */
    public Echiquier(int port){
        this.port = port;
        
        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                echiquier[i][j] = new Case(i,j,null);
            }
        }
        
        
        for(int i=0;i<8;i++){
            
            
            echiquier[i][1] = new Case(i,1,new Pion(0,echiquier[i][1])); //colonne puis ligne car gridpane
            echiquier[i][6] = new Case(i,6,new Pion(1,echiquier[i][6])); //0 pour les noirs, 1 pour les blancs
        }
        echiquier[0][0] =  new Case(0,0,new Tour(0,echiquier[0][0]));         // tout en haut à gauche
        echiquier[1][0] =  new Case(1,0,new Cavalier(0,echiquier[1][0]));     //ligne 0, colonne 1
        echiquier[2][0] =  new Case(2,0,new Fou(0,echiquier[2][0]));
        echiquier[3][0] =  new Case(3,0,new Dame(0,echiquier[3][0]));
        Roi Rn = new Roi(0,echiquier[4][0]);
        this.Rn = Rn;
        echiquier[4][0] =  new Case(4,0,Rn);
        echiquier[5][0] =  new Case(5,0,new Fou(0,echiquier[5][0]));
        echiquier[6][0] =  new Case(6,0,new Cavalier(0,echiquier[6][0]));
        echiquier[7][0] =  new Case(7,0,new Tour(0,echiquier[7][0]));
        
        echiquier[0][7] = new Case(0,7,new Tour(1,echiquier[0][7]));
        echiquier[1][7] = new Case(1,7,new Cavalier(1,echiquier[1][7]));
        echiquier[2][7] = new Case(2,7,new Fou(1,echiquier[2][7]));
        echiquier[3][7] = new Case(3,7,new Dame(1,echiquier[3][7]));
        Roi Rb = new Roi(1,echiquier[4][7]);
        this.Rb = Rb;
        echiquier[4][7] = new Case(4,7,Rb);
        echiquier[5][7] = new Case(5,7,new Fou(1,echiquier[5][7]));
        echiquier[6][7] = new Case(6,7,new Cavalier(1,echiquier[6][7]));
        echiquier[7][7] = new Case(7,7,new Tour(1,echiquier[7][7]));
        
       
    }
    /**
    * Affectation de la fenêtre au jeu.
    *
    * @param fen la fenêtre d'affichage.
    */
    public void setFenetre(Fenetre fen) {
        
        this.fen = fen;
    }
       /**
     * Création d'une communication, coté client.
     *
     * @param ip l'adresse IP du serveur
     */
    public void connecter(String ip) {
        comm = new Communication(this, ip, port);
    }

    /**
     * Emission d'un message
     *
     * @param mess le message à envoyer.
     */
    public void envoyer(String mess) {
        comm.emettre(mess);
        
        System.out.println("--> " + mess);
    }

    /**
     * Affectation de la communication.
     *
     * @param comm la communication établie.
     */
    public void set(Communication comm) {
        this.comm = comm;
    }

    /**
     * Réception d'un message transmis par le récepteur.
     * Actualisation sur l'interface graphique du coup réalisé par l'adversaire
     * @param mess le message reçu.
     */
    public void recevoir(String mess) {
        System.out.println("<-- : " + mess);
        
        if(mess.charAt(0) == 'P' && mess.charAt(1) == 'P'){
            //Prise en passant
            int ligne = Integer.parseInt(String.valueOf(mess.charAt(4))); 
            int colonne= Integer.parseInt(String.valueOf(mess.charAt(3)));
            fen.e.echiquier[colonne][ligne].piece = null;
            
        }
        else if( (mess.charAt(0) == 'P' || mess.charAt(0) == 'G') && mess.charAt(1) == 'R'){
            //Grand Roque et Petit Roque
            int ligneCaseDepart = Integer.parseInt(String.valueOf(mess.charAt(4))); 
            int colonneCaseDepart = Integer.parseInt(String.valueOf(mess.charAt(3)));
        
            int ligneCaseArrivee = Integer.parseInt(String.valueOf(mess.charAt(7)));
            int colonneCaseArrivee = Integer.parseInt(String.valueOf(mess.charAt(6)));
            
            fen.e.echiquier[colonneCaseArrivee][ligneCaseArrivee].piece = fen.e.echiquier[colonneCaseDepart][ligneCaseDepart].piece;
            fen.e.echiquier[colonneCaseArrivee][ligneCaseArrivee].piece.c = fen.e.echiquier[colonneCaseArrivee][ligneCaseArrivee];
            fen.e.echiquier[colonneCaseDepart][ligneCaseDepart].piece = null;
            
        }
        else{
        
        String nompiece =  String.valueOf(mess.charAt(0));
        
        
        int ligneCaseDepart = Integer.parseInt(String.valueOf(mess.charAt(3))); 
        int colonneCaseDepart = Integer.parseInt(String.valueOf(mess.charAt(2)));
        
        int ligneCaseArrivee = Integer.parseInt(String.valueOf(mess.charAt(6)));
        int colonneCaseArrivee = Integer.parseInt(String.valueOf(mess.charAt(5)));
        
        if(nompiece.equals("P")){
            Pion p = (Pion) fen.e.echiquier[colonneCaseDepart][ligneCaseDepart].piece;
            p.nbtourpion++;
            p.numDuTourOuAEteFaitLavanceeDeDeuxCases = Integer.parseInt(String.valueOf(mess.charAt(8))); 
        }
        else if(nompiece.equals("T")){
            Tour t = (Tour)fen.e.echiquier[colonneCaseDepart][ligneCaseDepart].piece;
            t.nbtourtour++;
        }
        else if(nompiece.equals("R")){
            Roi r = (Roi) fen.e.echiquier[colonneCaseDepart][ligneCaseDepart].piece;
            r.nbtourroi++;
        }
        
        fen.e.echiquier[colonneCaseArrivee][ligneCaseArrivee].piece = fen.e.echiquier[colonneCaseDepart][ligneCaseDepart].piece;
        fen.e.echiquier[colonneCaseArrivee][ligneCaseArrivee].piece.c = fen.e.echiquier[colonneCaseArrivee][ligneCaseArrivee];
        fen.e.echiquier[colonneCaseDepart][ligneCaseDepart].piece = null;
        
        Platform.runLater(new Runnable() {
        @Override
         public void run() {
        // code qui modifie l'interface graphique va ici
        
            fen.remplir();
            
        }
        });
        fen.nbtour++;
        }
    }

    /**
     * Détermine si une pièce met en échec le roi adverse ou non
     * @param p la pièce qui peut potentiellement mettre en échec le roi adverse
     * @param r le roi adverse de la pièce
     * @param e l'échiquier (l'objet de la classe échiquier)
     * @return true si la pièce met le roi adverse en échec et false sinon
     */
    public boolean MetEnEchec(Piece p,Roi r,Echiquier e){
        //il faut que la pièce et le roi soient ennemis
        if(p != null && p.numcouleur != r.numcouleur){
            //on teste si le mouvement de la pièce sur la case du roi adverse est possible
            if(p.mouvement(p.c,r.c,e)){
                        System.out.println("Le roi est en échec");
                        
                        return true;
            }
            else{
                        return false;
            }
        }
        else{
            return false;
        }
    }
    /**
     * Détermine si le roi du joueur qui joue est en échec et mat
     * @param nbtour le nombre de tours dans la partie pour savoir quel joueur est en train de jouer
     * @param e l'échiquier
     * @return true s'il y a echec et mat, false sinon
     */
    public boolean EchecEtMat(int nbtour, Echiquier e){
        //
        int compteur = 0; //compteur est une variable qui va compter le nombre de pièces qui mettent le roi en échec
        //c'est au joueur 1 de jouer (celui qui joue les blancs)
        if(nbtour%2 == 0){
        //on parcourt toutes les cases pour trouver les pièces blanches
        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                
                    if(e.echiquier[i][j].piece != null && e.echiquier[i][j].piece.numcouleur == e.Rb.numcouleur){
                        
                        for(int n=0;n<8;n++){
                            for(int m=0;m<8;m++){
                                //on teste le mouvement des pièces blanches sur toutes les cases de l'échiquier
                                if(e.echiquier[i][j].piece.mouvement(e.echiquier[i][j],e.echiquier[n][m],e)){
                                    //System.out.println(e.echiquier[i][j].piece.nom + "peut se déplacer sur les cases" + n + " "+m);
                                    /*si le mouvement est possible
                                    *on fait le mouvement de la pièce blanche sans actualisation de l'interface graphique
                                    */
                                    Piece copie = e.echiquier[n][m].piece;
                                    e.echiquier[n][m].piece = e.echiquier[i][j].piece;
                                    e.echiquier[n][m].piece.c = e.echiquier[n][m];
                                    e.echiquier[i][j].piece=null;
                                    compteur = 0;
                                    //on parcourt toutes les cases pour trouver les pièces noires
                                    for(int p =0;p<8;p++){
                                        for(int q=0;q<8;q++){
                                            
                                            if(e.echiquier[p][q].piece !=null && e.echiquier[p][q].piece.numcouleur != e.Rb.numcouleur){
                                                //on regarde si la pièce noire met le roi blanc en échec après le mouvement d'une des pièces blanches
                                                if(e.MetEnEchec(e.echiquier[p][q].piece, e.Rb, e)){
                                                    //on incrémente compteur si la pièce noir met le roi blanc en échec
                                                    compteur++;
                                                    
                                                }
                                                
                                            }
                                        }
                                    }
                                    //si compteur vaut 0 cela veut dire qu'aucune pièce noire ne met le roi blanc en échec
                                    //après le mouvement d'une des pièces blanches
                                    if(compteur==0){ 
                                        //on réinitialise les positions des pièces avant le mouvement 
                                        e.echiquier[i][j].piece=e.echiquier[n][m].piece;
                                        e.echiquier[n][m].piece = copie;
                                        e.echiquier[i][j].piece.c = e.echiquier[i][j];
                                        /*si on a déplacé un pion (sans l'actualisation graphique)
                                        *il faut remettre son attribut nbtourpion à sa valeur avant le mouvement
                                        */
                                        if(e.echiquier[i][j].piece instanceof Pion){
                                            Pion pion = (Pion) e.echiquier[i][j].piece;
                                            pion.nbtourpion--;
                                        }
                                        //il n'y a donc pas d'échec et mat
                                        return false;
                                    }
                                    //sinon il n'y a pas forcément d'échec et mat
                                    else{
                                        //on réinitialise les positions des pièces avant le mouvement
                                        e.echiquier[i][j].piece=e.echiquier[n][m].piece;
                                        e.echiquier[n][m].piece = copie;
                                        e.echiquier[i][j].piece.c = e.echiquier[i][j];
                                        if(e.echiquier[i][j].piece instanceof Pion){
                                            Pion pion = (Pion) e.echiquier[i][j].piece;
                                            pion.nbtourpion--;
                                        }
                                    }
                                    
                                    
                            }
                        }
                    }
                }
            }
            
            }
            //une fois qu'on a testé le mouvement de toutes les pièces et que le roi est en échec dans tous les cas
            //alors il y a échec et mat
            System.out.println("Echec et Mat");
            return true;
            }
            //c'est au joueur 2 de jouer (celui qui joue les noirs)
            else{ 
            for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                
                    if(e.echiquier[i][j].piece != null && e.echiquier[i][j].piece.numcouleur == e.Rn.numcouleur){
                        for(int n=0;n<8;n++){
                            for(int m=0;m<8;m++){
                                if(e.echiquier[i][j].piece.mouvement(e.echiquier[i][j],e.echiquier[n][m],e)){
                                    System.out.println(e.echiquier[i][j].piece.nom + "peut se déplacer sur les cases" + n + " "+m);
                                    Piece copie = e.echiquier[n][m].piece;
                                    e.echiquier[n][m].piece = e.echiquier[i][j].piece;
                                    e.echiquier[n][m].piece.c = e.echiquier[n][m];
                                    e.echiquier[i][j].piece=null;
                                    compteur = 0;
                                    for(int p =0;p<8;p++){
                                        for(int q=0;q<8;q++){
                                            
                                            if(e.echiquier[p][q].piece !=null && e.echiquier[p][q].piece.numcouleur != e.Rn.numcouleur){
                                                if(e.MetEnEchec(e.echiquier[p][q].piece, e.Rn, e)){
                                                    compteur++;
                                                    
                                                }
                                                
                                            }
                                        }
                                    }
                                    if(compteur==0){
                                        
                                        e.echiquier[i][j].piece=e.echiquier[n][m].piece;
                                        e.echiquier[n][m].piece = copie;
                                        e.echiquier[i][j].piece.c = e.echiquier[i][j];
                                        if(e.echiquier[i][j].piece instanceof Pion){
                                            Pion pion = (Pion) e.echiquier[i][j].piece;
                                            pion.nbtourpion--;
                                        }
                                        return false;
                                    }
                                    else{
                                        e.echiquier[i][j].piece=e.echiquier[n][m].piece;
                                        e.echiquier[n][m].piece = copie;
                                        e.echiquier[i][j].piece.c = e.echiquier[i][j];
                                        if(e.echiquier[i][j].piece instanceof Pion){
                                            Pion pion = (Pion) e.echiquier[i][j].piece;
                                            pion.nbtourpion--;
                                        }
                                    }
                                    
                                    
                            }
                        }
                    }
                }
            }                                    
                
            }  
        System.out.println("Echec et Mat");
        return true;             
        }
        
    }
    
    
    
}
