import java.util.Scanner;

public class Main {
    static void sort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        sort(arr);
        System.out.println("sorted array asc: ");
        for (int i = 0; i < n; i++) {
            System.out.printf("%d ", arr[i]);
        }
        System.out.println();
        System.out.println("sorted array desc: ");
        for (int i = 0; i < n; i++) {
            System.out.printf("%d ", arr[arr.length - 1 - i]);
        }
    }
}