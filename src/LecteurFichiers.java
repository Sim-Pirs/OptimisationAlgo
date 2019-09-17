import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class LecteurFichiers {

    public static void LitFichier(String fileName, ArrayList<Objet> objets, SacADos sac){

        double capacity=-1;
        int compteur = 0;

        File file = new File(fileName);

        Scanner sc = null;

        try {
            sc = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        if(sc.hasNextDouble()) //capacité sac à dos
            capacity = Double.parseDouble(sc.next());
            sac.setCapacity(capacity);

        while (sc.hasNextDouble()){
            objets.add(new Objet(sc.nextDouble(),sc.nextDouble(),compteur));
            compteur++;
        }
    }
}
