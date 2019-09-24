import com.sun.source.tree.LiteralTree;

import java.util.ArrayList;

public class main {
    public static void main(String args[]){

        ArrayList<Objet> objets = new ArrayList<>();

        SacADos sac = new SacADos();

        LecteurFichiers.LitFichier(args[0],objets,sac);
        //utils.afficheObjets(objets);
        utils.trieObjets(objets);
        System.out.println("________________________________________");
        //utils.afficheObjets(objets);

        //sac.GloutonFraction(objets);

        //sac.afficheObjetsPris();

        sac.explorationArbre(objets,0,0, 0);

        System.out.println("Valeur optimale : " + sac.valeurMax);
        for(int i = 0; i < sac.bestChemin.length; i++){
            if(sac.bestChemin[i] == 1)
                System.out.println("Objet : " + i + " pris !");
        }

        //System.out.println("CAPACITY : " + sac.capacity);
    }

}
