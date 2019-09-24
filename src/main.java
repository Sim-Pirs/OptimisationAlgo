import com.sun.source.tree.LiteralTree;

import java.util.ArrayList;

public class main {
    public static void main(String args[]){

        ArrayList<Objet> objets = new ArrayList<>();

        SacADos sac = new SacADos();

        LecteurFichiers.LitFichier(args[0],objets,sac);

        utils.trieObjets(objets);

        sac.explorationArbreElague(objets,0,0, 0);

        System.out.println("Valeur optimale : " + sac.valeurMax);
        for(int index = 0; index < sac.bestChemin.length; index++){
            if(sac.bestChemin[index] == 1)
                System.out.println("Objet : " + index + " pris !");
        }

    }

}
