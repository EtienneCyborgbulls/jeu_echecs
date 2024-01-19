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
public class Roi extends Piece{
    int nbtourroi = 0;
    public Roi(int numcouleur, Case c){
        super(numcouleur,c);
        nom="R";
    }
    
    
    public boolean mouvement(Case c, Case casedesiree, Echiquier e){
         if(c.piece instanceof Roi){
             if(numcouleur==0){
                 if(nbtourroi==0){
                    
                    if(casedesiree.colonne == c.colonne + 2 && casedesiree.ligne == c.ligne ){
                        
                        if(e.echiquier[7][0].piece instanceof Tour && e.echiquier[7][0].piece.numcouleur == 0){
                            Tour t = (Tour) e.echiquier[7][0].piece;
                            if(t.nbtourtour == 0){
                                if(e.echiquier[5][0].piece == null && e.echiquier[6][0].piece == null){
                                    e.Rn.c = e.echiquier[5][0];
                        
                                    for(int i =0;i<8;i++){
                                        for(int j=0;j<8;j++){
                                            if(e.echiquier[i][j].piece != null && e.echiquier[i][j].piece.numcouleur == 1){
                                    
                                                if(e.MetEnEchec(e.echiquier[i][j].piece, e.Rn, e)){
                                                    
                                                    return false;
                                                }
                                    
                                            }
                                        }
                                    }
                                    e.echiquier[5][0].piece = e.echiquier[7][0].piece;
                                    e.echiquier[7][0].piece = null;
                                    e.echiquier[5][0].piece.c = e.echiquier[5][0];
                                    t.nbtourtour++;
                                    nbtourroi++;
                                    e.envoyer("PR "+ "70" + " " + "50");
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
                        else{
                            
                            return false;
                        }
                        
                    }
                    else if(casedesiree.colonne == c.colonne - 2 && casedesiree.ligne == c.ligne){
                        if(e.echiquier[0][0].piece instanceof Tour && e.echiquier[0][0].piece.numcouleur == 0){
                            Tour t = (Tour) e.echiquier[0][0].piece;
                            if(t.nbtourtour == 0){
                                if(e.echiquier[1][0].piece == null && e.echiquier[2][0].piece == null && e.echiquier[3][0].piece == null){
                                    e.Rn.c = e.echiquier[3][0];
                        
                                    for(int i =0;i<8;i++){
                                        for(int j=0;j<8;j++){
                                            if(e.echiquier[i][j].piece != null && e.echiquier[i][j].piece.numcouleur == 1){
                                    
                                                if(e.MetEnEchec(e.echiquier[i][j].piece, e.Rn, e)){
                                                    
                                                    return false;
                                                }
                                    
                                            }
                                        }
                                    }
                                    e.echiquier[3][0].piece = e.echiquier[0][0].piece;
                                    e.echiquier[0][0].piece = null;
                                    e.echiquier[3][0].piece.c = e.echiquier[3][0];
                                    t.nbtourtour++;
                                    nbtourroi++;
                                    e.envoyer("GR "+ "00" + " " + "30");
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
                        else{
                            
                            return false;
                        }
                        
                    }
                     
                    else if(casedesiree.colonne == c.colonne && casedesiree.ligne == c.ligne +1){
                    
                    if(casedesiree.piece == null){
//                        e.Rn.c = casedesiree;
//                        
//                        for(int i =0;i<8;i++){
//                            for(int j=0;j<8;j++){
//                                if(e.echiquier[i][j].piece != null && e.echiquier[i][j].piece.numcouleur == 1){
//                                    
//                                    if(e.MetEnEchec(e.echiquier[i][j].piece, e.Rn, e)){
//                                        System.out.println(e.echiquier[i][j].piece.nom + " " + i + " " + j);
//                                        return false;
//                                    }
//                                    
//                                }
//                            }
//                        }
                        nbtourroi++;
                        return true;
                        
                    }
                    
                    else if(casedesiree.piece != null && casedesiree.piece.numcouleur != c.piece.numcouleur){
//                      e.Rn.c = casedesiree;
//                        for(int i =0;i<8;i++){
//                            for(int j=0;j<8;j++){
//                                if(e.echiquier[i][j].piece != null && e.echiquier[i][j].piece.numcouleur == 1){
//                                    
//                                    if(e.MetEnEchec(e.echiquier[i][j].piece, e.Rn, e)){
//                                        return false;
//                                    }
//                                    
//                                }
//                            }
//                        }
                        nbtourroi++;
                        return true;
                    }   
                    else{
                        
                        return false;
                    }
            }
                 
                 else if(casedesiree.colonne == c.colonne +1 && casedesiree.ligne == c.ligne + 1){
                     if(casedesiree.piece == null){
                        
//                        e.Rn.c = casedesiree;
//                        for(int i =0;i<8;i++){
//                            for(int j=0;j<8;j++){
//                                if(e.echiquier[i][j].piece != null && e.echiquier[i][j].piece.numcouleur == 1){
//                                    
//                                    if(e.MetEnEchec(e.echiquier[i][j].piece, e.Rn, e)){
//                                        return false;
//                                    }
//                                    
//                                }
//                            }
//                        }
                        nbtourroi++;
                        return true;
                    }
                    else if(casedesiree.piece != null && casedesiree.piece.numcouleur != c.piece.numcouleur){
                       
//                       e.Rn.c = casedesiree;
//                        for(int i =0;i<8;i++){
//                            for(int j=0;j<8;j++){
//                                if(e.echiquier[i][j].piece != null && e.echiquier[i][j].piece.numcouleur == 1){
//                                    
//                                    if(e.MetEnEchec(e.echiquier[i][j].piece, e.Rn, e)){
//                                        return false;
//                                    }
//                                    
//                                }
//                            }
//                        }
                        nbtourroi++;
                        return true;
                    }   
                    else{
                        
                        return false;
                    }
                 }
                 else if(casedesiree.colonne == c.colonne + 1 && casedesiree.ligne == c.ligne ){
                     if(casedesiree.piece == null){
                        
//                        e.Rn.c = casedesiree;
//                        for(int i =0;i<8;i++){
//                            for(int j=0;j<8;j++){
//                                if(e.echiquier[i][j].piece != null && e.echiquier[i][j].piece.numcouleur == 1){
//                                    
//                                    if(e.MetEnEchec(e.echiquier[i][j].piece, e.Rn, e)){
//                                        return false;
//                                    }
//                                    
//                                }
//                            }
//                        }
                        nbtourroi++;
                        return true;
                    }
                    else if(casedesiree.piece != null && casedesiree.piece.numcouleur != c.piece.numcouleur){
                      
//                       e.Rn.c = casedesiree;
//                        for(int i =0;i<8;i++){
//                            for(int j=0;j<8;j++){
//                                if(e.echiquier[i][j].piece != null && e.echiquier[i][j].piece.numcouleur == 1){
//                                    
//                                    if(e.MetEnEchec(e.echiquier[i][j].piece, e.Rn, e)){
//                                        return false;
//                                    }
//                                    
//                                }
//                            }
//                        }
                        nbtourroi++;
                        return true;
                    }   
                    else{
                        
                        return false;
                    }
                 }
                 else if(casedesiree.colonne == c.colonne +1 && casedesiree.ligne == c.ligne -1){
                     if(casedesiree.piece == null){
                        
//                        e.Rn.c = casedesiree;
//                        for(int i =0;i<8;i++){
//                            for(int j=0;j<8;j++){
//                                if(e.echiquier[i][j].piece != null && e.echiquier[i][j].piece.numcouleur == 1){
//                                    
//                                    if(e.MetEnEchec(e.echiquier[i][j].piece, e.Rn, e)){
//                                        return false;
//                                    }
//                                    
//                                }
//                            }
//                        }
                        nbtourroi++;
                        return true;
                    }
                    else if(casedesiree.piece != null && casedesiree.piece.numcouleur != c.piece.numcouleur){
                       
//                       e.Rn.c = casedesiree;
//                        for(int i =0;i<8;i++){
//                            for(int j=0;j<8;j++){
//                                if(e.echiquier[i][j].piece != null && e.echiquier[i][j].piece.numcouleur == 1){
//                                    
//                                    if(e.MetEnEchec(e.echiquier[i][j].piece, e.Rn, e)){
//                                        return false;
//                                    }
//                                    
//                                }
//                            }
//                        }
                        nbtourroi++;
                        return true;
                    }   
                    else{
                        
                        return false;
                    }
                 }
                 else if(casedesiree.colonne == c.colonne && casedesiree.ligne == c.ligne -1){
                     if(casedesiree.piece == null){
                        
//                        e.Rn.c = casedesiree;
//                        for(int i =0;i<8;i++){
//                            for(int j=0;j<8;j++){
//                                if(e.echiquier[i][j].piece != null && e.echiquier[i][j].piece.numcouleur == 1){
//                                    
//                                    if(e.MetEnEchec(e.echiquier[i][j].piece, e.Rn, e)){
//                                        return false;
//                                    }
//                                    
//                                }
//                            }
//                        }
                        nbtourroi++;
                        return true;
                    }
                    else if(casedesiree.piece != null && casedesiree.piece.numcouleur != c.piece.numcouleur){
                       
//                       e.Rn.c = casedesiree;
//                        for(int i =0;i<8;i++){
//                            for(int j=0;j<8;j++){
//                                if(e.echiquier[i][j].piece != null && e.echiquier[i][j].piece.numcouleur == 1){
//                                    
//                                    if(e.MetEnEchec(e.echiquier[i][j].piece, e.Rn, e)){
//                                        return false;
//                                    }
//                                    
//                                }
//                            }
//                        }
                        nbtourroi++;
                        return true;
                    }   
                    else{
                        
                        return false;
                    }
                 }
                 else if(casedesiree.colonne == c.colonne-1 && casedesiree.ligne == c.ligne -1){
                     if(casedesiree.piece == null){
                       
//                        e.Rn.c = casedesiree;
//                        for(int i =0;i<8;i++){
//                            for(int j=0;j<8;j++){
//                                if(e.echiquier[i][j].piece != null && e.echiquier[i][j].piece.numcouleur == 1){
//                                    
//                                    if(e.MetEnEchec(e.echiquier[i][j].piece, e.Rn, e)){
//                                        return false;
//                                    }
//                                    
//                                }
//                            }
//                        }
                        nbtourroi++;
                        return true;
                    }
                    else if(casedesiree.piece != null && casedesiree.piece.numcouleur != c.piece.numcouleur){
                       
//                       e.Rn.c = casedesiree;
//                        for(int i =0;i<8;i++){
//                            for(int j=0;j<8;j++){
//                                if(e.echiquier[i][j].piece != null && e.echiquier[i][j].piece.numcouleur == 1){
//                                    
//                                    if(e.MetEnEchec(e.echiquier[i][j].piece, e.Rn, e)){
//                                        return false;
//                                    }
//                                    
//                                }
//                            }
//                        }
                        nbtourroi++;
                        return true;
                    }   
                    else{
                        
                        return false;
                    }
                 }
                 else if(casedesiree.colonne == c.colonne - 1 && casedesiree.ligne == c.ligne ){
                     if(casedesiree.piece == null){
                        
//                        e.Rn.c = casedesiree;
//                        for(int i =0;i<8;i++){
//                            for(int j=0;j<8;j++){
//                                if(e.echiquier[i][j].piece != null && e.echiquier[i][j].piece.numcouleur == 1){
//                                    
//                                    if(e.MetEnEchec(e.echiquier[i][j].piece, e.Rn, e)){
//                                        return false;
//                                    }
//                                    
//                                }
//                            }
//                        }
                        nbtourroi++;
                        return true;
                    }
                    else if(casedesiree.piece != null && casedesiree.piece.numcouleur != c.piece.numcouleur){
                       
//                       e.Rn.c = casedesiree;
//                        for(int i =0;i<8;i++){
//                            for(int j=0;j<8;j++){
//                                if(e.echiquier[i][j].piece != null && e.echiquier[i][j].piece.numcouleur == 1){
//                                    
//                                    if(e.MetEnEchec(e.echiquier[i][j].piece, e.Rn, e)){
//                                        return false;
//                                    }
//                                    
//                                }
//                            }
//                        }
                        nbtourroi++;
                        return true;
                    }   
                    else{
                        
                        return false;
                    }
                 }
                 else if(casedesiree.colonne == c.colonne -1 && casedesiree.ligne == c.ligne +1){
                     if(casedesiree.piece == null){
                        
//                        e.Rn.c = casedesiree;
//                        for(int i =0;i<8;i++){
//                            for(int j=0;j<8;j++){
//                                if(e.echiquier[i][j].piece != null && e.echiquier[i][j].piece.numcouleur == 1){
//                                    
//                                    if(e.MetEnEchec(e.echiquier[i][j].piece, e.Rn, e)){
//                                        return false;
//                                    }
//                                    
//                                }
//                            }
//                        }
                        nbtourroi++;
                        return true;
                    }
                    else if(casedesiree.piece != null && casedesiree.piece.numcouleur != c.piece.numcouleur){
                       
//                       e.Rn.c = casedesiree;
//                        for(int i =0;i<8;i++){
//                            for(int j=0;j<8;j++){
//                                if(e.echiquier[i][j].piece != null && e.echiquier[i][j].piece.numcouleur == 1){
//                                    
//                                    if(e.MetEnEchec(e.echiquier[i][j].piece, e.Rn, e)){
//                                        return false;
//                                    }
//                                    
//                                }
//                            }
//                        }
                        nbtourroi++;
                        return true;
                    }   
                    else{
                        
                        return false;
                    }
                 }
                     
                 }
                 else{
                     if(casedesiree.colonne == c.colonne && casedesiree.ligne == c.ligne +1){
                    
                    if(casedesiree.piece == null){
//                        e.Rn.c = casedesiree;
//                        
//                        for(int i =0;i<8;i++){
//                            for(int j=0;j<8;j++){
//                                if(e.echiquier[i][j].piece != null && e.echiquier[i][j].piece.numcouleur == 1){
//                                    
//                                    if(e.MetEnEchec(e.echiquier[i][j].piece, e.Rn, e)){
//                                        System.out.println(e.echiquier[i][j].piece.nom + " " + i + " " + j);
//                                        return false;
//                                    }
//                                    
//                                }
//                            }
//                        }
                        nbtourroi++;
                        return true;
                        
                    }
                    
                    else if(casedesiree.piece != null && casedesiree.piece.numcouleur != c.piece.numcouleur){
//                      e.Rn.c = casedesiree;
//                        for(int i =0;i<8;i++){
//                            for(int j=0;j<8;j++){
//                                if(e.echiquier[i][j].piece != null && e.echiquier[i][j].piece.numcouleur == 1){
//                                    
//                                    if(e.MetEnEchec(e.echiquier[i][j].piece, e.Rn, e)){
//                                        return false;
//                                    }
//                                    
//                                }
//                            }
//                        }
                        nbtourroi++;
                        return true;
                    }   
                    else{
                        
                        return false;
                    }
            }
                 
                 else if(casedesiree.colonne == c.colonne +1 && casedesiree.ligne == c.ligne + 1){
                     if(casedesiree.piece == null){
                        
//                        e.Rn.c = casedesiree;
//                        for(int i =0;i<8;i++){
//                            for(int j=0;j<8;j++){
//                                if(e.echiquier[i][j].piece != null && e.echiquier[i][j].piece.numcouleur == 1){
//                                    
//                                    if(e.MetEnEchec(e.echiquier[i][j].piece, e.Rn, e)){
//                                        return false;
//                                    }
//                                    
//                                }
//                            }
//                        }
                        nbtourroi++;
                        return true;
                    }
                    else if(casedesiree.piece != null && casedesiree.piece.numcouleur != c.piece.numcouleur){
                       
//                       e.Rn.c = casedesiree;
//                        for(int i =0;i<8;i++){
//                            for(int j=0;j<8;j++){
//                                if(e.echiquier[i][j].piece != null && e.echiquier[i][j].piece.numcouleur == 1){
//                                    
//                                    if(e.MetEnEchec(e.echiquier[i][j].piece, e.Rn, e)){
//                                        return false;
//                                    }
//                                    
//                                }
//                            }
//                        }
                        nbtourroi++;
                        return true;
                    }   
                    else{
                        
                        return false;
                    }
                 }
                 else if(casedesiree.colonne == c.colonne + 1 && casedesiree.ligne == c.ligne ){
                     if(casedesiree.piece == null){
                        
//                        e.Rn.c = casedesiree;
//                        for(int i =0;i<8;i++){
//                            for(int j=0;j<8;j++){
//                                if(e.echiquier[i][j].piece != null && e.echiquier[i][j].piece.numcouleur == 1){
//                                    
//                                    if(e.MetEnEchec(e.echiquier[i][j].piece, e.Rn, e)){
//                                        return false;
//                                    }
//                                    
//                                }
//                            }
//                        }
                        nbtourroi++;
                        return true;
                    }
                    else if(casedesiree.piece != null && casedesiree.piece.numcouleur != c.piece.numcouleur){
                      
//                       e.Rn.c = casedesiree;
//                        for(int i =0;i<8;i++){
//                            for(int j=0;j<8;j++){
//                                if(e.echiquier[i][j].piece != null && e.echiquier[i][j].piece.numcouleur == 1){
//                                    
//                                    if(e.MetEnEchec(e.echiquier[i][j].piece, e.Rn, e)){
//                                        return false;
//                                    }
//                                    
//                                }
//                            }
//                        }
                        nbtourroi++;
                        return true;
                    }   
                    else{
                        
                        return false;
                    }
                 }
                 else if(casedesiree.colonne == c.colonne +1 && casedesiree.ligne == c.ligne -1){
                     if(casedesiree.piece == null){
                        
//                        e.Rn.c = casedesiree;
//                        for(int i =0;i<8;i++){
//                            for(int j=0;j<8;j++){
//                                if(e.echiquier[i][j].piece != null && e.echiquier[i][j].piece.numcouleur == 1){
//                                    
//                                    if(e.MetEnEchec(e.echiquier[i][j].piece, e.Rn, e)){
//                                        return false;
//                                    }
//                                    
//                                }
//                            }
//                        }
                        nbtourroi++;
                        return true;
                    }
                    else if(casedesiree.piece != null && casedesiree.piece.numcouleur != c.piece.numcouleur){
                       
//                       e.Rn.c = casedesiree;
//                        for(int i =0;i<8;i++){
//                            for(int j=0;j<8;j++){
//                                if(e.echiquier[i][j].piece != null && e.echiquier[i][j].piece.numcouleur == 1){
//                                    
//                                    if(e.MetEnEchec(e.echiquier[i][j].piece, e.Rn, e)){
//                                        return false;
//                                    }
//                                    
//                                }
//                            }
//                        }
                        nbtourroi++;
                        return true;
                    }   
                    else{
                        
                        return false;
                    }
                 }
                 else if(casedesiree.colonne == c.colonne && casedesiree.ligne == c.ligne -1){
                     if(casedesiree.piece == null){
                        
//                        e.Rn.c = casedesiree;
//                        for(int i =0;i<8;i++){
//                            for(int j=0;j<8;j++){
//                                if(e.echiquier[i][j].piece != null && e.echiquier[i][j].piece.numcouleur == 1){
//                                    
//                                    if(e.MetEnEchec(e.echiquier[i][j].piece, e.Rn, e)){
//                                        return false;
//                                    }
//                                    
//                                }
//                            }
//                        }
                        nbtourroi++;
                        return true;
                    }
                    else if(casedesiree.piece != null && casedesiree.piece.numcouleur != c.piece.numcouleur){
                       
//                       e.Rn.c = casedesiree;
//                        for(int i =0;i<8;i++){
//                            for(int j=0;j<8;j++){
//                                if(e.echiquier[i][j].piece != null && e.echiquier[i][j].piece.numcouleur == 1){
//                                    
//                                    if(e.MetEnEchec(e.echiquier[i][j].piece, e.Rn, e)){
//                                        return false;
//                                    }
//                                    
//                                }
//                            }
//                        }
                        nbtourroi++;
                        return true;
                    }   
                    else{
                        
                        return false;
                    }
                 }
                 else if(casedesiree.colonne == c.colonne-1 && casedesiree.ligne == c.ligne -1){
                     if(casedesiree.piece == null){
                       
//                        e.Rn.c = casedesiree;
//                        for(int i =0;i<8;i++){
//                            for(int j=0;j<8;j++){
//                                if(e.echiquier[i][j].piece != null && e.echiquier[i][j].piece.numcouleur == 1){
//                                    
//                                    if(e.MetEnEchec(e.echiquier[i][j].piece, e.Rn, e)){
//                                        return false;
//                                    }
//                                    
//                                }
//                            }
//                        }
                        nbtourroi++;
                        return true;
                    }
                    else if(casedesiree.piece != null && casedesiree.piece.numcouleur != c.piece.numcouleur){
                       
//                       e.Rn.c = casedesiree;
//                        for(int i =0;i<8;i++){
//                            for(int j=0;j<8;j++){
//                                if(e.echiquier[i][j].piece != null && e.echiquier[i][j].piece.numcouleur == 1){
//                                    
//                                    if(e.MetEnEchec(e.echiquier[i][j].piece, e.Rn, e)){
//                                        return false;
//                                    }
//                                    
//                                }
//                            }
//                        }
                        nbtourroi++;
                        return true;
                    }   
                    else{
                        
                        return false;
                    }
                 }
                 else if(casedesiree.colonne == c.colonne - 1 && casedesiree.ligne == c.ligne ){
                     if(casedesiree.piece == null){
                        
//                        e.Rn.c = casedesiree;
//                        for(int i =0;i<8;i++){
//                            for(int j=0;j<8;j++){
//                                if(e.echiquier[i][j].piece != null && e.echiquier[i][j].piece.numcouleur == 1){
//                                    
//                                    if(e.MetEnEchec(e.echiquier[i][j].piece, e.Rn, e)){
//                                        return false;
//                                    }
//                                    
//                                }
//                            }
//                        }
                        nbtourroi++;
                        return true;
                    }
                    else if(casedesiree.piece != null && casedesiree.piece.numcouleur != c.piece.numcouleur){
                       
//                       e.Rn.c = casedesiree;
//                        for(int i =0;i<8;i++){
//                            for(int j=0;j<8;j++){
//                                if(e.echiquier[i][j].piece != null && e.echiquier[i][j].piece.numcouleur == 1){
//                                    
//                                    if(e.MetEnEchec(e.echiquier[i][j].piece, e.Rn, e)){
//                                        return false;
//                                    }
//                                    
//                                }
//                            }
//                        }
                        nbtourroi++;
                        return true;
                    }   
                    else{
                        
                        return false;
                    }
                 }
                 else if(casedesiree.colonne == c.colonne -1 && casedesiree.ligne == c.ligne +1){
                     if(casedesiree.piece == null){
                        
//                        e.Rn.c = casedesiree;
//                        for(int i =0;i<8;i++){
//                            for(int j=0;j<8;j++){
//                                if(e.echiquier[i][j].piece != null && e.echiquier[i][j].piece.numcouleur == 1){
//                                    
//                                    if(e.MetEnEchec(e.echiquier[i][j].piece, e.Rn, e)){
//                                        return false;
//                                    }
//                                    
//                                }
//                            }
//                        }
                        nbtourroi++;
                        return true;
                    }
                    else if(casedesiree.piece != null && casedesiree.piece.numcouleur != c.piece.numcouleur){
                       
//                       e.Rn.c = casedesiree;
//                        for(int i =0;i<8;i++){
//                            for(int j=0;j<8;j++){
//                                if(e.echiquier[i][j].piece != null && e.echiquier[i][j].piece.numcouleur == 1){
//                                    
//                                    if(e.MetEnEchec(e.echiquier[i][j].piece, e.Rn, e)){
//                                        return false;
//                                    }
//                                    
//                                }
//                            }
//                        }
                        nbtourroi++;
                        return true;
                    }   
                    else{
                        
                        return false;
                    }
                 }
                     
                 }
                 
                 
                 
             }
             else{
                 if(nbtourroi==0){
                    if(casedesiree.colonne == c.colonne + 2 && casedesiree.ligne == c.ligne ){
                        
                        if(e.echiquier[7][7].piece instanceof Tour && e.echiquier[7][7].piece.numcouleur == 1){
                            Tour t = (Tour) e.echiquier[7][7].piece;
                            if(t.nbtourtour == 0){
                                if(e.echiquier[5][7].piece == null && e.echiquier[6][7].piece == null){
                                    e.Rb.c = e.echiquier[5][7];
                        
                                    for(int i =0;i<8;i++){
                                        for(int j=0;j<8;j++){
                                            if(e.echiquier[i][j].piece != null && e.echiquier[i][j].piece.numcouleur == 0){
                                    
                                                if(e.MetEnEchec(e.echiquier[i][j].piece, e.Rb, e)){
                                                    
                                                    return false;
                                                }
                                    
                                            }
                                        }
                                    }
                                    e.echiquier[5][7].piece = e.echiquier[7][7].piece;
                                    e.echiquier[7][7].piece = null;
                                    e.echiquier[5][7].piece.c = e.echiquier[5][7];
                                    t.nbtourtour++;
                                    nbtourroi++;
                                    e.envoyer("PR "+ "77" + " " + "57");
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
                        else{
                            
                            return false;
                        }
                        
                    }
                    else if(casedesiree.colonne == c.colonne - 2 && casedesiree.ligne == c.ligne){
                        if(e.echiquier[0][7].piece instanceof Tour && e.echiquier[0][7].piece.numcouleur == 1){
                            Tour t = (Tour) e.echiquier[0][7].piece;
                            if(t.nbtourtour == 0){
                                if(e.echiquier[1][7].piece == null && e.echiquier[2][7].piece == null && e.echiquier[3][7].piece == null){
                                    e.Rb.c = e.echiquier[3][7];
                        
                                    for(int i =0;i<8;i++){
                                        for(int j=0;j<8;j++){
                                            if(e.echiquier[i][j].piece != null && e.echiquier[i][j].piece.numcouleur == 0){
                                    
                                                if(e.MetEnEchec(e.echiquier[i][j].piece, e.Rb, e)){
                                                    
                                                    return false;
                                                }
                                    
                                            }
                                        }
                                    }
                                    e.echiquier[3][7].piece = e.echiquier[0][7].piece;
                                    e.echiquier[0][7].piece = null;
                                    e.echiquier[3][7].piece.c = e.echiquier[3][7];
                                    t.nbtourtour++;
                                    nbtourroi++;
                                    e.envoyer("GR "+ "07" + " " + "37");
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
                        else{
                            
                            return false;
                        }
                    }
                    
                    else if(casedesiree.colonne == c.colonne && casedesiree.ligne == c.ligne +1){
                    
                    if(casedesiree.piece == null){
                        
//                        e.Rb.c = casedesiree;
//                        for(int i =0;i<8;i++){
//                            for(int j=0;j<8;j++){
//                                if(e.echiquier[i][j].piece != null && e.echiquier[i][j].piece.numcouleur == 0){
//                                    
//                                    if(e.MetEnEchec(e.echiquier[i][j].piece, e.Rb, e)){
//                                        return false;
//                                    }
//                                    
//                                }
//                            }
//                        }
                        nbtourroi++;
                        return true;
                    }
                    else if(casedesiree.piece != null && casedesiree.piece.numcouleur != c.piece.numcouleur){
                       
//                       e.Rb.c = casedesiree;
//                        for(int i =0;i<8;i++){
//                            for(int j=0;j<8;j++){
//                                if(e.echiquier[i][j].piece != null && e.echiquier[i][j].piece.numcouleur == 0){
//                                    
//                                    if(e.MetEnEchec(e.echiquier[i][j].piece, e.Rb, e)){
//                                        return false;
//                                    }
//                                    
//                                }
//                            }
//                        }
                        nbtourroi++;
                        return true;
                    }   
                    else{
                        
                        return false;
                    }
            
                 }
                 else if(casedesiree.colonne == c.colonne +1 && casedesiree.ligne == c.ligne + 1){
                     if(casedesiree.piece == null){
                       
//                        e.Rb.c = casedesiree;
//                        for(int i =0;i<8;i++){
//                            for(int j=0;j<8;j++){
//                                if(e.echiquier[i][j].piece != null && e.echiquier[i][j].piece.numcouleur == 0){
//                                    
//                                    if(e.MetEnEchec(e.echiquier[i][j].piece, e.Rb, e)){
//                                        return false;
//                                    }
//                                    
//                                }
//                            }
//                        }
                        nbtourroi++;
                        return true;
                    }
                    else if(casedesiree.piece != null && casedesiree.piece.numcouleur != c.piece.numcouleur){
                       
//                       e.Rb.c = casedesiree;
//                        for(int i =0;i<8;i++){
//                            for(int j=0;j<8;j++){
//                                if(e.echiquier[i][j].piece != null && e.echiquier[i][j].piece.numcouleur == 0){
//                                    
//                                    if(e.MetEnEchec(e.echiquier[i][j].piece, e.Rb, e)){
//                                        return false;
//                                    }
//                                    
//                                }
//                            }
//                        }
                        nbtourroi++;
                        return true;
                    }   
                    else{
                        
                        return false;
                    }
                 }
                 else if(casedesiree.colonne == c.colonne + 1 && casedesiree.ligne == c.ligne ){
                     if(casedesiree.piece == null){
                        
//                        e.Rb.c = casedesiree;
//                        for(int i =0;i<8;i++){
//                            for(int j=0;j<8;j++){
//                                if(e.echiquier[i][j].piece != null && e.echiquier[i][j].piece.numcouleur == 0){
//                                    
//                                    if(e.MetEnEchec(e.echiquier[i][j].piece, e.Rb, e)){
//                                        return false;
//                                    }
//                                    
//                                }
//                            }
//                        }
                        nbtourroi++;
                        return true;
                    }
                    else if(casedesiree.piece != null && casedesiree.piece.numcouleur != c.piece.numcouleur){
                       
//                       e.Rb.c = casedesiree;
//                        for(int i =0;i<8;i++){
//                            for(int j=0;j<8;j++){
//                                if(e.echiquier[i][j].piece != null && e.echiquier[i][j].piece.numcouleur == 0){
//                                    
//                                    if(e.MetEnEchec(e.echiquier[i][j].piece, e.Rb, e)){
//                                        return false;
//                                    }
//                                    
//                                }
//                            }
//                        }
                        nbtourroi++;
                        return true;
                    }   
                    else{
                        
                        return false;
                    }
                 }
                 else if(casedesiree.colonne == c.colonne +1 && casedesiree.ligne == c.ligne -1){
                     if(casedesiree.piece == null){
                        
//                        e.Rb.c = casedesiree;
//                        for(int i =0;i<8;i++){
//                            for(int j=0;j<8;j++){
//                                if(e.echiquier[i][j].piece != null && e.echiquier[i][j].piece.numcouleur == 0){
//                                    
//                                    if(e.MetEnEchec(e.echiquier[i][j].piece, e.Rb, e)){
//                                        return false;
//                                    }
//                                    
//                                }
//                            }
//                        }
                        nbtourroi++;
                        return true;
                    }
                    else if(casedesiree.piece != null && casedesiree.piece.numcouleur != c.piece.numcouleur){
                       
//                       e.Rb.c = casedesiree;
//                        for(int i =0;i<8;i++){
//                            for(int j=0;j<8;j++){
//                                if(e.echiquier[i][j].piece != null && e.echiquier[i][j].piece.numcouleur == 0){
//                                    
//                                    if(e.MetEnEchec(e.echiquier[i][j].piece, e.Rb, e)){
//                                        return false;
//                                    }
//                                    
//                                }
//                            }
//                        }
                        nbtourroi++;
                        return true;
                    }   
                    else{
                        
                        return false;
                    }
                 }
                 else if(casedesiree.colonne == c.colonne && casedesiree.ligne == c.ligne -1){
                     if(casedesiree.piece == null){
                        
//                        e.Rb.c = casedesiree;
//                        for(int i =0;i<8;i++){
//                            for(int j=0;j<8;j++){
//                                if(e.echiquier[i][j].piece != null && e.echiquier[i][j].piece.numcouleur == 0){
//                                    
//                                    if(e.MetEnEchec(e.echiquier[i][j].piece, e.Rb, e)){
//                                        return false;
//                                    }
//                                    
//                                }
//                            }
//                        }
                        nbtourroi++;
                        return true;
                    }
                    else if(casedesiree.piece != null && casedesiree.piece.numcouleur != c.piece.numcouleur){
                      
//                       e.Rb.c = casedesiree;
//                        for(int i =0;i<8;i++){
//                            for(int j=0;j<8;j++){
//                                if(e.echiquier[i][j].piece != null && e.echiquier[i][j].piece.numcouleur == 0){
//                                    
//                                    if(e.MetEnEchec(e.echiquier[i][j].piece, e.Rb, e)){
//                                        return false;
//                                    }
//                                    
//                                }
//                            }
//                        }
                        nbtourroi++;
                        return true;
                    }   
                    else{
                        
                        return false;
                    }
                 }
                 else if(casedesiree.colonne == c.colonne-1 && casedesiree.ligne == c.ligne -1){
                     if(casedesiree.piece == null){
                        
//                        e.Rb.c = casedesiree;
//                        for(int i =0;i<8;i++){
//                            for(int j=0;j<8;j++){
//                                if(e.echiquier[i][j].piece != null && e.echiquier[i][j].piece.numcouleur == 0){
//                                    
//                                    if(e.MetEnEchec(e.echiquier[i][j].piece, e.Rb, e)){
//                                        return false;
//                                    }
//                                    
//                                }
//                            }
//                        }
                        nbtourroi++;
                        return true;
                    }
                    else if(casedesiree.piece != null && casedesiree.piece.numcouleur != c.piece.numcouleur){
                       
//                       e.Rb.c = casedesiree;
//                        for(int i =0;i<8;i++){
//                            for(int j=0;j<8;j++){
//                                if(e.echiquier[i][j].piece != null && e.echiquier[i][j].piece.numcouleur == 0){
//                                    
//                                    if(e.MetEnEchec(e.echiquier[i][j].piece, e.Rb, e)){
//                                        return false;
//                                    }
//                                    
//                                }
//                            }
//                        }
                        nbtourroi++;
                        return true;
                    }   
                    else{
                       
                        return false;
                    }
                 }
                 else if(casedesiree.colonne == c.colonne - 1 && casedesiree.ligne == c.ligne ){
                     if(casedesiree.piece == null){
                        
//                        e.Rb.c = casedesiree;
//                        for(int i =0;i<8;i++){
//                            for(int j=0;j<8;j++){
//                                if(e.echiquier[i][j].piece != null && e.echiquier[i][j].piece.numcouleur == 0){
//                                    
//                                    if(e.MetEnEchec(e.echiquier[i][j].piece, e.Rb, e)){
//                                        return false;
//                                    }
//                                    
//                                }
//                            }
//                        }
                        nbtourroi++;
                        return true;
                    }
                    else if(casedesiree.piece != null && casedesiree.piece.numcouleur != c.piece.numcouleur){
                       
//                       e.Rb.c = casedesiree;
//                        for(int i =0;i<8;i++){
//                            for(int j=0;j<8;j++){
//                                if(e.echiquier[i][j].piece != null && e.echiquier[i][j].piece.numcouleur == 0){
//                                    
//                                    if(e.MetEnEchec(e.echiquier[i][j].piece, e.Rb, e)){
//                                        return false;
//                                    }
//                                    
//                                }
//                            }
//                        }
                        nbtourroi++;
                        return true;
                    }   
                    else{
                        
                        return false;
                    }
                 }
                 else if(casedesiree.colonne == c.colonne -1 && casedesiree.ligne == c.ligne +1){
                     if(casedesiree.piece == null){
                        
//                        e.Rb.c = casedesiree;
//                        for(int i =0;i<8;i++){
//                            for(int j=0;j<8;j++){
//                                if(e.echiquier[i][j].piece != null && e.echiquier[i][j].piece.numcouleur == 0){
//                                    
//                                    if(e.MetEnEchec(e.echiquier[i][j].piece, e.Rb, e)){
//                                        return false;
//                                    }
//                                    
//                                }
//                            }
//                        }
                        nbtourroi++;
                        return true;
                    }
                    else if(casedesiree.piece != null && casedesiree.piece.numcouleur != c.piece.numcouleur){
                       
//                       e.Rb.c = casedesiree;
//                        for(int i =0;i<8;i++){
//                            for(int j=0;j<8;j++){
//                                if(e.echiquier[i][j].piece != null && e.echiquier[i][j].piece.numcouleur == 0){
//                                    
//                                    if(e.MetEnEchec(e.echiquier[i][j].piece, e.Rb, e)){
//                                        return false;
//                                    }
//                                    
//                                }
//                            }
//                        }
                        nbtourroi++;
                        return true;
                    }   
                    else{
                        
                        return false;
                    }
                 }
                 }
                 
                 else{
                 if(casedesiree.colonne == c.colonne && casedesiree.ligne == c.ligne +1){
                    
                    if(casedesiree.piece == null){
                        
//                        e.Rb.c = casedesiree;
//                        for(int i =0;i<8;i++){
//                            for(int j=0;j<8;j++){
//                                if(e.echiquier[i][j].piece != null && e.echiquier[i][j].piece.numcouleur == 0){
//                                    
//                                    if(e.MetEnEchec(e.echiquier[i][j].piece, e.Rb, e)){
//                                        return false;
//                                    }
//                                    
//                                }
//                            }
//                        }
                        nbtourroi++;
                        return true;
                    }
                    else if(casedesiree.piece != null && casedesiree.piece.numcouleur != c.piece.numcouleur){
                       
//                       e.Rb.c = casedesiree;
//                        for(int i =0;i<8;i++){
//                            for(int j=0;j<8;j++){
//                                if(e.echiquier[i][j].piece != null && e.echiquier[i][j].piece.numcouleur == 0){
//                                    
//                                    if(e.MetEnEchec(e.echiquier[i][j].piece, e.Rb, e)){
//                                        return false;
//                                    }
//                                    
//                                }
//                            }
//                        }
                        nbtourroi++;
                        return true;
                    }   
                    else{
                        
                        return false;
                    }
            
                 }
                 else if(casedesiree.colonne == c.colonne +1 && casedesiree.ligne == c.ligne + 1){
                     if(casedesiree.piece == null){
                       
//                        e.Rb.c = casedesiree;
//                        for(int i =0;i<8;i++){
//                            for(int j=0;j<8;j++){
//                                if(e.echiquier[i][j].piece != null && e.echiquier[i][j].piece.numcouleur == 0){
//                                    
//                                    if(e.MetEnEchec(e.echiquier[i][j].piece, e.Rb, e)){
//                                        return false;
//                                    }
//                                    
//                                }
//                            }
//                        }
                        nbtourroi++;
                        return true;
                    }
                    else if(casedesiree.piece != null && casedesiree.piece.numcouleur != c.piece.numcouleur){
                       
//                       e.Rb.c = casedesiree;
//                        for(int i =0;i<8;i++){
//                            for(int j=0;j<8;j++){
//                                if(e.echiquier[i][j].piece != null && e.echiquier[i][j].piece.numcouleur == 0){
//                                    
//                                    if(e.MetEnEchec(e.echiquier[i][j].piece, e.Rb, e)){
//                                        return false;
//                                    }
//                                    
//                                }
//                            }
//                        }
                        nbtourroi++;
                        return true;
                    }   
                    else{
                        
                        return false;
                    }
                 }
                 else if(casedesiree.colonne == c.colonne + 1 && casedesiree.ligne == c.ligne ){
                     if(casedesiree.piece == null){
                        
//                        e.Rb.c = casedesiree;
//                        for(int i =0;i<8;i++){
//                            for(int j=0;j<8;j++){
//                                if(e.echiquier[i][j].piece != null && e.echiquier[i][j].piece.numcouleur == 0){
//                                    
//                                    if(e.MetEnEchec(e.echiquier[i][j].piece, e.Rb, e)){
//                                        return false;
//                                    }
//                                    
//                                }
//                            }
//                        }
                        nbtourroi++;
                        return true;
                    }
                    else if(casedesiree.piece != null && casedesiree.piece.numcouleur != c.piece.numcouleur){
                       
//                       e.Rb.c = casedesiree;
//                        for(int i =0;i<8;i++){
//                            for(int j=0;j<8;j++){
//                                if(e.echiquier[i][j].piece != null && e.echiquier[i][j].piece.numcouleur == 0){
//                                    
//                                    if(e.MetEnEchec(e.echiquier[i][j].piece, e.Rb, e)){
//                                        return false;
//                                    }
//                                    
//                                }
//                            }
//                        }
                        nbtourroi++;
                        return true;
                    }   
                    else{
                        
                        return false;
                    }
                 }
                 else if(casedesiree.colonne == c.colonne +1 && casedesiree.ligne == c.ligne -1){
                     if(casedesiree.piece == null){
                        
//                        e.Rb.c = casedesiree;
//                        for(int i =0;i<8;i++){
//                            for(int j=0;j<8;j++){
//                                if(e.echiquier[i][j].piece != null && e.echiquier[i][j].piece.numcouleur == 0){
//                                    
//                                    if(e.MetEnEchec(e.echiquier[i][j].piece, e.Rb, e)){
//                                        return false;
//                                    }
//                                    
//                                }
//                            }
//                        }
                        nbtourroi++;
                        return true;
                    }
                    else if(casedesiree.piece != null && casedesiree.piece.numcouleur != c.piece.numcouleur){
                       
//                       e.Rb.c = casedesiree;
//                        for(int i =0;i<8;i++){
//                            for(int j=0;j<8;j++){
//                                if(e.echiquier[i][j].piece != null && e.echiquier[i][j].piece.numcouleur == 0){
//                                    
//                                    if(e.MetEnEchec(e.echiquier[i][j].piece, e.Rb, e)){
//                                        return false;
//                                    }
//                                    
//                                }
//                            }
//                        }
                        nbtourroi++;
                        return true;
                    }   
                    else{
                        
                        return false;
                    }
                 }
                 else if(casedesiree.colonne == c.colonne && casedesiree.ligne == c.ligne -1){
                     if(casedesiree.piece == null){
                        
//                        e.Rb.c = casedesiree;
//                        for(int i =0;i<8;i++){
//                            for(int j=0;j<8;j++){
//                                if(e.echiquier[i][j].piece != null && e.echiquier[i][j].piece.numcouleur == 0){
//                                    
//                                    if(e.MetEnEchec(e.echiquier[i][j].piece, e.Rb, e)){
//                                        return false;
//                                    }
//                                    
//                                }
//                            }
//                        }
                        nbtourroi++;
                        return true;
                    }
                    else if(casedesiree.piece != null && casedesiree.piece.numcouleur != c.piece.numcouleur){
                      
//                       e.Rb.c = casedesiree;
//                        for(int i =0;i<8;i++){
//                            for(int j=0;j<8;j++){
//                                if(e.echiquier[i][j].piece != null && e.echiquier[i][j].piece.numcouleur == 0){
//                                    
//                                    if(e.MetEnEchec(e.echiquier[i][j].piece, e.Rb, e)){
//                                        return false;
//                                    }
//                                    
//                                }
//                            }
//                        }
                        nbtourroi++;
                        return true;
                    }   
                    else{
                        
                        return false;
                    }
                 }
                 else if(casedesiree.colonne == c.colonne-1 && casedesiree.ligne == c.ligne -1){
                     if(casedesiree.piece == null){
                        
//                        e.Rb.c = casedesiree;
//                        for(int i =0;i<8;i++){
//                            for(int j=0;j<8;j++){
//                                if(e.echiquier[i][j].piece != null && e.echiquier[i][j].piece.numcouleur == 0){
//                                    
//                                    if(e.MetEnEchec(e.echiquier[i][j].piece, e.Rb, e)){
//                                        return false;
//                                    }
//                                    
//                                }
//                            }
//                        }
                        nbtourroi++;
                        return true;
                    }
                    else if(casedesiree.piece != null && casedesiree.piece.numcouleur != c.piece.numcouleur){
                       
//                       e.Rb.c = casedesiree;
//                        for(int i =0;i<8;i++){
//                            for(int j=0;j<8;j++){
//                                if(e.echiquier[i][j].piece != null && e.echiquier[i][j].piece.numcouleur == 0){
//                                    
//                                    if(e.MetEnEchec(e.echiquier[i][j].piece, e.Rb, e)){
//                                        return false;
//                                    }
//                                    
//                                }
//                            }
//                        }
                        nbtourroi++;
                        return true;
                    }   
                    else{
                       
                        return false;
                    }
                 }
                 else if(casedesiree.colonne == c.colonne - 1 && casedesiree.ligne == c.ligne ){
                     if(casedesiree.piece == null){
                        
//                        e.Rb.c = casedesiree;
//                        for(int i =0;i<8;i++){
//                            for(int j=0;j<8;j++){
//                                if(e.echiquier[i][j].piece != null && e.echiquier[i][j].piece.numcouleur == 0){
//                                    
//                                    if(e.MetEnEchec(e.echiquier[i][j].piece, e.Rb, e)){
//                                        return false;
//                                    }
//                                    
//                                }
//                            }
//                        }
                        nbtourroi++;
                        return true;
                    }
                    else if(casedesiree.piece != null && casedesiree.piece.numcouleur != c.piece.numcouleur){
                       
//                       e.Rb.c = casedesiree;
//                        for(int i =0;i<8;i++){
//                            for(int j=0;j<8;j++){
//                                if(e.echiquier[i][j].piece != null && e.echiquier[i][j].piece.numcouleur == 0){
//                                    
//                                    if(e.MetEnEchec(e.echiquier[i][j].piece, e.Rb, e)){
//                                        return false;
//                                    }
//                                    
//                                }
//                            }
//                        }
                        nbtourroi++;
                        return true;
                    }   
                    else{
                        
                        return false;
                    }
                 }
                 else if(casedesiree.colonne == c.colonne -1 && casedesiree.ligne == c.ligne +1){
                     if(casedesiree.piece == null){
                        
//                        e.Rb.c = casedesiree;
//                        for(int i =0;i<8;i++){
//                            for(int j=0;j<8;j++){
//                                if(e.echiquier[i][j].piece != null && e.echiquier[i][j].piece.numcouleur == 0){
//                                    
//                                    if(e.MetEnEchec(e.echiquier[i][j].piece, e.Rb, e)){
//                                        return false;
//                                    }
//                                    
//                                }
//                            }
//                        }
                        nbtourroi++;
                        return true;
                    }
                    else if(casedesiree.piece != null && casedesiree.piece.numcouleur != c.piece.numcouleur){
                       
//                       e.Rb.c = casedesiree;
//                        for(int i =0;i<8;i++){
//                            for(int j=0;j<8;j++){
//                                if(e.echiquier[i][j].piece != null && e.echiquier[i][j].piece.numcouleur == 0){
//                                    
//                                    if(e.MetEnEchec(e.echiquier[i][j].piece, e.Rb, e)){
//                                        return false;
//                                    }
//                                    
//                                }
//                            }
//                        }
                        nbtourroi++;
                        return true;
                    }   
                    else{
                        
                        return false;
                    }
                 }
                }
             }
         
         }
         
    return false;        
    }
}
    

