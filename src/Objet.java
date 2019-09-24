public class Objet implements Comparable<Objet> {

    double poids;
    double valeur;
    int indice;
    double ratio;
    /*Question 1 : boolean estpris = false;*/
    double poidspris = 0; // 0 pas pris; 1 pris; 0<poidspris<1 partie de l'objet pris.

    public Objet(double poids, double valeur, int indice) {
        this.poids = poids;
        this.valeur = valeur;
        this.indice = indice;
        ratio = this.valeur / this. poids;
    }

    @Override
    public int compareTo(Objet o) {
        if(this.ratio < o.ratio )
            return 1;
        return -1;
    }
}
