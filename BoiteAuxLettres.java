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
public class BoiteAuxLettres {

    private boolean ok = false;
    private String lettre;

    public synchronized String retirer(String destinataire) {
        try {
            while (!ok) {
                wait(); // la boite aux lettres est vide
            }
        } catch (InterruptedException e) {
            System.out.println(" Interruption");
            System.exit(1);
        }
        System.out.println(destinataire + " lit " + lettre);
        ok = false; // la boîte aux lettres est de nouveau vidée  
        notifyAll();
        return lettre;
    }

    public synchronized void deposer(String lettre) {
        try {
            while (ok) {
                wait(); // Attendez tant que la boîte est pleine
            }
            // Une fois que la boîte n'est pas pleine, déposez la lettre
            this.lettre = lettre;
            System.out.println("dépôt de : " + lettre);
            ok = true; // Marquez la lettre comme déposée
            notifyAll(); // Réveillez les threads en attente pour déposer
        } catch (InterruptedException e) {
            System.out.println("Interruption : " + e.getMessage());
            e.printStackTrace(); // Affichez les détails de l'interruption pour le débogage
            System.exit(1);
        }
    }

}
