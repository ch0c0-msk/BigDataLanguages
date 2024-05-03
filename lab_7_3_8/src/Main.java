public class Main {
    public static void main(String[] args) {
        String originalText = "Hello, world!";
        System.out.println("Исходный текст: " + originalText);

        String encryptedText = encryptText(originalText);
        System.out.println("Зашифрованный текст: " + encryptedText);

        String decryptedText = decryptText(encryptedText);
        System.out.println("Расшифрованный текст: " + decryptedText);
    }

    public static String encryptText(String plaintext) {
        StringBuilder group1 = new StringBuilder();
        StringBuilder group2 = new StringBuilder();
        StringBuilder group3 = new StringBuilder();

        for (int i = 0; i < plaintext.length(); i++) {
            char ch = plaintext.charAt(i);
            if (i % 3 == 0) {
                group1.append(ch);
            } else if (i % 3 == 1) {
                group2.append(ch);
            } else {
                group3.append(ch);
            }
        }

        StringBuilder encryptedText = new StringBuilder();
        encryptedText.append(group1.toString());
        encryptedText.append(group2.toString());
        encryptedText.append(group3.toString());

        return encryptedText.toString();
    }

    public static String decryptText(String encryptedText) {
        int len = encryptedText.length();
        int group1len = len / 3 + (len % 3 >= 1 ? 1 : 0);
        int group2len = len / 3 + (len % 3 > 1 ? 1 : 0);
        int group3len = len / 3;

        char[] group1 = new char[group1len];
        char[] group2 = new char[group2len];
        char[] group3 = new char[group3len];

        for (int i = 0; i < len; i++) {
            if (i < group1len) {
                group1[i] = encryptedText.charAt(i);
            } else if (i < group1len + group2len) {
                group2[i - group1len] = encryptedText.charAt(i);
            } else {
                group3[i - group1len - group2len] = encryptedText.charAt(i);
            }
        }

        StringBuilder res = new StringBuilder();
        for (int i = 0; i < len / 3; i++) {
            res.append(group1[i]);
            res.append(group2[i]);
            res.append(group3[i]);
        }

        if (len % 3 == 2) {
            res.append(group1[group1len - 1]);
            res.append(group2[group2len - 1]);
        } else if (len % 3 == 1) {
            res.append(group1[group1len - 1]);
        }

        return res.toString();
    }
}
