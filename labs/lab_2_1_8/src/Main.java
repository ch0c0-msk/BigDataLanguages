import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();

        String firstPalindrome = null;
        String secondPalindrome = null;

        for (int i = 0; i < n; i++) {
            String word = scanner.nextLine();

            if (isPalindrome(word) && containsOnlyDigits(word)) {
                if (firstPalindrome == null) {
                    firstPalindrome = word;
                } else if (secondPalindrome == null) {
                    secondPalindrome = word;
                }
            }
        }

        if (secondPalindrome != null) {
            System.out.println(secondPalindrome);
            return;
        }
        System.out.println(firstPalindrome);
        System.out.println(getSign());
    }

    private static boolean isPalindrome(String word) {
        String reversed = new StringBuilder(word).reverse().toString();
        return word.equals(reversed);
    }

    private static boolean containsOnlyDigits(String word) {
        return word.matches("\\d+");
    }

    private static String getSign() {
        String lastName = "Kadyrov";
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy hh:mm");
        Date taskStartDateTime = new Date(124, 1, 9, 12, 0);
        String startDateTime = formatter.format(taskStartDateTime);
        long workInterval = 20 * 24 * 60 * 60 * 1000L;
        Date TaskEndDatetime = new Date(taskStartDateTime.getTime() + workInterval);
        String endDateTime = formatter.format(TaskEndDatetime);
        return lastName + "-" + startDateTime + "-" + endDateTime;
    }
}