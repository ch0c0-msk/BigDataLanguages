import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = "Подсчитать, сколько раз заданное слово входит в текст";
        String wordToSearch = scanner.next();
        int count = countOccurrences(text, wordToSearch);
        System.out.println("Слово '" + wordToSearch + "' встречается " + count + " раз.");
    }

    public static int countOccurrences(String text, String word) {
        int count = 0;
        int index = 0;
        while ((index = text.indexOf(word, index)) != -1) {
            count++;
            index += word.length();
        }
        return count;
    }
}
