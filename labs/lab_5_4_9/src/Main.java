import java.io.*;

public class Main {
    public static void main(String[] args) {
        String outputDirectoryPath = "output";
        File outputDirectory = new File(outputDirectoryPath);
        if (!outputDirectory.exists()) {
            if (outputDirectory.mkdir()) {
                System.out.println("Директория для результатов создана: " + outputDirectory.getAbsolutePath());
            } else {
                System.err.println("Ошибка: Не удалось создать директорию для результатов");
                return;
            }
        }

        File targetFile = new File(outputDirectory, "/output.txt");
        try {
            if (targetFile.createNewFile()) {
                System.out.println("Файл успешно создан: " + targetFile.getAbsolutePath());
            } else {
                System.err.println("Файл уже существует: " + targetFile.getAbsolutePath());
            }
        } catch (IOException e) {
            System.err.println("Ошибка при создании файла: " + e.getMessage());
            return;
        }

        String sourceFilePath = "static/example.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(sourceFilePath));
             BufferedWriter writer = new BufferedWriter(new FileWriter(targetFile))) {

            String line;
            while ((line = reader.readLine()) != null) {
                String[] words = line.split("\\s+");
                if (words.length >= 2) {
                    String firstWord = words[0];
                    words[0] = words[words.length - 1];
                    words[words.length - 1] = firstWord;
                }
                writer.write(String.join(" ", words));
                writer.newLine();
            }

        } catch (IOException e) {
            System.err.println("Ошибка: " + e.getMessage());
        }
    }
}
