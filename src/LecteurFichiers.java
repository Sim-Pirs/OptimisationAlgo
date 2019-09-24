import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class LecteurFichiers {

    /**
     * Lis le fichier "fileName" et remplis les valeurs d'objets et du sac
     * @param fileName Le nom du fichier
     * @param objets La liste d'objets
     * @param sac Le sac à dos
     */
    public static void LitFichier(String fileName, ArrayList<Objet> objets, SacADos sac){

        double capacity=-1;
        int compteur = 0;

        File file = new File(fileName);

        Scanner scanner = null;

        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        // lis et sauvegarde la capacité sac à dos qui est la première valeur du fichier
        if(scanner.hasNextDouble())
            capacity = Double.parseDouble(scanner.next());
            sac.setCapacity(capacity);

        // lis et ajoute les objets
        while (scanner.hasNextDouble()){
            objets.add(new Objet(scanner.nextDouble(),scanner.nextDouble(),compteur));
            compteur++;
        }
    }
}
