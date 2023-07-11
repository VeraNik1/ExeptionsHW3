/**
 *  класс для собственных исключений при ошибках формата ввода данных
 */
public class InvalidUserDataException extends Exception {
    public InvalidUserDataException(String message) {
        super(message);
    }
    public InvalidUserDataException(String message, Throwable cause) {super(message, cause);
    }
}