import java.util.ArrayList;
import java.util.List;

public class SacADos {
    private double capacity;
    private double currentCapacity;
    private ArrayList<Objet> objetsPris = new ArrayList<Objet>();
    double valeurMax;
    int[] bestChemin;

    void setCapacity(double capacity){
        this.capacity = capacity;
        currentCapacity = capacity;
    }

    /**
     * Utilise l'algorithme glouton pour remplir le sac FRACTIONNAIRE    ;)
     * @param objets la liste d'objets triés par ordre décroissant de leurs ratios
     */
    public void GloutonFraction(ArrayList<Objet> objets){
        for(Objet objet : objets){
            if(objet.poids <= currentCapacity){
                objetsPris.add(objet);
                objet.poidspris  = 1;
                currentCapacity -= objet.poids;
            }
            else if(objet.poids > currentCapacity && currentCapacity > 0){
                objet.poidspris = currentCapacity /objet.poids;
                objetsPris.add(objet);
                currentCapacity -= objet.poidspris * objet.poids;
            }
        }
    }

    /**
     * Utilise l'algorithme glouton pour remplir le sac  NON-FRACTIONNAIRE   ;)
     * @param objets la liste d'objets triés par ordre décroissant de leurs ratios
     */
    public void Glouton(ArrayList<Objet> objets){
        for(Objet objet : objets){
            if(objet.poids <= currentCapacity){
                objetsPris.add(objet);
                objet.poidspris  = 1;
                currentCapacity -= objet.poids;
            }
        }
    }

    /**
     * Utilise l'algorithme glouton pour remplir le sac FRACTIONNAIRE    ;)
     * @param objets la liste d'objets triés par ordre décroissant de leurs ratios
     */
    private double GloutonNoeud(ArrayList<Objet> objets, int hauteur, double capacity, double valeurDessus){
        double valeurMaxPossible = 0;

        for(int i = hauteur; i < objets.size(); i++){
            if(objets.get(i).poids <= capacity){
                valeurMaxPossible += objets.get(i).valeur;
                capacity -= objets.get(i).poids;
            }
            else if(objets.get(i).poids > capacity && capacity > 0){
                valeurMaxPossible += objets.get(i).valeur * (capacity / objets.get(i).poids);
                capacity = 0;
            }
        }
        return valeurMaxPossible + valeurDessus;
    }

    /**
     * Exploration et élaguage de l'arbre pour résoudre le problème du sac à dos
     * @param objets La liste d'objets disponibles
     * @param hauteur La hauteur actuelle, désignant l'objet d'indice hauteur
     * @param valeurActuelle La valeur au noeud actuel
     * @param poidsActuel Le poids au noeud actuel
     */
    public void explorationArbreElague(ArrayList<Objet> objets, int hauteur, double valeurActuelle, double poidsActuel){

        double valeurMaxPossible = 0;

        if(hauteur == objets.size()){
            System.out.println("valeur actuelle : " + valeurActuelle);
            if(valeurActuelle > valeurMax){
                bestChemin = utils.saveState(objets);
                valeurMax = valeurActuelle;
            }
        }

        else{
            if(objets.get(hauteur).poids + poidsActuel <= capacity){
                objets.get(hauteur).poidspris = 1;
                explorationArbreElague(objets, hauteur+1, valeurActuelle + objets.get(hauteur).valeur, poidsActuel + objets.get(hauteur).poids);
            }

            valeurMaxPossible = GloutonNoeud(objets, hauteur+1, capacity - poidsActuel, valeurActuelle);

            if(valeurMaxPossible > valeurMax) {
                objets.get(hauteur).poidspris = 0;
                explorationArbreElague(objets, hauteur + 1, valeurActuelle, poidsActuel);
            }
        }

    }

    /**
     * Exploration de l'arbre pour résoudre le problème du sac à dos en force brute
     * @param objets La liste d'objets disponibles
     * @param hauteur La hauteur actuelle, désignant l'objet d'indice hauteur
     * @param valeurActuelle La valeur au noeud actuel
     * @param poidsActuel Le poids au noeud actuel
     */
    public void explorationArbre(ArrayList<Objet> objets, int hauteur, double valeurActuelle, double poidsActuel){

        if(hauteur == objets.size()){
            System.out.println("valeur actuelle : " + valeurActuelle);
            if(valeurActuelle > valeurMax){
                bestChemin = utils.saveState(objets);
                valeurMax = valeurActuelle;
            }
        }

        else{
            if(objets.get(hauteur).poids + poidsActuel <= capacity){
                objets.get(hauteur).poidspris = 1;
                explorationArbre(objets, hauteur+1, valeurActuelle + objets.get(hauteur).valeur, poidsActuel + objets.get(hauteur).poids);
            }

            objets.get(hauteur).poidspris = 0;
            explorationArbre(objets, hauteur+1, valeurActuelle, poidsActuel);
        }
    }

    /**
     * Affiche la liste d'objets pris dans le sac à dos
     */
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
