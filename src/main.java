import com.sun.source.tree.LiteralTree;

import java.util.ArrayList;

public class main {
    public static void main(String args[]){

        ArrayList<Objet> objets = new ArrayList<>();
        SacADos sac = new SacADos();

        LecteurFichiers.LitFichier(args[0],objets,sac);
        utils.afficheObjets(objets);
        utils.trieObjets(objets);
        System.out.println("________________________________________");
        utils.afficheObjets(objets);

        sac.Glouton(objets);

        sac.afficheObjetsPris();

        //System.out.println("CAPACITY : " + sac.capacity);
    }

}
