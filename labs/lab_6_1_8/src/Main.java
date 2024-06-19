import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean isCorrect = true;
        HashMap<String, Integer> bracketMap = new HashMap<>(3);
        bracketMap.put("(", 0);
        bracketMap.put("[", 0);
        bracketMap.put("{", 0);

        Scanner in = new Scanner(System.in);
        String source = in.nextLine();
        for (char ch : source.toCharArray()) {
            switch (ch) {
                case '(':
                    bracketMap.put("(", bracketMap.get("(") + 1);
                    break;
                case ')':
                    bracketMap.put("(", bracketMap.get("(") - 1);
                    if (bracketMap.get("(") < 0) {
                        isCorrect = false;
                    }
                    break;
                case '[':
                    bracketMap.put("[", bracketMap.get("[") + 1);
                    break;
                case ']':
                    bracketMap.put("[", bracketMap.get("[") - 1);
                    if (bracketMap.get("[") < 0) {
                        isCorrect = false;
                    }
                    break;
                case '{':
                    bracketMap.put("{", bracketMap.get("{") + 1);
                    break;
                case '}':
                    bracketMap.put("{", bracketMap.get("{") - 1);
                    if (bracketMap.get("{") < 0) {
                        isCorrect = false;
                    }
                    break;
            }
        }
        if (isCorrect) {
            System.out.println("String is correct");
            return;
        }
        System.out.println("String is not correct");
    }
}