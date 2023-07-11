
/**
 * @param lastName    Фамилия пользователя
 * @param firstName   Имя пользователя
 * @param middleName  Отчество пользователя
 * @param birthDate   Дата рождения пользователя
 * @param phoneNumber Номер телефона пользователя
 * @param gender      Пол пользователя
 */
public record User(String lastName, String firstName, String middleName, String birthDate, String phoneNumber,
                   char gender) {


    /** Метод для вывода данных*/
    @Override
    public String toString() {
        return String.format("%s %s %s %s %s %c", lastName, firstName, middleName,
                birthDate, phoneNumber, gender);
    }
}