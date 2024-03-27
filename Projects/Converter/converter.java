import java.util.Scanner;

public class converter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the metric converter!");
        System.out.print("Pick one of these options.\n" + 
                "1. Convert meters to centimeters\n" +
                "2. Convert centimeters to meters\n" +
                "3. Convert kilograms to grams\n" +
                "4. Convert grams to kilograms\n" +
                "Enter your choice (1 to 4): ");

        int choice = scanner.nextInt();

        switch (choice) {
            case 1: 
            convertMetersToCentimeters();
            break;
            case 2:
            convertCentimeterstoMeters();
            break;
            case 3:
            convertKilogramsToGrams();
            break;
            case 4:
            convertGramsToKilograms();
            break;
            //Add more cases for additional conversion types

            default:
            System.out.println("Invalid choice. Please enter a valid option. ");

        }
        scanner.close();
    }
    private static void convertMetersToCentimeters() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter length in meters: ");
        double meters = scanner.nextDouble();
        double centimeters = meters * 100;
        System.out.printf("%.1f meters is equal to %.1f centimeters.%n", meters, centimeters);

    }

    private static void convertCentimeterstoMeters() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter length in centimeters: ");
        double centimeters = scanner.nextDouble();
        double meters = centimeters * 0.01;
        System.out.printf("%.1f centimeters is equal to %.3f meters.%n", centimeters, meters);

    }

    private static void convertKilogramsToGrams()  {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter weight in kilograms: ");
        double kilograms = scanner.nextDouble();
        double grams = kilograms * 1000;
        System.out.printf("%.1f kilograms is equal to %.1f grams.%n", kilograms, grams);

    }

    private static void convertGramsToKilograms() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter weight in grams: ");
        double grams = scanner.nextDouble();
        double kilograms = grams * 0.001;
        System.out.printf("%.1f grams is equal to %.4f kilograms.%n", grams, kilograms);

    }
}
