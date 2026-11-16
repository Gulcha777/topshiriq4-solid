package vazifa1;

import vazifa1.before.LoggerBefore;
import vazifa1.after.Logger;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("=== BEFORE: Thread-safe EMAS ===");
        // Ko'p oqimda bir xil yoki har xil nusxa bo'lishi mumkin
        LoggerBefore l1 = LoggerBefore.getInstance();
        LoggerBefore l2 = LoggerBefore.getInstance();
        System.out.println("Bir xil nusxami? " + (l1 == l2));
        l1.log("Birinchi xabar");
        l2.log("Ikkinchi xabar");

        System.out.println();
        System.out.println("=== AFTER: Thread-safe Singleton ===");
        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();
        Logger logger3 = Logger.getInstance();

        System.out.println("Bir xil nusxami (1==2)? " + (logger1 == logger2));
        System.out.println("Bir xil nusxami (1==3)? " + (logger1 == logger3));

        logger1.info("Ilova ishga tushdi");
        logger2.warning("Xotira 80% to'ldi");   // [WARNING] chiqadi
        logger3.error("Ulanish uzildi");

        System.out.println("Jami log soni: " + logger1.getLogCount());

        // Ko'p oqimli test
        System.out.println();
        System.out.println("=== Ko'p oqimli test (10 oqim) ===");
        Thread[] threads = new Thread[10];
        for (int i = 0; i < 10; i++) {
            final int id = i;
            threads[i] = new Thread(() -> {
                Logger lg = Logger.getInstance();
                lg.info("Oqim-" + id + " dan xabar");
            });
        }
        for (Thread t : threads) t.start();
        for (Thread t : threads) t.join();
        System.out.println("Barcha oqimlar tugadi. Bir nusxa saqlandi!");
    }
}
