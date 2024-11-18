import models.Convert;
import models.ConvertBytes;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static final ArrayList<Convert> values = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int option;

        do {
            System.out.println("\n===== Menu =====");
            System.out.println("1. Register number of bytes");
            System.out.println("2. List registered numbers");
            System.out.println("3. Convert values");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            option = scanner.nextInt();

            switch (option) {
                case 1:
                    registerBytes(scanner);
                    break;
                case 2:
                    listValues();
                    break;
                case 3:
                    convertValues();
                    break;
                case 4:
                    System.out.println("Ending the program...");
                    break;
                default:
                    System.out.println("Invalid option!");
            }
        } while (option != 4);

        scanner.close();
    }

    private static void registerBytes(Scanner scanner) {
        System.out.print("\nEnter the number of bytes: ");
        BigInteger valor = scanner.nextBigInteger();
        values.add(new ConvertBytes(valor));
        System.out.println("\nValue registered successfully!");
    }

    private static void listValues() {
        if (values.isEmpty()) {
            System.out.println("\nNo value registered.");
        } else {
            System.out.println("\nRegistered values:");
            for (int i = 0; i < values.size(); i++) {
                System.out.printf("%d. %s bytes%n", i + 1, values.get(i).getValue().toString());
            }
        }
    }

    private static void convertValues() {
        if (values.isEmpty()) {
            System.out.println("\nNo value to convert.");
        } else {
            System.out.println("\nConversion results:");
            for (Convert convert : values) {
                System.out.printf("%s bytes = %s%n", convert.getValue().toString(), convert.converter());
            }
        }
    }
}