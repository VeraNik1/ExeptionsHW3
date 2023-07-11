
/**
 * класс для отслеживания команды выхода из приложения
 */
public class StopApp extends RuntimeException{
    public StopApp() {
        super("");
    }
}
