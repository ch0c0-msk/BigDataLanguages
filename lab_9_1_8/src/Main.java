import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        int res = IntStream.rangeClosed(1, 21).filter(x -> x % 7 == 0).sum();
        System.out.println(res);
    }
}