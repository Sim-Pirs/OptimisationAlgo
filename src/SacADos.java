import java.util.ArrayList;
import java.util.List;

public class SacADos {
    private double capacity;
    private double currentCapacity;
    private ArrayList<Objet> objetsPris = new ArrayList<Objet>();

    public void setCapacity(double capacity){
        this.capacity = capacity;
        currentCapacity = capacity;
    }

    public void setObjets( ArrayList objetsPris){
        this.objetsPris = objetsPris;
    }

    /**
     * Utilise l'algorithme glouton pour remplir le sac     ;)
     * @param objets la liste d'objets triés par ordre décroissant de leurs ratios
     */
    public void Glouton(ArrayList<Objet> objets){
        for(Objet objet : objets){
            if(objet.poids < currentCapacity){
                objetsPris.add(objet);
                currentCapacity -= objet.poids;
            }
        }
    }

    public void afficheObjetsPris(){
        if(objetsPris.size() == 0){
            System.out.println("Le sac est vide !");
            return;
        }
        System.out.println("Liste des objets pris : ");
        utils.afficheObjets(objetsPris);
        System.out.println("_______________");
    }
}
