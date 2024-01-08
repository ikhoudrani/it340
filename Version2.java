import java.util.Random;
import java.util.Scanner;

public class Version2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Entrez le nombre de lignes : ");
        int linesNumber = scanner.nextInt();

        printPairs(6, "Pair", linesNumber);

        System.out.print("Combien de retirage? ");
        int rerollsNumber = scanner.nextInt();

        printPairs(rerollsNumber, "Reroll", linesNumber);

        scanner.close();
    }

    private static int getRandomBetween(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min + 1) + min;
    }

    private static void printPairs(int length, String type, int linesNumber){
            for (int i = 0; i < length; i++) {
                int firstNumber = getRandomBetween(1, linesNumber);
                int secondNumber = getRandomBetween(1, 5);
                System.out.println(type + (i + 1) + ": " + firstNumber + ", " + secondNumber);
        }
    }
}
