/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tcp;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ConnectException;
import java.net.Socket;

/**
 * Classe gérant les communications.
 */
public class Communication {

    // objet gérant les messages
    Connectable connect;
    // socket de communication
    Socket socket;
    // flux de sortie
    PrintWriter sortie;
    // Recepteur des messages arrivants
    Recepteur recepteur;

    /**
     * Création d'une communication par le serveur.
     *
     * @param connect objet de gestion des messages.
     */
    public Communication(Connectable connect) {
        this.connect = connect;
    }

    /**
     * Création d'une communication client.
     *
     * @param connect objet de gestion des messages.
     * @param ip adresse ip du serveur.
     * @param port port d'écoute du serveur.
     */
    public Communication(Connectable connect, String ip, int port) {
        this.connect = connect;
        try {
            Socket socket = new Socket(ip, port);
            setSocket(socket);
        } catch (ConnectException ex) {
            // Serveur indisponible
            ex.printStackTrace();
            return;
        } catch (IOException ex) {
            // erreur réseau
            ex.printStackTrace();
            return;
        }
    }

    /**
     * Affectation du socket et création des flux et du récepteur.
     *
     * @param socket le socket.
     */
    public void setSocket(Socket socket) {
        this.socket = socket;
        // affectation de la communication à l'objet de gestion des messages.
        connect.set(this);

        // émetteur
        try {
            sortie = new PrintWriter(new OutputStreamWriter(
                    socket.getOutputStream(), "UTF-8"), true);
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        // récepteur
        recepteur = new Recepteur(socket, connect);
        Thread threc = new Thread(recepteur);
        threc.setDaemon(true);
        threc.start();
    }

    /**
     * Méthode d'émission des messages.
     *
     * @param mess le message à envoyer.
     */
    public void emettre(String mess) {
        sortie.println(mess);
    }

}
