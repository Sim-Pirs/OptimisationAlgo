import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class utils {

    public static void trieObjets(ArrayList<Objet> objets){
        Collections.sort(objets);
    }

    public static void afficheObjets(ArrayList<Objet> objets){
        for(int i=0; i<objets.size(); i++)
            System.out.println(objets.get(i).indice + " " + objets.get(i).poids + "  " + "valeur : " +  objets.get(i).valeur + " " + objets.get(i).ratio);
    }

}
