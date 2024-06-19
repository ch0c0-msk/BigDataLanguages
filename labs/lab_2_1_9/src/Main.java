import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int k = in.nextInt();

        switch (getInterval(k)) {
            case 1:
                System.out.println("(-10k;0]");
                break;
            case 2:
                System.out.println("(0;5]");
                break;
            case 3:
                System.out.println("(5;10]");
                break;
            case 4:
                System.out.println("(10;10k]");
                break;
            default:
                System.out.println("Other interval");
                break;
        }
        System.out.println(getSign());
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

    private static int getInterval(int k) {
        if (k > -10 * k && k <= 0) {
            return 1;
        } else if (k > 0 && k <= 5) {
            return 2;
        } else if (k > 5 && k <= 10) {
            return 3;
        } else if (k > 10 && k <= 10 * k) {
            return 4;
        } else {
            return 0;
        }
    }
}