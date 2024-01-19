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
public class Cavalier extends Piece {
    
    public Cavalier(int numcouleur,Case c){
        super(numcouleur,c);
        nom="C";
    }
    
public boolean mouvement(Case c, Case casedesiree, Echiquier e){
    if(c.piece instanceof Cavalier){
    if(numcouleur == 0){
        if(casedesiree.colonne == c.colonne+1 && casedesiree.ligne == c.ligne +2){
            if(casedesiree.piece == null){
                
                return true;
            }
            else if(casedesiree.piece != null && casedesiree.piece.numcouleur != c.piece.numcouleur){
                
                return true;
            }
            else{
                
                return false;
            }
        }
        else if (casedesiree.colonne == c.colonne+2 && casedesiree.ligne == c.ligne+1){
            if(casedesiree.piece == null){
                
                return true;
            }
            else if(casedesiree.piece != null && casedesiree.piece.numcouleur != c.piece.numcouleur){
                
                return true;
            }
            else{
                
                return false;
            }
        }
        else if(casedesiree.colonne == c.colonne+2 && casedesiree.ligne == c.ligne-1){
            if(casedesiree.piece == null){
               
                return true;
            }
            else if(casedesiree.piece != null && casedesiree.piece.numcouleur != c.piece.numcouleur){
               
                return true;
            }
            else{
                
                return false;
            }
        }
        else if(casedesiree.colonne == c.colonne+1 && casedesiree.ligne == c.ligne-2){
            if(casedesiree.piece == null){
                
                return true;
            }
            else if(casedesiree.piece != null && casedesiree.piece.numcouleur != c.piece.numcouleur){
                
                return true;
            }
            else{
                
                return false;
            }
        }
        else if(casedesiree.colonne == c.colonne-1 && casedesiree.ligne == c.ligne-2){
            if(casedesiree.piece == null){
                
                return true;
            }
            else if(casedesiree.piece != null && casedesiree.piece.numcouleur != c.piece.numcouleur){
                
                return true;
            }
            else{
                
                return false;
            }
        }
        else if(casedesiree.colonne == c.colonne-2 && casedesiree.ligne == c.ligne-1){
            if(casedesiree.piece == null){
                
                return true;
            }
            else if(casedesiree.piece != null && casedesiree.piece.numcouleur != c.piece.numcouleur){
                
                return true;
            }
            else{
                
                return false;
            }
        }
        else if(casedesiree.colonne == c.colonne-2 && casedesiree.ligne == c.ligne+1){
            if(casedesiree.piece == null){
                
                return true;
            }
            else if(casedesiree.piece != null && casedesiree.piece.numcouleur != c.piece.numcouleur){
                
                return true;
            }
            else{
                
                return false;
            }
        }
        else if(casedesiree.colonne == c.colonne-1 && casedesiree.ligne == c.ligne+2){
            if(casedesiree.piece == null){
                
                return true;
            }
            else if(casedesiree.piece != null && casedesiree.piece.numcouleur != c.piece.numcouleur){
                
                return true;
            }
            else{
                
                return false;
            }
        }
    }
    else{
        if(casedesiree.colonne == c.colonne+1 && casedesiree.ligne == c.ligne +2){
            if(casedesiree.piece == null){
                
                return true;
            }
            else if(casedesiree.piece != null && casedesiree.piece.numcouleur != c.piece.numcouleur){
                
                return true;
            }
            else{
                //System.out.println("Mouvement non possible");
                return false;
            }
        }
        else if (casedesiree.colonne == c.colonne+2 && casedesiree.ligne == c.ligne+1){
            if(casedesiree.piece == null){
                
                return true;
            }
            else if(casedesiree.piece != null && casedesiree.piece.numcouleur != c.piece.numcouleur){
                
                return true;
            }
            else{
                
                return false;
            }
        }
        else if(casedesiree.colonne == c.colonne+2 && casedesiree.ligne == c.ligne-1){
            if(casedesiree.piece == null){
                
                return true;
            }
            else if(casedesiree.piece != null && casedesiree.piece.numcouleur != c.piece.numcouleur){
                
                return true;
            }
            else{
                
                return false;
            }
        }
        else if(casedesiree.colonne == c.colonne+1 && casedesiree.ligne == c.ligne-2){
            if(casedesiree.piece == null){
                
                return true;
            }
            else if(casedesiree.piece != null && casedesiree.piece.numcouleur != c.piece.numcouleur){
                
                return true;
            }
            else{
                
                return false;
            }
        }
        else if(casedesiree.colonne == c.colonne-1 && casedesiree.ligne == c.ligne-2){
            if(casedesiree.piece == null){
                
                return true;
            }
            else if(casedesiree.piece != null && casedesiree.piece.numcouleur != c.piece.numcouleur){
               
                return true;
            }
            else{
                
                return false;
            }
        }
        else if(casedesiree.colonne == c.colonne-2 && casedesiree.ligne == c.ligne-1){
            if(casedesiree.piece == null){
                
                return true;
            }
            else if(casedesiree.piece != null && casedesiree.piece.numcouleur != c.piece.numcouleur){
                
                return true;
            }
            else{
                
                return false;
            }
        }
        else if(casedesiree.colonne == c.colonne-2 && casedesiree.ligne == c.ligne+1){
            if(casedesiree.piece == null){
                
                return true;
            }
            else if(casedesiree.piece != null && casedesiree.piece.numcouleur != c.piece.numcouleur){
                
                return true;
            }
            else{
                
                return false;
            }
        }
        else if(casedesiree.colonne == c.colonne-1 && casedesiree.ligne == c.ligne+2){
            if(casedesiree.piece == null){
                
                return true;
            }
            else if(casedesiree.piece != null && casedesiree.piece.numcouleur != c.piece.numcouleur){
                
                return true;
            }
            else{
                
                return false;
            }
        }
        
    }
    }
        
    return false;
    }
}
