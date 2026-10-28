import java.util.Scanner;

class Item {
    private final String name;
    private final int price;

    Item(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    static Item findItem(char code) {
        switch (code) {
            case 'T': return new Item("Tea", 10);
            case 'C': return new Item("Coffee", 15);
            case 'S': return new Item("Samosa", 12);
            case 'P': return new Item("Puff", 20);
            default: return null;
        }
    }
}

class Order {
    private int tokenNo;
    private Item item;
    private int quantity;

    static int nextToken = 101;
    static int totalOrders = 0;
    static int totalSales = 0;

    Order(Item item, int quantity) {
        this.tokenNo = nextToken++;
        this.item = item;
        this.quantity = quantity;

        totalOrders++;
        totalSales += item.getPrice() * quantity;
    }

    int getAmount() {
        return item.getPrice() * quantity;
    }

    static int getTotalOrders() {
        return totalOrders;
    }

    static int getTotalSales() {
        return totalSales;
    }

    public String toString() {
        return "Token " + tokenNo + ": " + item.getName()
                + " x " + quantity + " = " + getAmount();
    }
}
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            char code = sc.next().charAt(0);
            int quantity = sc.nextInt();

            Item item = Item.findItem(code);

            if (item == null || quantity <= 0) {
                System.out.println("Invalid order: " + code + " " + quantity);
            } else {
                Order order = new Order(item, quantity);
                System.out.println(order);
            }
        }
        System.out.println("Total orders: " + Order.getTotalOrders()
                + ", Total sales: " + Order.getTotalSales());

        sc.close();
    }
}