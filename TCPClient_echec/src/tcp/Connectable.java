/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tcp;

/**
 * Interface à implémenter par l'objet chargé d'émettre et de recevoir des
 * messages (le jeu).
 */
public interface Connectable {

    /**
     * Affectation de la communication à l'objet gestionnaire.
     *
     * @param comm la communication.
     */
    public void set(Communication comm);

    /**
     * Transmission d'un message reçu à l'objet gestionnaire.
     *
     * @param mess le message.
     */
    public void recevoir(String mess);
}
