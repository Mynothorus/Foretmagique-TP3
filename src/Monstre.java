//Class du monstre
public class Monstre {
    //Definition des variables id, ligne et colonne
    private int idMonstre;
    private int lMonster;
    private int cMonster;

    public Monstre(int idMonstre, int lMonster, int cMonster){
        this.idMonstre = idMonstre;
        this.lMonster = lMonster;
        this.cMonster = cMonster;
    }

    // get ligne et colonne
    public int getlMonster() {
        return lMonster;
    }

    public int getcMonster() {
        return cMonster;
    }
}
