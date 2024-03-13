/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package synchronisation_p21;

/**
 *
 * @author RAKINE
 */
public class Producteur extends Thread {

    BoiteAuxLettres boite;
    String nom;

    public Producteur(BoiteAuxLettres boite, String nom) {
        this.boite = boite;
        this.nom = nom;
    }

    public void run() {
        for (int cpt = 1; cpt < 5; cpt++) { // Boucle pour déposer 4 lettres
            try {
                // Pause aléatoire avant de déposer une lettre
                Thread.sleep((int) (Math.random() * 2000));
            } catch (InterruptedException e) {
                System.err.println(e.toString());
            }
            boite.deposer(nom + " ,lettre " + cpt);;
        }
    }
}
