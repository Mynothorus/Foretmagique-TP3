import java.util.ArrayList;
import java.util.Random;
//Class génération de l'environnement
public class Environnement {
    //definition des var
    private  int level;
    private  int nbLigneColonnes;
    private int lMonster;
    private int cMonster;
    private int lPortail;
    private int cPortail;
    private int lTrou;
    private int cTrou;

//Création grille (foret), tableau de monstre et tableau de trou
    private ArrayList<ArrayList<Integer>> grille = new ArrayList<>();
    private   ArrayList<Monstre> tabemonstre = new ArrayList<>();
    private   ArrayList<Trou> tabetrou = new ArrayList<>();

    //Association level et nombre de ligne/colonne
    public Environnement(int level){
        this.level = level;
        nbLigneColonnes = level + 2;
    }

    //Création de la foret: un tableau de n ligne/colonne de 0
    public void createForet (){
    for(int i = 0; i < nbLigneColonnes ; i++) {
        ArrayList<Integer> ligne = new ArrayList<>();
        for (int j = 0; j < nbLigneColonnes; j++) {
            ligne.add(0);
        }
        grille.add(ligne);
    }
}

//Affichage de la foret
public void printForet(){
for(int i=0; i<nbLigneColonnes;i++){
    System.out.println(grille.get(i));
}
}

//Ajout de portail aléatoirement sur la foret
public void addPortail(){
    lPortail =  new Random().nextInt(nbLigneColonnes);
    cPortail = new Random().nextInt(nbLigneColonnes);
    grille.get(lPortail).set(cPortail, 1);
}

//Génération aléatoire d'un monstre
public void genMonstre(){
    lMonster =  new Random().nextInt(nbLigneColonnes);
    cMonster = new Random().nextInt(nbLigneColonnes);

}

//Ajout d'un monstre à la foret et au tableau de monstre
public void addMonstre(){
    grille.get(getlMonster()).set(getcMonster(), 2);
    tabemonstre.add(new Monstre(tabemonstre.size(), lMonster, cMonster));
}

//Ajout de la puanteur en fonction des coordonnées du monstre (haut/bas/gauche/droite)
public void addPuant(int varpuantl, int varpuantc){
    grille.get(getlMonster()+varpuantl).set(getcMonster()+varpuantc, 3);
}

//Génération aléatoire d'un trou
public void genTrou(){
    lTrou =  new Random().nextInt(nbLigneColonnes);
    cTrou = new Random().nextInt(nbLigneColonnes);
    }

    //Ajout d'un trou à la foret et au tableau de trou
    public void addTrou(){
        grille.get(getlTrou()).set(getcTrou(), 4);
        tabetrou.add(new Trou(tabetrou.size(), lTrou, cTrou));
    }

    //Ajout du vent en fonction des coordonnées du trou (haut/bas/gauche/droite) et de ce qui si trouve deja (valeurvent)
    public void addVent(int varventl, int varventc, int valeurvent){
        grille.get(getlTrou()+varventl).set(getcTrou()+varventc, valeurvent);
    }

//GET
    public int getNbLigneColonnes() {
        return nbLigneColonnes;
    }
    public ArrayList<ArrayList<Integer>> getGrille() {
        return grille;
    }

    public int getlMonster() {
        return lMonster;
    }

    public int getcMonster() {
        return cMonster;
    }

    public int getlPortail() {
        return lPortail;
    }

    public int getcPortail() {
        return cPortail;
    }

    public int getlTrou() {
        return lTrou;
    }

    public int getcTrou() {
        return cTrou;
    }

    public ArrayList<Monstre> getTabemonstre() {
        return tabemonstre;
    }

    public ArrayList<Trou> getTabetrou() {
        return tabetrou;
    }

    public void setGrille(ArrayList<ArrayList<Integer>> grille) {
        this.grille = grille;
    }
}
