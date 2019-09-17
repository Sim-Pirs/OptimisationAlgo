public class Objet implements Comparable<Objet> {

    double poids;
    double valeur;
    int indice;
    double ratio;
    /*Question 1 : boolean estpris = false;*/
    double estpris = 0;

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
