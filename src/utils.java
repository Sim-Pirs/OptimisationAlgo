import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class utils {

    public static void trieObjets(ArrayList<Objet> objets){
        Collections.sort(objets);
    }

    public static void afficheObjets(ArrayList<Objet> objets){
        double sum = 0;
        for(int i=0; i<objets.size(); i++) {
            System.out.println(objets.get(i).indice + " " + objets.get(i).poids + "  " + "poids pris : " + objets.get(i).poidspris + " " + "valeur : " + objets.get(i).valeur + " " + objets.get(i).ratio);
            sum += objets.get(i).poidspris * objets.get(i).poids;
            System.out.println(sum);

        }
        System.out.println("sum poids = " + sum);
    }

    public static int[] saveState(ArrayList<Objet> objets){
        int[] chemin = new int[objets.size()];

        for (Objet objet : objets) {
            if (objet.poidspris == 1)
                chemin[objet.indice] = 1;
            else chemin[objet.indice] = 0;
        }
        return chemin;
    }
}
