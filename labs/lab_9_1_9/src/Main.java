import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("apple", "banana", "orange", "apple", "grape", "banana");

        String searchString = "apple";

        long count = strings.stream()
                .filter(str -> str.equals(searchString))
                .count();
        System.out.println(count);
    }
}