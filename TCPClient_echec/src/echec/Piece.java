/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package echec;

/**
 * Classe abstraite qui représente les pièces 
 * @author etien
 */
public abstract class Piece {
    //nom de la pièce
    String nom;
    //couleur de la pièce
    int numcouleur; //Pour le noir numcouleur = 0; Pour le blanc numcouleur =1;
    
    Echiquier e;
    //la pièce connait la case sur laquelle elle est
    Case c;
    boolean mouvement = true;
    
    public Piece(int numcouleur,Case c){
        this.numcouleur = numcouleur;
        this.c = c;
        
    }
    /**
     * 
     * @param c la case de départ de la pièce sur laquelle clique l'utilisateur
     * @param casedesiree la case desirée par l'utilisateur pour bouger la pièce
     * @param e l'échiquier
     * @return true si le mouvement est possible, false sinon
     */
    abstract boolean mouvement(Case c, Case casedesiree, Echiquier e);
    
    /*méthode pour savoir si le mouvement de la case c est possible vers la case
    desirée, ici on regarde le mvt sur la colonne en bas de la case c
    */
    public boolean mvtColonneVersLeBas(Case c, Case casedesiree, Echiquier e){
        int i=c.ligne+1;
        /*i correspond à la coordonnée en ligne du 1er obstacle éventuel 
        recontré en allant vers le bas. On la trouve dans le while
        */
        while (e.echiquier[c.colonne][i].piece == null && i <=6 ){ 
            i++;
        }
        if (i-1>=casedesiree.ligne && casedesiree.ligne > c.ligne && casedesiree.colonne==c.colonne){
            //on peut faire le mouvement car il n'y a pas de pièces sur le chemin
            return true;
        }
        else if (i==casedesiree.ligne && casedesiree.piece != null && casedesiree.piece.numcouleur!=c.piece.numcouleur && casedesiree.colonne==c.colonne){
            //le 1er obstacle est un ennemi. On peut donc faire le mouvement et manger la pièce adverse
            return true;
        }
        else if (i==casedesiree.ligne && casedesiree.ligne > c.ligne && casedesiree.colonne==c.colonne && casedesiree.piece == null){
            //cas où on rencontre pas de pièce, on est donc tout en bas du plateau et on fait le mouvement
            return true;
        }
        else{
            // autre cas où il n'a pas de mvt
            return false;
        }
    }
    /*méthode pour savoir si le mouvement de la case c est possible vers la case
    desirée, ici on regarde le mvt sur la colonne en haut de la case c
    */
    public boolean mvtColonneVersLeHaut(Case c, Case casedesiree, Echiquier e){
        int i=c.ligne-1; 
        /*i correspond à la coordonnée en ligne du 1er obstacle éventuel 
        recontré en allant vers le haut. On la trouve dans le while
        */
        while (e.echiquier[c.colonne][i].piece == null && i>=1 ){ 
                i--;
        }
        //même idée que pour mvtColonneVersLeBas
        if (i+1<=casedesiree.ligne && casedesiree.ligne < c.ligne && casedesiree.colonne==c.colonne){
            return true;
        }
        else if (i==casedesiree.ligne && casedesiree.piece != null && casedesiree.piece.numcouleur!=c.piece.numcouleur && casedesiree.colonne==c.colonne){
            return true;
        }
        else if(i==casedesiree.ligne && casedesiree.piece == null && casedesiree.ligne < c.ligne && casedesiree.colonne==c.colonne){
            return true;
        }
        else{
            return false;
        }
        
    }
    /*méthode pour savoir si le mouvement de la case c est possible vers la case
    desirée, ici on regarde le mvt sur la ligne à droite de la case c
    */
    public boolean mvtLigneVersLaDroite(Case c, Case casedesiree, Echiquier e){
        int i=c.colonne+1; 
        /*i correspond à la coordonnée en colonne du 1er obstacle éventuel 
        recontré en allant vers la droite. On la trouve dans le while
        */
        while (e.echiquier[i][c.ligne].piece==null && i<=6){ 
           i++;
        }
        if (i-1>=casedesiree.colonne && casedesiree.colonne > c.colonne && casedesiree.ligne==c.ligne){
            //on peut faire le mouvement car il n'y a pas de pièces sur le chemin
            return true;
        }
        else if (i==casedesiree.colonne && casedesiree.piece != null && casedesiree.piece.numcouleur!=c.piece.numcouleur && casedesiree.ligne==c.ligne){
            //le 1er obstacle est un ennemi. On peut donc faire le mouvement et manger la pièce adverse
            return true;
        }
        else if (i==casedesiree.colonne && casedesiree.piece == null && casedesiree.colonne > c.colonne && casedesiree.ligne==c.ligne){
            //cas où on rencontre pas de pièce, on est donc tout à droite du plateau et on fait le mouvement
            return true;
        }
        else{
            return false;
        }
        
    }
    /*méthode pour savoir si le mouvement de la case c est possible vers la case
    desirée, ici on regarde le mvt sur la ligne à gauche de la case c
    */
    public boolean mvtLigneVersLaGauche(Case c, Case casedesiree, Echiquier e){
        int i=c.colonne-1; 
        /*i correspond à la coordonnée en colonne du 1er obstacle éventuel 
        recontré en allant vers la droite. On la trouve dans le while
        */
        while (e.echiquier[i][c.ligne].piece==null && i>=1){ 
            i--;
        }
        //même idée que mvtLigneVersLaDroite
        if (i+1<=casedesiree.colonne && casedesiree.colonne < c.colonne && casedesiree.ligne==c.ligne){
            return true;
        }
        else if (i==casedesiree.colonne && casedesiree.piece != null && casedesiree.piece.numcouleur!=c.piece.numcouleur  && casedesiree.ligne==c.ligne){
            return true;
        }
        else if(i==casedesiree.colonne && casedesiree.piece == null && casedesiree.colonne < c.colonne && casedesiree.ligne==c.ligne){
            return true;
        }
        else{
            return false;
        }
    }      
    /*méthode pour savoir si le mouvement de la case c est possible vers la case
    desirée, ici on regarde le mvt en diagonale en bas à droite de la case c
    */
    boolean mvtDiagonaleBD(Case c ,Case casedesiree, Echiquier e){
        int i = c.ligne+1;
        int j = c.colonne+1;
        /*i et j correspond respectivment à la coordonnée en ligne et en colonne 
        du 1er obstacle éventuel recontré en allant en bas à gauche. 
        On la trouve dans le while
            */
        while(e.echiquier[j][i].piece == null && i<=6 && j <=6){
            i++;
            j++;
        }
        //double rd = (casedesiree.ligne-c.ligne)%(casedesiree.colonne-c.colonne);
        //System.out.println(""+rd); il faut que rd soit égale à 0 ce qui signifie que le coeff directeur est éggale à 1
        if(casedesiree.colonne <= j-1 && casedesiree.ligne <= i-1 && Math.abs(casedesiree.ligne-c.ligne)%(casedesiree.colonne-c.colonne)==0 && Math.abs(casedesiree.ligne-c.ligne)/(casedesiree.colonne-c.colonne)==1){
            // cas pas de pièces sur le chemin et on peut faire le mouvement
            return true;
        }
        else if(casedesiree.colonne == j && casedesiree.ligne == i && casedesiree.piece != null && casedesiree.piece.numcouleur!=c.piece.numcouleur && Math.abs(casedesiree.ligne-c.ligne)/(casedesiree.colonne-c.colonne)==1 &&  Math.abs(casedesiree.ligne-c.ligne)%(casedesiree.colonne-c.colonne)==0){
            //le 1er obstacle est un ennemi. On peut donc faire le mouvement et manger la pièce adverse
            return true;
        }
        else if(casedesiree.colonne == j && casedesiree.ligne == i && casedesiree.piece == null && Math.abs(casedesiree.ligne-c.ligne)%(casedesiree.colonne-c.colonne)==0 && Math.abs(casedesiree.ligne-c.ligne)/(casedesiree.colonne-c.colonne)==1){
            //cas où on rencontre pas de pièce, on est aux extrêmités du plateau et on fait le mouvement
            return true;
        }
        else{
            return false;
        }
    }
    /*méthode pour savoir si le mouvement de la case c est possible vers la case
    desirée, ici on regarde le mvt en diagonale en bas à gauche de la case c
    */
    public boolean mvtDiagonaleBG(Case c, Case casedesiree, Echiquier e){
        int i = c.ligne+1;
        int j = c.colonne-1;
        // même schéma que mvtDiagonaleBG pour cette méthode et les prochaines
        while(e.echiquier[j][i].piece == null && i<=6 && j >=1){
            i++;
            j--;
        }
        if(casedesiree.colonne >= j+1 && casedesiree.ligne <= i-1 && (casedesiree.ligne-c.ligne)%(casedesiree.colonne-c.colonne)==0 && (casedesiree.ligne-c.ligne)/(casedesiree.colonne-c.colonne)==-1){

            return true;
        }
        else if(casedesiree.colonne == j && casedesiree.ligne == i && casedesiree.piece != null && casedesiree.piece.numcouleur!=c.piece.numcouleur && (casedesiree.ligne-c.ligne)%(casedesiree.colonne-c.colonne)==0 && (casedesiree.ligne-c.ligne)/(casedesiree.colonne-c.colonne)==-1){
            return true;
        }
        else if(casedesiree.colonne == j && casedesiree.ligne == i && casedesiree.piece == null && (casedesiree.ligne-c.ligne)%(casedesiree.colonne-c.colonne)==0 && (casedesiree.ligne-c.ligne)/(casedesiree.colonne-c.colonne)==-1){
            return true;
        }
        else{
            return false;
        }
    }
    /*méthode pour savoir si le mouvement de la case c est possible vers la case
    desirée, ici on regarde le mvt en diagonale en haut à droite de la case c
    */
    public boolean mvtDiagonaleHD(Case c, Case casedesiree, Echiquier e){
        int i = c.ligne-1;
        int j = c.colonne+1;
    
        while(e.echiquier[j][i].piece == null && i>=1 && j <=6){
            i--;
            j++;   
        }
        if(casedesiree.colonne <= j-1 && casedesiree.ligne >= i+1 && Math.abs(casedesiree.ligne-c.ligne)%(casedesiree.colonne-c.colonne)==0 && Math.abs(casedesiree.ligne-c.ligne)/(casedesiree.colonne-c.colonne)==1){
            return true;
        }
        else if(casedesiree.colonne == j && casedesiree.ligne == i && Math.abs(casedesiree.ligne-c.ligne)%(casedesiree.colonne-c.colonne)==0 && Math.abs(casedesiree.ligne-c.ligne)/(casedesiree.colonne-c.colonne)==1){
            return true;
        }
        else if(casedesiree.colonne == j && casedesiree.ligne == i && casedesiree.piece == null && Math.abs(casedesiree.ligne-c.ligne)%(casedesiree.colonne-c.colonne)==0 && Math.abs(casedesiree.ligne-c.ligne)/(casedesiree.colonne-c.colonne)==1){
            return true;
        }
        else{
            return false;
        }
    }
    /*méthode pour savoir si le mouvement de la case c est possible vers la case
    desirée, ici on regarde le mvt en diagonale en haut à gauche de la case c
    */
    public boolean mvtDiagonaleHG(Case c, Case casedesiree, Echiquier e){
        int i = c.ligne-1;
        int j = c.colonne-1;
        while(e.echiquier[j][i].piece == null && i>=1 && j >=1){
            i--;
            j--;  
        }
        if(casedesiree.colonne >= j+1 && casedesiree.ligne >= i+1 && (casedesiree.ligne-c.ligne)%(casedesiree.colonne-c.colonne)==0 && (casedesiree.ligne-c.ligne)/(casedesiree.colonne-c.colonne)==1){
            return true;
        }
        else if(casedesiree.colonne == j && casedesiree.ligne == i && casedesiree.piece != null && casedesiree.piece.numcouleur!=c.piece.numcouleur && (casedesiree.ligne-c.ligne)%(casedesiree.colonne-c.colonne)==0 && (casedesiree.ligne-c.ligne)/(casedesiree.colonne-c.colonne)==1){
            return true;
        }
        else if(casedesiree.colonne == j && casedesiree.ligne == i && casedesiree.piece == null && (casedesiree.ligne-c.ligne)%(casedesiree.colonne-c.colonne)==0 && (casedesiree.ligne-c.ligne)/(casedesiree.colonne-c.colonne)==1){
            return true;
        }
        else{
            return false;
        }
    }
        

    
}
