import java.util.regex.Pattern;

public class UserInput {
    /** Константы для проверки количества введенных данных*/
    private static final int REQUIRED_FIELD_COUNT = 6;

    /** Метод для получения данных пользователя из консоли*/
    public static User getUserDataFromConsole() throws InvalidUserDataException, StopApp {
        String input = ConsoleInput.Input("\nВведите данные пользователя через пробел или EXIT для выхода\n\n"
                + "Фамилия Имя Отчество - кириллицей\n"
                + "дд.мм.гггг - дата рождения, например 23.02.1995\n"
                + "НомерТелефона - 7 цифр, например: 96053112\n"
                + "Пол - в формате 1 буква из следующих: мужской пол - М, женский - F\n\n"
                +"(Фамилия Имя Отчество дд.мм.гггг НомерТелефона Пол)\n:");

       /** Выход из приложения*/
        if ("exit".equalsIgnoreCase(input)) {
            throw new StopApp();
        }
        /** Разделение введенной строки на отдельные поля*/
        String[] fields = input.split(" ");

        /** Проверка количества введенных данных*/
        if (fields.length < REQUIRED_FIELD_COUNT) {
            throw new InvalidUserDataException("Вы ввели недостаточное количество данных");
        }
        if (fields.length > REQUIRED_FIELD_COUNT) {
            throw new InvalidUserDataException("Вы ввели избыточное количество данных");
        }
        /** Извлечение данных из полей*/
        String lastName = fields[0];
        String firstName = fields[1];
        String middleName = fields[2];

        if (isNotValidName(lastName)||isNotValidName(firstName)||isNotValidName(middleName)) {
            throw new InvalidUserDataException("В ФИО использованы некорректные символы!\n" +
                    "ФИО необходимо ввести кириллицей");
        }
        String birthDate;
        String phoneNumber;
        char gender;

        birthDate = fields[3];
        if (isNotValidDate(birthDate)) {
            throw new InvalidUserDataException("ДАТА введена некорректно!\nнеобходимый формат ДД.ММ.ГГГГ");
        }
        phoneNumber = fields[4];
        if (isNotValidPhone(phoneNumber)) {
            throw new InvalidUserDataException("НОМЕР ТЕЛЕФОНА введен некорректно!\nнеобходимо ввести 7 цифр");
        }
        gender = Character.toUpperCase(fields[5].charAt(0));
        if (gender != 'М' && gender != 'M' && gender != 'F') {
            throw new InvalidUserDataException("ПОЛ введен некорректно\nнеобходимо ввести ОДНУ букву" +
                    "\n для мужского пола - М\n для женского F");
        }

        return new User(lastName, firstName, middleName, birthDate, phoneNumber, gender);
    }

   /** проверка формата для даты рождения*/
    public static boolean isNotValidDate(String dateString) {
        Pattern datePattern = Pattern.compile("(0?[1-9]|[12][0-9]|3[01])[.](0?[1-9]|1[012])[.]((19|20)\\d\\d)");
        return !datePattern.matcher(dateString).matches();
    }
    /** проверка формата для телефона*/
    public static boolean isNotValidPhone(String phoneNumber) {
        Pattern phonePattern = Pattern.compile("^\\d{10}$");
        return !phonePattern.matcher(phoneNumber).matches();
    }
    /** проверка корректности ФИО*/

    public static boolean isNotValidName(String name) {
        Pattern namePattern = Pattern.compile("^[а-яёА-ЯЁ]*$");
        return !namePattern.matcher(name).matches();
    }


}