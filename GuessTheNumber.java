import java.util.Random;
import java.util.Scanner;

public class GuessTheNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random r = new Random();

        int lower = 1;
        int upper = 100;
        int maxA = 5;
        int Rounds = 0;
        int points = 0;

        System.out.println("\nWelcome To Guess The Number Game!");

        do {
            int rn = getRn(lower, upper);
            int x;
            int no_of_attempts = 0;

            System.out.println("\nRound " + (Rounds + 1));
            System.out.println("\nGuess the number between " + lower + " and " + upper);

            do {
                System.out.print("\nGuess the number: ");
                x = sc.nextInt();
                no_of_attempts++;

                if (x == rn) {
                    System.out.println("\nCongratulations,you gussed the correct number in  " + no_of_attempts + " attempts\n.");
                    points += maxA - no_of_attempts + 1;
                } else if (x < rn) {
                    System.out.println("\nnumber you have  entered is too low,try again");
                } else {
                    System.out.println("\nnumber you have  entered is too high,try again");
                }

            } while (x != rn && no_of_attempts < maxA);

            System.out.println("\nThe correct number was: " + rn);
            Rounds++;

            System.out.print("\nEnter yay to play again,to end the game enter No: \n");
        } while (sc.next().equalsIgnoreCase("yay"));

        System.out.println("Game Over!");
        System.out.println("\nYour total score is: " + points);
    }

    private static int getRn(int lower, int upper) {
        return new Random().nextInt(upper - lower+ 1) + lower;
    }
}
