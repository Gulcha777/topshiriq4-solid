package vazifa1.after;

// Thread-safe Singleton — Double-Checked Locking usuli
public class Logger {

    // volatile: barcha oqimlar so'nggi qiymatni ko'radi
    private static volatile Logger instance;

    private int logCount = 0;

    private Logger() {
        System.out.println("Logger yaratildi (faqat bir marta!)");
    }

    public static Logger getInstance() {
        if (instance == null) {                    // 1-tekshiruv (lock olmay)
            synchronized (Logger.class) {
                if (instance == null) {            // 2-tekshiruv (lock bilan)
                    instance = new Logger();
                }
            }
        }
        return instance;
    }

    public synchronized void log(String level, String message) {
        logCount++;
        System.out.printf("[%s] #%d: %s%n", level, logCount, message);
    }

    public void info(String message)    { log("INFO",    message); }
    public void warning(String message) { log("WARNING", message); }
    public void error(String message)   { log("ERROR",   message); }

    public int getLogCount() { return logCount; }
}
