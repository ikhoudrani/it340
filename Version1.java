import java.util.Random;
import java.util.Scanner;

public class Version1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Entrez le nombre de lignes : ");
        int nombreDeLignes = scanner.nextInt();

        for (int i = 0; i < 6; i++) {
            int premierNombre = getRandomBetween(1, nombreDeLignes);
            int deuxiemeNombre = getRandomBetween(1, 5);
            System.out.println("Pair " + (i + 1) + ": " + premierNombre + ", " + deuxiemeNombre);
        }

        System.out.print("Combien de retirage? ");
        int nombreDeRerolls = scanner.nextInt();

        for (int i = 0; i < nombreDeRerolls; i++) {
            int premierNombre = getRandomBetween(1, nombreDeLignes);
            int deuxiemeNombre = getRandomBetween(1, 5);
            System.out.println("Retirage " + (i + 1) + ": " + premierNombre + ", " + deuxiemeNombre);
        }

        scanner.close();
    }

    private static int getRandomBetween(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min + 1) + min;
    }
}
