import java.util.Scanner;

public class TollBooth {

    record Vehicle(String number, String type) {
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int totalToll = 0;
        int bikeCount = 0;
        int carCount = 0;
        int truckCount = 0;

        while (true) {

            System.out.print("Enter Vehicle Number (or done): ");
            String number = sc.next();

            if (number.equalsIgnoreCase("done")) {
                break;
            }

            System.out.print("Enter Vehicle Type (bike/car/truck): ");
            String type = sc.next().toLowerCase();

            Vehicle v = new Vehicle(number, type);

            int toll = 0;

            switch (v.type()) {
                case "bike":
                    toll = 20;
                    bikeCount++;
                    break;

                case "car":
                    toll = 50;
                    carCount++;
                    break;

                case "truck":
                    toll = 150;
                    truckCount++;
                    break;

                default:
                    System.out.println("Invalid Vehicle Type!");
                    continue;
            }

            totalToll += toll;
        }

        String mostFrequent;

        if (bikeCount >= carCount && bikeCount >= truckCount) {
            mostFrequent = "bike";
        } else if (carCount >= bikeCount && carCount >= truckCount) {
            mostFrequent = "car";
        } else {
            mostFrequent = "truck";
        }

        System.out.println("Total toll: " + totalToll);
        System.out.println("Most frequent: " + mostFrequent);

        sc.close();
    }
}