import java.util.Scanner;

public class CurrencyConverter {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("******************** Welcome to Currency Converter! ********************");
        System.out.println();
        System.out.println("Select your base currency:");
        System.out.println();
        System.out.println("1. USD (United States Dollar)");
        System.out.println("2. EUR (Euro)");
        System.out.println("3. GBP (British Pound)");
        System.out.println("4. JPY (Japanese Yen)");
        System.out.println("5. AUD (Australian Dollar)");
        System.out.print("Enter your choice: ");
        int baseCurrencyChoice = Integer.parseInt(scanner.nextLine());

        System.out.println("Select your target currency:");
        System.out.println("1. USD (United States Dollar)");
        System.out.println("2. EUR (Euro)");
        System.out.println("3. GBP (British Pound)");
        System.out.println("4. JPY (Japanese Yen)");
        System.out.println("5. AUD (Australian Dollar)");
        System.out.print("Enter your choice: ");
        int targetCurrencyChoice = Integer.parseInt(scanner.nextLine());

        System.out.print("Enter the amount you want to convert: ");
        double amount = Double.parseDouble(scanner.nextLine());

        double conversionRate = getConversionRate(baseCurrencyChoice, targetCurrencyChoice);
        double convertedAmount = amount * conversionRate;

        String baseCurrencySymbol = getCurrencySymbol(baseCurrencyChoice);
        String targetCurrencySymbol = getCurrencySymbol(targetCurrencyChoice);

        System.out.println(amount + " " + baseCurrencySymbol + " equals " + convertedAmount + " " + targetCurrencySymbol);
    }

    private static double getConversionRate(int baseCurrencyChoice, int targetCurrencyChoice) {
        // In a real implementation, you would fetch real-time exchange rates from a reliable API
        // For the sake of simplicity, we'll just use hardcoded conversion rates here
        double[][] conversionRates = {
            {1.0, 0.85, 0.72, 109.51, 1.33},  // USD
            {1.18, 1.0, 0.84, 128.20, 1.55},   // EUR
            {1.39, 1.19, 1.0, 152.71, 1.85},   // GBP
            {0.0091, 0.0078, 0.0066, 1.0, 0.012},  // JPY
            {0.75, 0.64, 0.54, 81.88, 1.0}     // AUD
        };
        return conversionRates[baseCurrencyChoice - 1][targetCurrencyChoice - 1];
    }

    private static String getCurrencySymbol(int currencyChoice) {
        switch (currencyChoice) {
            case 1: return "USD";
            case 2: return "EUR";
            case 3: return "GBP";
            case 4: return "JPY";
            case 5: return "AUD";
            default: return "";
        }
    }
}

