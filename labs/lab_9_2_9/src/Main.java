import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {

        OptionalInt max = IntStream.rangeClosed(1, 100).reduce(Integer::max);
        OptionalInt min = IntStream.rangeClosed(1, 100).reduce(Integer::min);
        min.ifPresent(System.out::println);
        max.ifPresent(System.out::println);
    }
}