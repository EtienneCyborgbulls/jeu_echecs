/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package echec;

/**
 *  Classe répresentant une case dans l'échiquier
 *  La case connaît ses coordonnées (ligne et colonne) dans l'échiquier et la pièce qui est dessus
 * @author etien
 */



public class Case {
    
    int ligne;
    int colonne;
    
    Piece piece;
    /**
     * Constructeur de case
     * @param c la colonne de la case dans l'échiquier
     * @param l la ligne de la case dans l'échiquier
     * @param p la pièce sur la case
     */
    public Case(int c, int l, Piece p){
        ligne = l;
        colonne = c;
        piece = p;
    }

}
