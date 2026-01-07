import java.util.Scanner;

public class ConversorDeMoedas {

    private static final double USD_TO_ARS = 350.0; // 1 USD = 350 ARS (exemplo)
    private static final double USD_TO_BRL = 5.0;   // 1 USD = 5 BRL (exemplo)
    private static final double USD_TO_COP = 4500.0; // 1 USD = 4500 COP (exemplo)

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;

        while (continuar) {

            
            System.out.println("1) Dólar (USD) => Peso Argentino (ARS)");
            System.out.println("2) Peso Argentino (ARS) => Dólar (USD)");
            System.out.println("3) Dólar (USD) => Real Brasileiro (BRL)");
            System.out.println("4) Real Brasileiro (BRL) => Dólar (USD)");
            System.out.println("5) Dólar (USD) => Peso Colombiano (COP)");
            System.out.println("6) Peso Colombiano (COP) => Dólar (USD)");
            System.out.println("7) Sair");
            System.out.print("Escolha uma opção válida: ");

            if (!scanner.hasNextInt()) {
                System.out.println("Entrada inválida. Tente novamente.");
                scanner.next(); // descarta entrada inválida
                continue;
            }

            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.print("Informe o valor em Dólares (USD): ");
                    double usd1 = readDouble(scanner);
                    if (usd1 >= 0) {
                        System.out.printf("%.2f USD = %.2f ARS%n", usd1, usd1 * USD_TO_ARS);
                    }
                    break;
                case 2:
                    System.out.print("Informe o valor em Pesos Argentinos (ARS): ");
                    double ars = readDouble(scanner);
                    if (ars >= 0) {
                        System.out.printf("%.2f ARS = %.2f USD%n", ars, ars / USD_TO_ARS);
                    }
                    break;
                case 3:
                    System.out.print("Informe o valor em Dólares (USD): ");
                    double usd3 = readDouble(scanner);
                    if (usd3 >= 0) {
                        System.out.printf("%.2f USD = %.2f BRL%n", usd3, usd3 * USD_TO_BRL);
                    }
                    break;
                case 4:
                    System.out.print("Informe o valor em Reais (BRL): ");
                    double brl = readDouble(scanner);
                    if (brl >= 0) {
                        System.out.printf("%.2f BRL = %.2f USD%n", brl, brl / USD_TO_BRL);
                    }
                    break;
                case 5:
                    System.out.print("Informe o valor em Dólares (USD): ");
                    double usd5 = readDouble(scanner);
                    if (usd5 >= 0) {
                        System.out.printf("%.2f USD = %.2f COP%n", usd5, usd5 * USD_TO_COP);
                    }
                    break;
                case 6:
                    System.out.print("Informe o valor em Pesos Colombianos (COP): ");
                    double cop = readDouble(scanner);
                    if (cop >= 0) {
                        System.out.printf("%.2f COP = %.2f USD%n", cop, cop / USD_TO_COP);
                    }
                    break;
                case 7:
                    System.out.println("Saindo do programa...");
                    continuar = false;
                    break;
                default:
                    System.out.println("Opção inválida. Por favor, selecione uma opção válida.");
                    break;
            }

            System.out.println();
        }

        scanner.close();
    }

    private static double readDouble(Scanner scanner) {
        if (!scanner.hasNextDouble()) {
            System.out.println("Entrada inválida. Operação cancelada.");
            scanner.next(); // descarta entrada inválida
            return -1;
        }
        return scanner.nextDouble();
    }
}
