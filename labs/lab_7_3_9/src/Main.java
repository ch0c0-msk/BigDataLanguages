import java.util.*;

public class Main {
    public static void main(String[] args) {
        String russianText = "Напечатать слова русского текста в алфавитном порядке по первой букве. Слова, начинающиеся с новой буквы, печатать с красной строки.";

        Map<Character, List<String>> wordsByFirstLetter = new TreeMap<>();
        String[] words = russianText.split("\\s+");

        for (String word : words) {
            char firstLetter = word.charAt(0);
            List<String> wordList = wordsByFirstLetter.getOrDefault(firstLetter, new ArrayList<>());
            wordList.add(word);
            wordsByFirstLetter.put(firstLetter, wordList);
        }

        for (char letter : wordsByFirstLetter.keySet()) {
            List<String> wordList = wordsByFirstLetter.get(letter);
            boolean firstWordInLine = true;
            for (String word : wordList) {
                if (firstWordInLine) {
                    System.out.println();
                    firstWordInLine = false;
                }
                System.out.print(word + " ");
            }
        }
    }
}
