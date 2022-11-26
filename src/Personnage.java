import java.util.ArrayList;
import java.util.Random;
//Class du perso
public class Personnage {
private int cPersonnage;
private int lPersonnage;
private boolean isAlive = true;
  //Création grille déplacement, proba Monstre et proba Trou
  private ArrayList<ArrayList<Integer>> gdeplacement = new ArrayList<>();
  private ArrayList<ArrayList<Integer>> gprobaM = new ArrayList<>();
  private ArrayList<ArrayList<Integer>> gprobaT = new ArrayList<>();
  Environnement environnement;
  public Personnage(Environnement environnement){this.environnement = environnement;
  }

  //Création des grilles perso (déplacement, proba Monstre, proba Trou) et à remplir en fonction de fill
  public void createGrillePerso(ArrayList<ArrayList<Integer>> grilleP, int fill) {
    for (int i = 0; i < environnement.getNbLigneColonnes(); i++) {
      ArrayList<Integer> ligne = new ArrayList<>();
      for (int j = 0; j < environnement.getNbLigneColonnes(); j++) {
        ligne.add(fill);
      }
      grilleP.add(ligne);
    }
  }

//Affichage des 3 grilles
  public void printtroigrille(){
    System.out.println("Grille de déplacement");
    for(int i=0; i<environnement.getNbLigneColonnes();i++){
      System.out.println(gdeplacement.get(i));
    }
    System.out.println("Grille de proba Monstre");
    for(int i=0; i<environnement.getNbLigneColonnes();i++){
      System.out.println(gprobaM.get(i));
    }
    System.out.println("Grille de proba Trou");
    for(int i=0; i<environnement.getNbLigneColonnes();i++){
      System.out.println(gprobaT.get(i));
    }
  }

  //Génération aléatoire du perso
  public void genPerso(){
    lPersonnage =  new Random().nextInt(environnement.getNbLigneColonnes());
    cPersonnage = new Random().nextInt(environnement.getNbLigneColonnes());
  }

  //Ajout du perso sur la foret
  public void addPerso(){
    environnement.getGrille().get(getlPersonnage()).set(getcPersonnage(), 9);
   }

//Ajout du perso sur la grille déplacement
   public void addDeplacementgrille(){
    gdeplacement.get(getlPersonnage()).set(getcPersonnage(), 1);

   }

//Get
  public int getcPersonnage() {
    return cPersonnage;
  }
  public int getlPersonnage() {
    return lPersonnage;
  }
  public ArrayList<ArrayList<Integer>> getGdeplacement() {
    return gdeplacement;
  }
  public ArrayList<ArrayList<Integer>> getGprobaM() {
    return gprobaM;
  }
  public ArrayList<ArrayList<Integer>> getGprobaT() {
    return gprobaT;
  }
}
