import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String telegramText = "Напечатать квитанцию об оплате телеграммы, если стоимость одного слова задана.";
        double wordCost = scanner.nextDouble();

        double totalCost = calculateTotalCost(telegramText, wordCost);
        String receipt = generateReceipt(telegramText, wordCost, totalCost);

        System.out.println(receipt);
    }

    public static double calculateTotalCost(String text, double wordCost) {
        String[] words = text.split("\\s+");
        int wordCount = words.length;
        return wordCount * wordCost;
    }

    public static String generateReceipt(String text, double wordCost, double totalCost) {
        StringBuilder receipt = new StringBuilder();
        receipt.append("Текст телеграммы: ").append(text).append("\n");
        receipt.append("Стоимость одного слова: ").append(wordCost).append(" руб.\n");
        receipt.append("Количество слов: ").append(text.split("\\s+").length).append("\n");
        receipt.append("Общая стоимость: ").append(totalCost).append(" руб.");
        return receipt.toString();
    }
}
