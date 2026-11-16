package vazifa1.before;

// MUAMMO: Singleton EMAS — har safar yangi obyekt yaratiladi
// Ko'p oqimli muhitda bir nechta nusxa paydo bo'lishi mumkin
public class LoggerBefore {

    private LoggerBefore() {}

    // Thread-safe EMAS: ikki oqim bir vaqtda kelsa — ikki nusxa yaratiladi
    private static LoggerBefore instance;

    public static LoggerBefore getInstance() {
        if (instance == null) {              // (1) Oqim A bu yerda to'xtaydi
            instance = new LoggerBefore();   // (2) Oqim B ham yangi yaratadi!
        }
        return instance;
    }

    public void log(String message) {
        System.out.println("[LOG] " + message);
    }
}
