/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.SocketException;

/**
 * Classe asurant la réception des messages en boucle dans un thread séparé.
 */
public class Recepteur implements Runnable {

    // socket de communication
    Socket socket;
    // objet à qui transmettre les messages reçus.
    Connectable connect;

    /**
     * Création du récepteur.
     *
     * @param socket le socket de communication.
     * @param connect objet à qui transmettre les messages reçus.
     */
    public Recepteur(Socket socket, Connectable connect) {
        this.socket = socket;
        this.connect = connect;
    }

    /**
     * Lancement du récepteur.
     */
    public void run() {
        try {
            // flux d'entrée à surveiller
            BufferedReader entree = new BufferedReader(
                    new InputStreamReader(socket.getInputStream(), "UTF-8"));

            // boucle d'attente des messages
            while (true) {
                String texte = entree.readLine();
                if (texte != null && !texte.isEmpty()) {
                    // Envoie vers l'objet Connectable
                    connect.recevoir(texte);
                }
            }
        } catch (SocketException ex) {
            // pb de connexion (socket distant fermée)
            System.out.println("DECONNEXION du client distant");
            //ex.printStackTrace();
        } catch (IOException ex) {
            // erreur sur réception du message
            ex.printStackTrace();
        }
    }
}
