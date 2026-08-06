import java.util.Scanner;

public class VendingMachine {

    enum Coin {
        ONE, TWO, FIVE, TEN
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int price = 15;
        int total = 0;
        Coin coin;

        while (total < price) {

            System.out.print("Enter Coin (1, 2, 5, 10): ");
            int input = sc.nextInt();

            switch (input) {
                case 1:
                    coin = Coin.ONE;
                    break;
                case 2:
                    coin = Coin.TWO;
                    break;
                case 5:
                    coin = Coin.FIVE;
                    break;
                case 10:
                    coin = Coin.TEN;
                    break;
                default:
                    System.out.println("Invalid Coin!");
                    continue;
            }

            switch (coin) {
                case ONE:
                    total += 1;
                    break;
                case TWO:
                    total += 2;
                    break;
                case FIVE:
                    total += 5;
                    break;
                case TEN:
                    total += 10;
                    break;
            }

            System.out.println("Total = " + total);
        }

        System.out.println("Paid. Change: " + (total - price));

        sc.close();
    }
}