public class Main {
    public static void main(String[] args) {
        String text = "Из небольшого    текста удалить все    символы, кроме пробелов, не являющиеся буквами. Между последовательностями подряд идущих букв оставить хотя бы один пробел.";
        System.out.println(text);
        String result = processText(text);
        System.out.println(result);
    }

    public static String processText(String text) {
        StringBuilder result = new StringBuilder();
        boolean lastWasLetter = false;

        for (char c : text.toCharArray()) {
            if (Character.isLetter(c)) {
                result.append(c);
                lastWasLetter = true;
            } else if (c == ' ') {
                if (lastWasLetter) {
                    result.append(' ');
                    lastWasLetter = false;
                }
            }
        }

        return result.toString();
    }
}
