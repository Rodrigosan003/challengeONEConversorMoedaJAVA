import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.URI;


public class ConversorDeMoedas {

    private static final String API_URL =
            "https://v6.exchangerate-api.com/v6/b0058ecff55bfe70469a10ad/latest/USD";

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;

        while (continuar) {

            // 🔹 BUSCA AS COTAÇÕES NA API
            Map<String, Double> cotacoes = buscarCotacoes();

            if (cotacoes.isEmpty()) {
                System.out.println("Erro ao obter cotações.");
                break;
            }

            double USD_TO_ARS = cotacoes.get("ARS");
            double USD_TO_BRL = cotacoes.get("BRL");
            double USD_TO_COP = cotacoes.get("COP");

            System.out.println("1) Dólar (USD) => Peso Argentino (ARS)");
            System.out.println("2) Peso Argentino (ARS) => Dólar (USD)");
            System.out.println("3) Dólar (USD) => Real Brasileiro (BRL)");
            System.out.println("4) Real Brasileiro (BRL) => Dólar (USD)");
            System.out.println("5) Dólar (USD) => Peso Colombiano (COP)");
            System.out.println("6) Peso Colombiano (COP) => Dólar (USD)");
            System.out.println("7) Sair");
            System.out.print("Escolha uma opção válida: ");

            if (!scanner.hasNextInt()) {
                System.out.println("Entrada inválida.");
                scanner.next();
                continue;
            }

            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.print("Valor em USD: ");
                    double usd1 = readDouble(scanner);
                    System.out.printf("%.2f USD = %.2f ARS%n", usd1, usd1 * USD_TO_ARS);
                    break;

                case 2:
                    System.out.print("Valor em ARS: ");
                    double ars = readDouble(scanner);
                    System.out.printf("%.2f ARS = %.2f USD%n", ars, ars / USD_TO_ARS);
                    break;

                case 3:
                    System.out.print("Valor em USD: ");
                    double usd3 = readDouble(scanner);
                    System.out.printf("%.2f USD = %.2f BRL%n", usd3, usd3 * USD_TO_BRL);
                    break;

                case 4:
                    System.out.print("Valor em BRL: ");
                    double brl = readDouble(scanner);
                    System.out.printf("%.2f BRL = %.2f USD%n", brl, brl / USD_TO_BRL);
                    break;

                case 5:
                    System.out.print("Valor em USD: ");
                    double usd5 = readDouble(scanner);
                    System.out.printf("%.2f USD = %.2f COP%n", usd5, usd5 * USD_TO_COP);
                    break;

                case 6:
                    System.out.print("Valor em COP: ");
                    double cop = readDouble(scanner);
                    System.out.printf("%.2f COP = %.2f USD%n", cop, cop / USD_TO_COP);
                    break;

                case 7:
                    System.out.println("Saindo...");
                    continuar = false;
                    break;

                default:
                    System.out.println("Opção inválida.");
            }

            System.out.println();
        }

        scanner.close();
    }

    // 🔹 MÉTODO QUE CHAMA A API
    private static Map<String, Double> buscarCotacoes() {

        Map<String, Double> cotacoes = new HashMap<>();

        try {
            HttpClient client = HttpClient.newHttpClient();

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(API_URL))
                    .GET()
                    .build();

            HttpResponse<String> response =
                    client.send(request, HttpResponse.BodyHandlers.ofString());

            JsonObject json = JsonParser.parseString(response.body()).getAsJsonObject();
            JsonObject rates = json.getAsJsonObject("conversion_rates");

            cotacoes.put("ARS", rates.get("ARS").getAsDouble());
            cotacoes.put("BRL", rates.get("BRL").getAsDouble());
            cotacoes.put("COP", rates.get("COP").getAsDouble());

        } catch (Exception e) {
            System.out.println("Erro ao acessar API: " + e.getMessage());
        }

        return cotacoes;
    }

    private static double readDouble(Scanner scanner) {
        if (!scanner.hasNextDouble()) {
            scanner.next();
            return 0;
        }
        return scanner.nextDouble();
    }
}

