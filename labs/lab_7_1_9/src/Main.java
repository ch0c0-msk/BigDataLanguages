import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = "Из текста удалить все слова заданной длины, начинающиеся на согласную букву.";
        System.out.println(text);
        int wordLength = scanner.nextInt();
        String result = processText(text, wordLength);
        System.out.println(result);
    }

    public static String processText(String text, int wordLength) {
        StringBuilder result = new StringBuilder();

        String[] words = text.split("\\s+");
        for (String word : words) {
            String cleanWord = cleanWord(word);
            if (cleanWord.length() != wordLength || !startsWithConsonant(cleanWord)) {
                result.append(word).append(" ");
            }
        }

        return result.toString().trim();
    }

    public static boolean startsWithConsonant(String word) {
        char firstChar = Character.toLowerCase(word.charAt(0));
        return !(firstChar == 'a' || firstChar == 'e' || firstChar == 'i' || firstChar == 'o' || firstChar == 'u');
    }

    public static String cleanWord(String word) {

        while (!word.isEmpty() && !Character.isLetterOrDigit(word.charAt(word.length() - 1))) {
            word = word.substring(0, word.length() - 1);
        }
        return word;
    }
}
