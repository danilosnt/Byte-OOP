import models.Conversor;
import models.ConversorBytes;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static final ArrayList<Conversor> valores = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\n===== Menu =====");
            System.out.println("1. Register number of bytes");
            System.out.println("2. List registered numbers");
            System.out.println("3. Convert values");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    cadastrarBytes(scanner);
                    break;
                case 2:
                    listarValores();
                    break;
                case 3:
                    converterValores();
                    break;
                case 4:
                    System.out.println("Ending the program...");
                    break;
                default:
                    System.out.println("Invalid option!");
            }
        } while (opcao != 4);

        scanner.close();
    }

    private static void cadastrarBytes(Scanner scanner) {
        System.out.print("Enter the number of bytes: ");
        BigInteger valor = scanner.nextBigInteger();
        valores.add(new ConversorBytes(valor));
        System.out.println("Value registered successfully!");
    }

    private static void listarValores() {
        if (valores.isEmpty()) {
            System.out.println("No value registered.");
        } else {
            System.out.println("Registered values:");
            for (int i = 0; i < valores.size(); i++) {
                System.out.printf("%d. %s bytes%n", i + 1, valores.get(i).getValor().toString());
            }
        }
    }

    private static void converterValores() {
        if (valores.isEmpty()) {
            System.out.println("No value to convert.");
        } else {
            System.out.println("Conversion results:");
            for (Conversor conversor : valores) {
                System.out.printf("%s bytes = %s%n", conversor.getValor().toString(), conversor.converter());
            }
        }
    }
}
