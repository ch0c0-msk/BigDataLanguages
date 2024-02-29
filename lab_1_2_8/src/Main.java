import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        for (int i = 0; i < n; i++) {
            boolean isSimple = true;
            for (int j = 2; j < arr[i]; j++) {
                if (arr[i] % j == 0) {
                    isSimple = false;
                    break;
                }
            }
            if (isSimple) {
                System.out.println(arr[i]);
            }
        }
    }
}