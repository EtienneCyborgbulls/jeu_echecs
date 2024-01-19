/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package echec;

/**
 *
 * @author etien
 */
public class Tour extends Piece {
    int nbtourtour =0;
    public Tour(int numcouleur,Case c) {
        super(numcouleur,c);
        nom="T";
    }

    public boolean mouvement(Case c, Case casedesiree, Echiquier e) {

        if (c.piece instanceof Tour) {
                if(numcouleur==0){ //pièces noires en haut
                    if(casedesiree.colonne == c.colonne && casedesiree.ligne > c.ligne){
                        boolean res1 = mvtColonneVersLeBas(c, casedesiree,  e);
                        if(res1){
                            nbtourtour++;
                        }
                        return res1;
                    }
                    else if(casedesiree.colonne == c.colonne && casedesiree.ligne < c.ligne){
                        boolean res4 = mvtColonneVersLeHaut(c, casedesiree,  e);
                        if(res4){
                            nbtourtour++;
                        }
                        return res4;
                    }
                    else if(casedesiree.ligne == c.ligne && casedesiree.colonne < c.colonne){
                        boolean res3 = mvtLigneVersLaGauche(c, casedesiree,  e);
                        if(res3){
                            nbtourtour++;
                        }
                        return res3;
                    }
                    else if (casedesiree.ligne == c.ligne && casedesiree.colonne > c.colonne){
                        boolean res2 = mvtLigneVersLaDroite(c, casedesiree,  e);
                        if(res2){
                            nbtourtour++;
                        }
                        return res2;
                    }
                    //boolean res2 = mvtLigneVersLaDroite(c, casedesiree,  e);
                    //boolean res3 = mvtLigneVersLaGauche(c, casedesiree,  e);
                    
                    
                    //if(!res1 && !res2 && !res3 && !res4){
                        //return false;
                    //}
                    //else{
                        //return true;
                    //}
                }
                else{
                    if(casedesiree.colonne == c.colonne && casedesiree.ligne > c.ligne){
                        boolean res1 = mvtColonneVersLeBas(c, casedesiree,  e);
                        if(res1){
                            nbtourtour++;
                        }
                        return res1;
                    }
                    else if(casedesiree.colonne == c.colonne && casedesiree.ligne < c.ligne){
                        boolean res4 = mvtColonneVersLeHaut(c, casedesiree,  e);
                        if(res4){
                            nbtourtour++;
                        }
                        return res4;
                    }
                    else if(casedesiree.ligne == c.ligne && casedesiree.colonne < c.colonne){
                        boolean res3 = mvtLigneVersLaGauche(c, casedesiree,  e);
                        if(res3){
                            nbtourtour++;
                        }
                        return res3;
                    }
                    else if (casedesiree.ligne == c.ligne && casedesiree.colonne > c.colonne){
                        boolean res2 = mvtLigneVersLaDroite(c, casedesiree,  e);
                        if(res2){
                            nbtourtour++;
                        }
                        return res2;
                    }
                }

        }
        return false;
       
    }
}
