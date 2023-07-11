
import java.util.Scanner;

/**
 * Чтение данных из консоли
 */
public class ConsoleInput {
    static Scanner scan = new Scanner(System.in);

    public static String Input(String invite) {
        System.out.print(invite);
        return scan.nextLine();
    }

    public static String Input() {
        return Input("");
    }
}
