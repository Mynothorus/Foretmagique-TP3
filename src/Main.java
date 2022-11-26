import java.time.chrono.IsoChronology;
import java.util.ArrayList;
import java.lang.Math;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        //déclaration des variables
        int level = 1; //numéro du level
        int reponse = 0; //var de test pour bloquer le programme
        boolean varpersoAlive= true; //var le perso est en vie

        Scanner scanner = new Scanner(System.in); //déclaration scanner pour ecrire dans la consol

        //boucle infinie tant que le joueur est en vie
        while (varpersoAlive) {
            //déclaration environnement, perso et regle
            Environnement environnement = new Environnement(level);
            Personnage perso = new Personnage(environnement);
            Regles regles = new Regles(environnement, perso);


            System.out.println("Légende :");
            System.out.println("0: vide | 1: portail | 2: monstre | 3: puanteur");
            System.out.println("4: trou | 5: vent | 8: pu et vent | 9: perso");
            System.out.println("Plateau au level: " + level);


            environnement.createForet(); //création de la table foret vide
            environnement.addPortail(); //ajout du portail

            //Création des monstres:  x monstre pour x niveau
            for (int i = 0; i < level; ++i) {
                //génération aléatoire des coordonnées d'un monstre
                do {
                    environnement.genMonstre();
                }
                while (!regles.isMonsterCanStayHere()); // test si le monstre peut etre ici
                //ajouter monstre
                environnement.addMonstre();
                //ajouter la puanteur associé au monstre
                if (regles.isPuantCanStayHere(+1, 0)) {
                    environnement.addPuant(+1, 0);
                }
                if (regles.isPuantCanStayHere(-1, 0)) {
                    environnement.addPuant(-1, 0);
                }
                if (regles.isPuantCanStayHere(0, +1)) {
                    environnement.addPuant(0, +1);
                }
                if (regles.isPuantCanStayHere(0, -1)) {
                    environnement.addPuant(0, -1);
                }

            }
            //Création des trous:  x trou pour x niveau
            for (int i = 0; i < level; ++i) {
                //génération aléatoire des coordonnées d'un trou
                do {
                    environnement.genTrou();
                }
                while (!regles.isTrouCanStayHere()); // test si le trou peut etre ici
                //ajouter trou
                environnement.addTrou();
                //ajouter vent associé au trou
                if (regles.isVentCanStayHere(+1, 0) != 0) {
                    environnement.addVent(+1, 0, regles.isVentCanStayHere(+1, 0));
                }
                if (regles.isVentCanStayHere(-1, 0) != 0) {
                    environnement.addVent(-1, 0, regles.isVentCanStayHere(-1, 0));
                }
                if (regles.isVentCanStayHere(0, +1) != 0) {
                    environnement.addVent(0, +1, regles.isVentCanStayHere(0, +1));
                }
                if (regles.isVentCanStayHere(0, -1) != 0) {
                    environnement.addVent(0, -1, regles.isVentCanStayHere(0, -1));
                }

            }

            //Création du perso
            do {
                perso.genPerso(); //génération des coordonées aléatoire du perso
            }
            while (!regles.isPersoCanStayHere()); //test si le perso peut etre ici
            //ajouter perso
            perso.addPerso();
            //Création des grilles de déplacements, de probabilités de monstre et de probabilités de trou
            perso.createGrillePerso(perso.getGdeplacement(), 0);
            perso.createGrillePerso(perso.getGprobaM(), 0);
            perso.createGrillePerso(perso.getGprobaT(), 0);
            perso.addDeplacementgrille(); //ajout de la coordonée de spawn du perso à la grille déplacements

            //Affichage de la foret
            environnement.printForet();
            //Affichage des 3 grilles du personnage
            perso.printtroigrille();

            //Blocage du programme pour les tests
            //ICI devrat se trouver l'exploration
            System.out.println("Mort de perso: 1 ou Next level: 2 ");
            reponse = scanner.nextInt();
            if (reponse == 1){varpersoAlive=false;}
            else {level=level+1;}
        }
    }
}
