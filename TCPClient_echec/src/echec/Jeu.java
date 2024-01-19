/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package echec;

import tcp.Communication;
import tcp.Connectable;

/**
 *  Jeu implémentant l'interface de communication.
 */
public class Jeu implements Connectable {

    // la fenêtre d'affichage
    Fenetre fen;
    // la communication
    Communication comm;
    int port;
    Echiquier e;

    /**
     * Création jeu.
     *
     * @param port numéro de port d'écoute du serveur.
     */
    public Jeu(int port) {
        this.port = port;
        
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
     * Emission d'un message (et affichage dans le fenêtre)
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
     *
     * @param mess le message reçu.
     */
    public void recevoir(String mess) {
        System.out.println("<-- : " + mess);
    }
}
