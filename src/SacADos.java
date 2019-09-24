import java.util.ArrayList;
import java.util.List;

public class SacADos {
    private double capacity;
    private double currentCapacity;
    private ArrayList<Objet> objetsPris = new ArrayList<Objet>();
    double meilleurPoids;
    double valeurMax;
    int[] bestChemin;

    public void setCapacity(double capacity){
        this.capacity = capacity;
        currentCapacity = capacity;
    }

    public void setObjets( ArrayList objetsPris){
        this.objetsPris = objetsPris;
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
    public void GloutonNoeud(ArrayList<Objet> objets, int hauteur){
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

            glouton

            objets.get(hauteur).poidspris = 0;
            explorationArbre(objets, hauteur+1, valeurActuelle, poidsActuel);
        }

    }

    public void explorationArbreElaguer(ArrayList<Objet> objets, int hauteur, double valeurActuelle, double poidsActuel){

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
