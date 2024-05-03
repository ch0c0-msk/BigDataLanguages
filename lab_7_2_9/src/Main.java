import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String poem = "слово корабль олово";

        Set<Character> commonLetters = findCommonLetters(poem);

        if (commonLetters.isEmpty()) {
            System.out.println("Во всех словах стихотворения нет общих букв.");
        } else {
            for (char letter : commonLetters) {
                System.out.print(letter + " ");
            }
        }
    }

    public static Set<Character> findCommonLetters(String poem) {
        String[] words = poem.split("\\s+");
        Set<Character> commonLetters = new HashSet<>();

        // Инициализируем множество букв первым словом
        for (char letter : words[0].toCharArray()) {
            commonLetters.add(letter);
        }

        // Пересекаем множество букв каждого последующего слова с общими буквами
        for (int i = 1; i < words.length; i++) {
            Set<Character> currentWordLetters = new HashSet<>();
            for (char letter : words[i].toCharArray()) {
                currentWordLetters.add(letter);
            }
            commonLetters.retainAll(currentWordLetters);
        }

        return commonLetters;
    }
}
