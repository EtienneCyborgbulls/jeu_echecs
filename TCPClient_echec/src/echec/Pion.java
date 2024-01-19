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
public class Pion extends Piece {
    int nbtourpion; //nbtour pour le pion
    int numDuTourOuAEteFaitLavanceeDeDeuxCases;
    
    public Pion(int numcouleur,Case c){
        super(numcouleur,c);
        
        nom="P";
    }
    
    public boolean mouvement(Case c, Case casedesiree, Echiquier e){ //c est la case de départ
        //Prise en passant à faire
        if(c.piece instanceof Pion){
            if(numcouleur==0){ //pièces noires en haut
            if(nbtourpion==0){
                
                if((casedesiree.ligne == c.ligne+2 && casedesiree.colonne == c.colonne)){ 
                /* casedesiree est la case désirée par l'utilisateur pour le mouvement de la pièce
                * Elle est obtenue avec le mouselistener
                * Si cette case est une case possible pour le mouvement de la piece alors on fait le mouvement
                *sinon on met un message d'erreur
                */
                    if(e.echiquier[c.colonne][c.ligne+1].piece == null && e.echiquier[c.colonne][c.ligne+2].piece == null){
                    
                    /*
                    *on regarde s'il n'y a pas de pièce sur le chemin 
                    *
                    */
                    
                   
                    
                    nbtourpion++;
                    numDuTourOuAEteFaitLavanceeDeDeuxCases = e.fen.nbtour;
                    System.out.println(numDuTourOuAEteFaitLavanceeDeDeuxCases);
                    return true;
                    
                    }
                }
                else if(casedesiree.ligne == c.ligne + 1 && casedesiree.colonne == c.colonne){
                    if(e.echiquier[c.colonne][c.ligne+1].piece == null){
                        
                        nbtourpion++;
                        return true;
                    }
                }
                
                else if (casedesiree.ligne == c.ligne + 1 && casedesiree.colonne == c.colonne +1 && casedesiree.piece != null && casedesiree.piece.numcouleur != c.piece.numcouleur){
                    //manger(e,casedesiree); //on mange la piece sur la case désirée
                    
                    nbtourpion++;
                    return true;
                }
                else if (casedesiree.ligne == c.ligne +1 && casedesiree.colonne == c.colonne - 1 && casedesiree.piece !=null && casedesiree.piece.numcouleur != c.piece.numcouleur){
                    //manger(e,casedesiree);
                    
                    nbtourpion++;
                    return true;
                }
                
            else{
                    
                    return false;
            }
            
        }
        else{
            if(casedesiree.ligne == c.ligne+1 && casedesiree.colonne == c.colonne && casedesiree.piece == null){
                nbtourpion++;
                return true;
            }
            else if (casedesiree.ligne == c.ligne + 1 && casedesiree.colonne == c.colonne +1 && casedesiree.piece != null && casedesiree.piece.numcouleur != c.piece.numcouleur){
                    //manger(e,casedesiree); //on mange la piece sur la case désirée
                    nbtourpion++;
                    return true;
                }
                else if (casedesiree.ligne == c.ligne +1 && casedesiree.colonne == c.colonne - 1 && casedesiree.piece !=null && casedesiree.piece.numcouleur != c.piece.numcouleur){
                    //manger(e,casedesiree);
                    nbtourpion++;
                    return true;
                }
                else if(c.ligne == 4){
                    if(c.colonne !=7){
                        
                    
                    if(e.echiquier[c.colonne+1][c.ligne].piece instanceof Pion && e.echiquier[c.colonne+1][c.ligne].piece.numcouleur == 1){
                        Pion pb = (Pion) e.echiquier[c.colonne+1][c.ligne].piece;
                        
                        if(pb.nbtourpion == 1 && pb.numDuTourOuAEteFaitLavanceeDeDeuxCases == e.fen.nbtour-1 && casedesiree.ligne == c.ligne+1 && casedesiree.colonne == c.colonne+1){
                            
                            int colonne = c.colonne+1;
                            e.echiquier[c.colonne+1][c.ligne].piece = null;
                            e.envoyer("PP" + " " + colonne + "" + c.ligne );
                            nbtourpion++;
                            return true;
                        }
                        
                    }
                    }
                    else if (c.colonne !=0){
                        if(e.echiquier[c.colonne-1][c.ligne].piece instanceof Pion && e.echiquier[c.colonne-1][c.ligne].piece.numcouleur ==1){
                        Pion pb = (Pion) e.echiquier[c.colonne-1][c.ligne].piece;
                        if(pb.nbtourpion == 1 && pb.numDuTourOuAEteFaitLavanceeDeDeuxCases == e.fen.nbtour-1 && casedesiree.ligne == c.ligne+1 && casedesiree.colonne == c.colonne-1){
                            
                            int colonne = c.colonne-1;
                            e.echiquier[c.colonne-1][c.ligne].piece = null;
                            e.envoyer("PP" + " " + colonne + "" + c.ligne );
                            nbtourpion++;
                            return true;
                        }
                    }
                    
                }
                }
            
            else{
                
                return(false);
            }
        
            
        }
            }
            else{         //piece blanche en bas numcouleur == 1
                
                if(nbtourpion==0){
                
                if(casedesiree.ligne == c.ligne-2 && casedesiree.colonne == c.colonne){ 
                /* casedesiree est la case désirée par l'utilisateur pour le mouvement de la pièce
                * Elle est obtenue avec le mouselistener
                * Si cette case est une case possible pour le mouvement de la piece alors on fait le mouvement
                *sinon on met un message d'erreur
                */
                    if(e.echiquier[c.colonne][c.ligne-1].piece == null && e.echiquier[c.colonne][c.ligne-2].piece == null){
                    
                    /*
                    *on regarde s'il n'y a pas de pièce sur le chemin 
                    *
                    */
                    
                    
                    nbtourpion++;
                    numDuTourOuAEteFaitLavanceeDeDeuxCases = e.fen.nbtour;
                    System.out.println(numDuTourOuAEteFaitLavanceeDeDeuxCases);
                    return true;
                    
                }
                }
                else if(casedesiree.ligne == c.ligne - 1 && casedesiree.colonne == c.colonne){
                    if(e.echiquier[c.colonne][c.ligne-1].piece == null){
                        
                        nbtourpion++;
                        return true;
                    }
                }
            
                
                else if (casedesiree.ligne == c.ligne - 1 && casedesiree.colonne == c.colonne -1 && casedesiree.piece != null && casedesiree.piece.numcouleur != c.piece.numcouleur){
                    //manger(e,casedesiree); //on mange la piece sur la case désirée
                    
                    nbtourpion++;
                    return true;
                }
                else if (casedesiree.ligne == c.ligne -1 && casedesiree.colonne == c.colonne + 1 && casedesiree.piece !=null && casedesiree.piece.numcouleur != c.piece.numcouleur){
                    //manger(e,casedesiree);
                    
                    nbtourpion++;
                    return true;
                }
                
            else{
                    
                    
                    return false;
            
            }
            
        }
        else{
            if(casedesiree.ligne == c.ligne-1 && casedesiree.colonne == c.colonne && casedesiree.piece == null){
                
                nbtourpion++;
                return true;
            }
            else if (casedesiree.ligne == c.ligne - 1 && casedesiree.colonne == c.colonne -1 && casedesiree.piece != null && casedesiree.piece.numcouleur != c.piece.numcouleur){
                    //manger(e,casedesiree); //on mange la piece sur la case désirée
                    nbtourpion++;
                    return true;
                }
                else if (casedesiree.ligne == c.ligne -1 && casedesiree.colonne == c.colonne + 1 && casedesiree.piece !=null && casedesiree.piece.numcouleur != c.piece.numcouleur){
                    //manger(e,casedesiree);
                    nbtourpion++;
                    return true;
                }
                else if(c.ligne == 3){
                    if(c.colonne !=7){
                    if(e.echiquier[c.colonne+1][c.ligne].piece instanceof Pion && e.echiquier[c.colonne+1][c.ligne].piece.numcouleur == 0){
                        Pion pb = (Pion) e.echiquier[c.colonne+1][c.ligne].piece;
                        System.out.println(pb.numDuTourOuAEteFaitLavanceeDeDeuxCases);
                        System.out.println(e.fen.nbtour-1);
                        
                        if(pb.nbtourpion == 1 && pb.numDuTourOuAEteFaitLavanceeDeDeuxCases == e.fen.nbtour-1 && casedesiree.ligne == c.ligne-1 && casedesiree.colonne == c.colonne+1){
                            
                            int colonne = c.colonne +1;
                            e.echiquier[colonne][c.ligne].piece = null;
                            e.envoyer("PP" + " " + colonne + "" + c.ligne );
                            nbtourpion++;
                            return true;
                        }
                        
                    }
                    }
                    else if(c.colonne !=0){
                        if(e.echiquier[c.colonne-1][c.ligne].piece instanceof Pion && e.echiquier[c.colonne-1][c.ligne].piece.numcouleur == 0){
                        Pion pb = (Pion) e.echiquier[c.colonne-1][c.ligne].piece;
                        if(pb.nbtourpion == 1 && pb.numDuTourOuAEteFaitLavanceeDeDeuxCases == e.fen.nbtour-1 && casedesiree.ligne == c.ligne-1 && casedesiree.colonne == c.colonne-1){
                            
                            int colonne = c.colonne -1;
                            e.echiquier[c.colonne-1][c.ligne].piece = null;
                            e.envoyer("PP" + " " + colonne + "" + c.ligne );
                            nbtourpion++;
                            return true;
                        }
                    }
                    }
                    
                }
            else{
                
                return false;
            }
                
            }
        
    }
        }
            
        return(false);
    }
}
    
        



