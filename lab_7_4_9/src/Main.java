import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();

        String transformedText = transformWords(text);
        System.out.println(transformedText);
    }

    public static String transformWords(String text) {
        StringBuilder result = new StringBuilder();

        String[] words = text.split("\\s+");
        for (String word : words) {
            char firstChar = word.charAt(0);

            boolean isFirstCharMet = false;

            for (char c : word.toCharArray()) {
                if (c == firstChar && !isFirstCharMet) {
                    isFirstCharMet = true;
                    result.append(c);
                } else if (c != firstChar) {
                    result.append(c);
                }
            }

            result.append(" ");
        }

        return result.toString().trim();
    }
}
