import java.io.*;

/* Многострочный комментарий */
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

        String sourceFilePath = "src/Main.java";
        String targetFilePath = outputDirectoryPath + "/MainWithoutComments.java";
        try {
            if (!new File(targetFilePath).createNewFile()) {
                return;
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        try (BufferedReader reader = new BufferedReader(new FileReader(sourceFilePath));
             BufferedWriter writer = new BufferedWriter(new FileWriter(targetFilePath))) {

            String line;
            while ((line = reader.readLine()) != null) {
                line = removeComments(line);
                writer.write(line);
                writer.newLine();
            }

            System.out.println("Файл без комментариев успешно создан: " + targetFilePath);

        } catch (IOException e) {
            System.err.println("Ошибка: " + e.getMessage());
        }
    }

    // Метод для удаления комментариев из строки
    private static String removeComments(String line) {
        line = line.replaceAll("//.*", "");
        line = line.replaceAll("/\\*.*?\\*/", "");
        return line;
    }
}