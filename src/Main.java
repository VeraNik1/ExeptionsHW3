import java.io.IOException;
public class Main {
    public static void main(String[] args) {
        while (true) {
            try {
                /** Считываем ввод пользователя из консоли*/
                User userData = UserInput.getUserDataFromConsole();

                /** Формирование данных пользователя и запись в файл с выводом результата*/
                String resp = UserDataWriter.writeUserDataToFile(userData);
                System.out.println(resp);


            } catch (InvalidUserDataException e) {
                /** Возникли ошибки в формате ввода данных (программа не завершается,
                 * предлагется ввести данные повторно)*/
                System.err.println("Ошибка: " + e.getMessage());

            } catch (StopApp e) {
                /** Нормальное прерывание работы приложения
                код возврата 0*/
                System.out.println("Программа завершена. Удачи!");
                System.exit(0);

            } catch (IOException e) {
                /** Прерывание работы приложения из-за ошибок ввода/вывода
                вывод stackTrace и выход
                код возврата 1*/
                System.err.println("Ошибка ввода/вывода");
                e.printStackTrace();
                System.exit(1);
            }
        }
    }
}