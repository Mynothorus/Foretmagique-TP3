//Class du trou
public class Trou {
    //Definition des variables id, ligne et colonne
    private int idTrou;
    private int lTrou;
    private int cTrou;

    public Trou(int idTrou, int lTrou, int cTrou){
        this.idTrou = idTrou;
        this.lTrou = lTrou;
        this.cTrou = cTrou;
    }

    // get ligne et colonne
    public int getlTrou() {
        return lTrou;
    }

    public int getcTrou() {
        return cTrou;
    }
}
