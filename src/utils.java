import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class utils {

    /**
     * Trie les objets par orde décroissant en fonction de leur ratio
     * @param objets La liste des objets
     */
    public static void trieObjets(ArrayList<Objet> objets){
        Collections.sort(objets);
    }

    /**
     * Affiche la liste des objets en indiquant s'ils ont été pris
     * @param objets La liste des objets
     */
    public static void afficheObjets(ArrayList<Objet> objets){
        double sum = 0;
        for(int index=0; index<objets.size(); index++) {
            System.out.println(objets.get(index).indice + " " + objets.get(index).poids + "  " + "poids pris : " + objets.get(index).poidspris + " " + "valeur : " + objets.get(index).valeur + " " + objets.get(index).ratio);
            sum += objets.get(index).poidspris * objets.get(index).poids;
            System.out.println(sum);

        }
        System.out.println("sum poids = " + sum);
    }

    /**
     * Sauvegarde le meilleur état des objets possible
     * @param objets La liste des objets
     * @return Le meilleur chemin sous forme de tableau
     */
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
