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
            System.out.println("\n===== Menu Interativo =====");
            System.out.println("1. Cadastrar número de bytes");
            System.out.println("2. Listar valores cadastrados");
            System.out.println("3. Converter valores");
            System.out.println("4. Sair");
            System.out.print("Escolha uma opção: ");
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
                    System.out.println("Encerrando o programa...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 4);

        scanner.close();
    }

    private static void cadastrarBytes(Scanner scanner) {
        System.out.print("Digite o número de bytes: ");
        BigInteger valor = scanner.nextBigInteger();
        valores.add(new ConversorBytes(valor));
        System.out.println("Valor cadastrado com sucesso!");
    }

    private static void listarValores() {
        if (valores.isEmpty()) {
            System.out.println("Nenhum valor cadastrado.");
        } else {
            System.out.println("Valores cadastrados:");
            for (int i = 0; i < valores.size(); i++) {
                System.out.printf("%d. %s bytes%n", i + 1, valores.get(i).getValor().toString());
            }
        }
    }

    private static void converterValores() {
        if (valores.isEmpty()) {
            System.out.println("Nenhum valor para converter.");
        } else {
            System.out.println("Resultados da conversão:");
            for (Conversor conversor : valores) {
                System.out.printf("%s bytes = %s%n", conversor.getValor().toString(), conversor.converter());
            }
        }
    }
}
