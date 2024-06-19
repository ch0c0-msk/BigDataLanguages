import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for (int i = 0; i < n; i++) {
            System.out.printf("String %d\n", i+1);
        }
        for (int i = 0; i < n; i++) {
            System.out.printf("String %d ", i+1);
        }
    }
}