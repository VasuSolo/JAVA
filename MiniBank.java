import java.util.Scanner;

public class MiniBank {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n================================");
            System.out.println("        MINI BANK SYSTEM");
            System.out.println("================================");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Check Balance");
            System.out.println("5. Transfer Money");
            System.out.println("6. Transaction History");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Create Account feature will be added in future labs.");
                    break;

                case 2:
                    System.out.println("Deposit Money feature will be added in future labs.");
                    break;

                case 3:
                    System.out.println("Withdraw Money feature will be added in future labs.");
                    break;

                case 4:
                    System.out.println("Check Balance feature will be added in future labs.");
                    break;

                case 5:
                    System.out.println("Transfer Money feature will be added in future labs.");
                    break;

                case 6:
                    System.out.println("Transaction History feature will be added in future labs.");
                    break;

                case 7:
                    System.out.println("Thank you for using MiniBank!");
                    break;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }

        } while (choice != 7);

        sc.close();
    }
}
