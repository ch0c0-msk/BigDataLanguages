import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("apple", "banana", "orange", "apple", "grape", "banana");
        List<String> distinctStrings = strings.stream()
                .distinct()
                .collect(Collectors.toList());
        System.out.println(distinctStrings);
    }
}