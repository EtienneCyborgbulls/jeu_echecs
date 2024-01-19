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
public class Dame extends Piece {
    
    public Dame(int numcouleur,Case c){
        super(numcouleur,c);
        nom="D";
    }
    public boolean mouvement(Case c, Case casedesiree, Echiquier e){
        
        if(c.piece instanceof Dame){
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
                else if(casedesiree.colonne == c.colonne && casedesiree.ligne > c.ligne){
                    boolean res5 = mvtColonneVersLeBas(c, casedesiree,  e);
                    return res5;
                }
                else if(casedesiree.colonne == c.colonne && casedesiree.ligne < c.ligne){
                    boolean res6 = mvtColonneVersLeHaut(c, casedesiree,  e);
                    return res6;
                }
                else if(casedesiree.ligne == c.ligne && casedesiree.colonne < c.colonne){
                    boolean res7 = mvtLigneVersLaGauche(c, casedesiree,  e);
                    return res7;
                }
                else if (casedesiree.ligne == c.ligne && casedesiree.colonne > c.colonne){
                    boolean res8 = mvtLigneVersLaDroite(c, casedesiree,  e);
                    return res8;
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
                 else if(casedesiree.colonne == c.colonne && casedesiree.ligne > c.ligne){
                    boolean res5 = mvtColonneVersLeBas(c, casedesiree,  e);
                    return res5;
                }
                else if(casedesiree.colonne == c.colonne && casedesiree.ligne < c.ligne){
                    boolean res6 = mvtColonneVersLeHaut(c, casedesiree,  e);
                    return res6;
                }
                else if(casedesiree.ligne == c.ligne && casedesiree.colonne < c.colonne){
                    boolean res7 = mvtLigneVersLaGauche(c, casedesiree,  e);
                    return res7;
                }
                else if (casedesiree.ligne == c.ligne && casedesiree.colonne > c.colonne){
                    boolean res8 = mvtLigneVersLaDroite(c, casedesiree,  e);
                    return res8;
                }
                
            }
        }
            
         
    
          
    return false;
}
}
