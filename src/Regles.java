//Class des règles
public class Regles {
    Environnement environnement;
    Personnage perso;
    public Regles(Environnement environnement, Personnage perso){
         this.environnement = environnement;
         this.perso = perso;
    }

    //Test si un monstre peut rester ici
 public boolean isMonsterCanStayHere(){
       //Interdit d'etre sur le portaile ou à coté (en haut/bas/gauche/droite)
        if (
                environnement.getlPortail() == environnement.getlMonster() && environnement.getcPortail() == environnement.getcMonster()
               || environnement.getlPortail()+1 == environnement.getlMonster() && environnement.getcPortail() == environnement.getcMonster()
                || environnement.getlPortail()-1 == environnement.getlMonster() && environnement.getcPortail() == environnement.getcMonster()
                || environnement.getlPortail() == environnement.getlMonster() && environnement.getcPortail()+1 == environnement.getcMonster()
                || environnement.getlPortail() == environnement.getlMonster() && environnement.getcPortail()-1 == environnement.getcMonster()
        ){
            return false;
        }
     //Interdit d'etre sur un autre monstre ou à coté (en haut/bas/gauche/droite)
     for (Monstre monstre : environnement.getTabemonstre()){
        if( monstre.getlMonster() == environnement.getlMonster() && monstre.getcMonster() == environnement.getcMonster()
                 || monstre.getlMonster()+1 == environnement.getlMonster() && monstre.getcMonster() == environnement.getcMonster()
                 || monstre.getlMonster()-1 == environnement.getlMonster() && monstre.getcMonster() == environnement.getcMonster()
                 || monstre.getlMonster() == environnement.getlMonster() && monstre.getcMonster()+1 == environnement.getcMonster()
                 || monstre.getlMonster() == environnement.getlMonster() && monstre.getcMonster()-1 == environnement.getcMonster()
        ){
            return false;
        }
     }
        return true;
    }

    //Test si un trou peut etre ici
    public boolean isTrouCanStayHere(){
        //Interdit d'etre sur le portaile ou à coté (en haut/bas/gauche/droite)
        if (
                environnement.getlPortail() == environnement.getlTrou() && environnement.getcPortail() == environnement.getcTrou()
                || environnement.getlPortail()+1 == environnement.getlTrou() && environnement.getcPortail() == environnement.getcTrou()
                || environnement.getlPortail()-1 == environnement.getlTrou() && environnement.getcPortail() == environnement.getcTrou()
                || environnement.getlPortail() == environnement.getlTrou() && environnement.getcPortail()+1 == environnement.getcTrou()
                || environnement.getlPortail() == environnement.getlTrou() && environnement.getcPortail()-1 == environnement.getcTrou()
        ){
            return false;
        }
        //Interdit d'etre sur un monstre ou à coté (en haut/bas/gauche/droite)
        for (Monstre monstre : environnement.getTabemonstre()){
            if( monstre.getlMonster() == environnement.getlTrou() && monstre.getcMonster() == environnement.getcTrou()
                    || monstre.getlMonster()+1 == environnement.getlTrou() && monstre.getcMonster() == environnement.getcTrou()
                    || monstre.getlMonster()-1 == environnement.getlTrou() && monstre.getcMonster() == environnement.getcTrou()
                    || monstre.getlMonster() == environnement.getlTrou() && monstre.getcMonster()+1 == environnement.getcTrou()
                    || monstre.getlMonster() == environnement.getlTrou() && monstre.getcMonster()-1 == environnement.getcTrou()
            ){
                return false;
            }

        }
        //Interdit d'etre sur un autre trou ou à coté (en haut/bas/gauche/droite)
        for (Trou trou : environnement.getTabetrou()){
            if( trou.getlTrou() == environnement.getlTrou() && trou.getcTrou() == environnement.getcTrou()
                    || trou.getlTrou()+1 == environnement.getlTrou() && trou.getcTrou() == environnement.getcTrou()
                    || trou.getlTrou()-1 == environnement.getlTrou() && trou.getcTrou() == environnement.getcTrou()
                    || trou.getlTrou() == environnement.getlTrou() && trou.getcTrou()+1 == environnement.getcTrou()
                    || trou.getlTrou() == environnement.getlTrou() && trou.getcTrou()-1 == environnement.getcTrou()
            ){
                return false;
            }
        }
        return true;
    }

    //Test si la case pour poser une puanteur existe en fonction de la case tester (en haut/bas/gauche/droite)
public boolean isPuantCanStayHere(int varpuantl, int varpuantc){
        if(varpuantl== +1 && environnement.getlMonster()+1<environnement.getNbLigneColonnes()){return true;}
        if(varpuantl== -1 && environnement.getlMonster()-1>=0){return true;}
        if(varpuantc== +1 && environnement.getcMonster()+1<environnement.getNbLigneColonnes()){return true;}
        if(varpuantc== -1 && environnement.getcMonster()-1>=0){return true;}
        return false;
}

    //Test si la case pour poser un vent existe et si il y a quelque chose présent en fonction de la case tester (en haut/bas/gauche/droite)
public int isVentCanStayHere(int varventl, int varventc){
    if(varventl== +1 && environnement.getlTrou()+1<environnement.getNbLigneColonnes()){ //Si existe
        if (environnement.getGrille().get(environnement.getlTrou() + 1).get(environnement.getcTrou()) == 0)
        {
            return 5; //si rien sur la case alors retour 5
        } ;
        if (environnement.getGrille().get(environnement.getlTrou() + 1).get(environnement.getcTrou()) == 3) {
           return 8; //si puanteur deja présente alors retour 8
        } ;
    }
    if(varventl== -1 && environnement.getlTrou()-1>=0){
        if (environnement.getGrille().get(environnement.getlTrou() -1).get(environnement.getcTrou()) == 0) {
            return  5;
        } ;
        if (environnement.getGrille().get(environnement.getlTrou() -1).get(environnement.getcTrou()) == 3) {
            return 8;
        } ;
 }
    if(varventc== +1 && environnement.getcTrou()+1<environnement.getNbLigneColonnes()){
        if (environnement.getGrille().get(environnement.getlTrou()).get(environnement.getcTrou()+1) == 0 ) {
            return 5;
        } ;
        if (environnement.getGrille().get(environnement.getlTrou()).get(environnement.getcTrou()+1) == 3) {
            return 8;
        } ;
    }
    if(varventc== -1 && environnement.getcTrou()-1>=0){
        if (environnement.getGrille().get(environnement.getlTrou()).get(environnement.getcTrou()-1) == 0) {
            return 5;
        } ;
        if (environnement.getGrille().get(environnement.getlTrou()).get(environnement.getcTrou()-1) == 3) {
            return  8;
        } ;
}
    return 0;

}

//test si le perso peut etre ici :  etre sur une case vide
public boolean isPersoCanStayHere(){
        if(environnement.getGrille().get(perso.getlPersonnage()).get(perso.getcPersonnage()) == 0){
            return true;
        }
        return false;
}

//test si le perso est mort : etre sur une case monstre (2) ou trou (4)
public boolean isPersoDead(){
        if(environnement.getGrille().get(perso.getlPersonnage()).get(perso.getcPersonnage()) == 2 ){
            return true;
        }
        if(environnement.getGrille().get(perso.getlPersonnage()).get(perso.getcPersonnage()) == 4 ){
            return true;
        }
        return false;
}


}
