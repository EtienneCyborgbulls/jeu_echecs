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
public class Fou extends Piece {
    
    public Fou(int numcouleur,Case c){
        super(numcouleur,c);
        nom="F";
    }
    
    public boolean mouvement(Case c, Case casedesiree, Echiquier e){
        
        if(c.piece instanceof Fou){
            if(numcouleur == 0){
                if(casedesiree.colonne > c.colonne && casedesiree.ligne > c.ligne){
                    boolean res1 = mvtDiagonaleBD(c,casedesiree,e);
                    return res1;
                }
                else if(casedesiree.colonne > c.colonne && casedesiree.ligne < c.ligne){
                    boolean res2 = mvtDiagonaleHD(c,casedesiree,e);
                    return res2;
                }
                else if(casedesiree.colonne < c.colonne && casedesiree.ligne < c.ligne){
                    boolean res3 = mvtDiagonaleHG(c,casedesiree,e);
                    return res3;
                }
                else if(casedesiree.colonne < c.colonne && casedesiree.ligne > c.ligne){
                    boolean res4 = mvtDiagonaleBG(c,casedesiree,e);
                    return res4;
                }
            }
            else{
                if(casedesiree.colonne > c.colonne && casedesiree.ligne > c.ligne){
                    boolean res1 = mvtDiagonaleBD(c,casedesiree,e);
                    return res1;
                }
                 else if(casedesiree.colonne > c.colonne && casedesiree.ligne < c.ligne){
                    boolean res2 = mvtDiagonaleHD(c,casedesiree,e);
                    return res2;
                }
                else if(casedesiree.colonne < c.colonne && casedesiree.ligne < c.ligne){
                    boolean res3 = mvtDiagonaleHG(c,casedesiree,e);
                    return res3;
                }
                else if(casedesiree.colonne < c.colonne && casedesiree.ligne > c.ligne){
                    boolean res4 = mvtDiagonaleBG(c,casedesiree,e);
                    return res4;
                }
                
            }
        }
        
        return false;
    }
}
