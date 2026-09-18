import java.util.*;

interface Discount {
    double calculate(double price);
}

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        double[] prices = {100, 200, 500};

        System.out.println("1. 10% Discount");
        System.out.println("2. 20% Discount");
        System.out.print("Enter choice: ");
        int choice = sc.nextInt();

        Discount discount;

        if (choice == 1) {
            discount = price -> price * 0.90;
        } else {
            discount = price -> price * 0.80;
        }

        for (double price : prices) {
            System.out.println("Price: " + price);
            System.out.println("After Discount: " + discount.calculate(price));
        }
    }
}