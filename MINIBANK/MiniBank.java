
import java.util.*;

public class MiniBank {
    static Scanner sc = new Scanner(System.in);
    static HashMap<Integer, Account> accounts = new HashMap<>();
    static int nextAccount = 1001;

    static class Account {
        int number;
        String name;
        double balance;

        Account(int number, String name, double balance) {
            this.number = number;
            this.name = name;
            this.balance = balance;
        }
    }

    static int readInt() {
        try {
            return Integer.parseInt(sc.nextLine().trim());
        } catch (Exception e) {
            return -1;
        }
    }

    static double readAmount() {
        try {
            double amount = Double.parseDouble(sc.nextLine().trim());
            return Double.isFinite(amount) ? amount : -1;
        } catch (Exception e) {
            return -1;
        }
    }

    static Account findAccount(int number) {
        return accounts.get(number);
    }

    static void openAccount() {
        System.out.print("Enter customer name: ");
        String name = sc.nextLine().trim();

        if (name.isEmpty()) {
            System.out.println("Name cannot be empty!");
            return;
        }

        System.out.print("Enter initial deposit: ");
        double amount = readAmount();

        if (amount < 0) {
            System.out.println("Invalid amount!");
            return;
        }

        Account a = new Account(nextAccount++, name, amount);
        accounts.put(a.number, a);

        System.out.println("Account created successfully!");
        System.out.println("Account Number: " + a.number);
        System.out.printf("Balance: %.2f%n", a.balance);
    }

    static void deposit() {
        System.out.print("Enter account number: ");
        Account a = findAccount(readInt());

        if (a == null) {
            System.out.println("Account not found!");
            return;
        }

        System.out.print("Enter deposit amount: ");
        double amount = readAmount();

        if (amount <= 0) {
            System.out.println("Invalid amount!");
            return;
        }

        a.balance += amount;
        System.out.println("Deposit successful!");
        System.out.printf("Balance: %.2f%n", a.balance);
    }

    static void withdraw() {
        System.out.print("Enter account number: ");
        Account a = findAccount(readInt());

        if (a == null) {
            System.out.println("Account not found!");
            return;
        }

        System.out.print("Enter withdrawal amount: ");
        double amount = readAmount();

        if (amount <= 0) {
            System.out.println("Invalid amount!");
        } else if (amount > a.balance) {
            System.out.println("Insufficient balance!");
        } else {
            a.balance -= amount;
            System.out.println("Withdrawal successful!");
            System.out.printf("Balance: %.2f%n", a.balance);
        }
    }

    static void transfer() {
        System.out.print("Enter sender account number: ");
        Account sender = findAccount(readInt());

        System.out.print("Enter receiver account number: ");
        Account receiver = findAccount(readInt());

        if (sender == null || receiver == null) {
            System.out.println("Account not found!");
            return;
        }

        if (sender == receiver) {
            System.out.println("Cannot transfer to same account!");
            return;
        }

        System.out.print("Enter transfer amount: ");
        double amount = readAmount();

        if (amount <= 0) {
            System.out.println("Invalid amount!");
        } else if (amount > sender.balance) {
            System.out.println("Insufficient balance!");
        } else {
            sender.balance -= amount;
            receiver.balance += amount;
            System.out.println("Transfer successful!");
        }
    }

    static void displayAccounts() {
        if (accounts.isEmpty()) {
            System.out.println("No accounts available!");
            return;
        }

        for (Account a : accounts.values()) {
            System.out.println("--------------------");
            System.out.println("Account Number: " + a.number);
            System.out.println("Customer Name: " + a.name);
            System.out.printf("Balance: %.2f%n", a.balance);
        }
    }

    public static void main(String[] args) {
        boolean running = true;

        while (running) {
            System.out.println("\n===== MINI BANK =====");
            System.out.println("1. Open Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Transfer");
            System.out.println("5. Display All Accounts");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            int choice = readInt();

            switch (choice) {
                case 1 -> openAccount();
                case 2 -> deposit();
                case 3 -> withdraw();
                case 4 -> transfer();
                case 5 -> displayAccounts();
                case 6 -> {
                    running = false;
                    System.out.println("Thank you for using MiniBank!");
                }
                default -> System.out.println("Invalid choice! Try again.");
            }
        }

        sc.close();
    }
}
