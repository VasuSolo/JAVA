import java.util.Scanner;
import java.util.Random;

public class RPSLS {

    enum Move {
        ROCK, PAPER, SCISSORS, LIZARD, SPOCK
    }

    public static int winner(Move player, Move computer) {

        if (player == computer)
            return 0;

        if ((player == Move.ROCK && (computer == Move.SCISSORS || computer == Move.LIZARD)) ||
                (player == Move.PAPER && (computer == Move.ROCK || computer == Move.SPOCK)) ||
                (player == Move.SCISSORS && (computer == Move.PAPER || computer == Move.LIZARD)) ||
                (player == Move.LIZARD && (computer == Move.PAPER || computer == Move.SPOCK)) ||
                (player == Move.SPOCK && (computer == Move.ROCK || computer == Move.SCISSORS))) {

            return 1;
        }

        return -1;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random r = new Random();

        int playerScore = 0;
        int computerScore = 0;

        Move[] moves = Move.values();

        for (int i = 1; i <= 5; i++) {

            System.out.println("\nRound " + i);

            System.out.print("Enter Move (ROCK, PAPER, SCISSORS, LIZARD, SPOCK): ");
            String input = sc.next().toUpperCase();

            Move player = Move.valueOf(input);
            Move computer = moves[r.nextInt(5)];

            System.out.println("Computer Move: " + computer);

            int result = winner(player, computer);

            if (result == 1) {
                System.out.println("You Win!");
                playerScore++;
            } else if (result == -1) {
                System.out.println("Computer Wins!");
                computerScore++;
            } else {
                System.out.println("Draw!");
            }
        }

        System.out.println("\nFinal Score");
        System.out.println("Player = " + playerScore);
        System.out.println("Computer = " + computerScore);

        if (playerScore > computerScore)
            System.out.println("Overall Winner: You");
        else if (computerScore > playerScore)
            System.out.println("Overall Winner: Computer");
        else
            System.out.println("Overall Result: Draw");

        sc.close();
    }
}