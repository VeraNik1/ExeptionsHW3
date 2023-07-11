import java.io.*;


public class UserDataWriter {
    /** Метод для записи данных пользователя в файл*/
    public static String writeUserDataToFile(User userData) throws IOException {
        String fileName = userData.lastName() + ".txt";
        try (FileWriter writer = new FileWriter(fileName, true)) {
            writer.write(userData.toString());
            writer.write(System.lineSeparator());
        }
        return "Данные записаны в файл: " + fileName;
    }
}
