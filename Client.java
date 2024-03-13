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
public class Client {

    public static void main(String[] args) {
        BoiteAuxLettres b = new BoiteAuxLettres();
        Producteur p1 = new Producteur(b, "aymen");
        Producteur p2 = new Producteur(b, "yahya");
        Consommateur c1 = new Consommateur(b, "imane");
        Consommateur c2 = new Consommateur(b, "rim");
        p1.start();
        p2.start();
        c1.start();
        c2.start();
    }
}
