package vazifa2;

import vazifa2.before.NotificationBefore;
import vazifa2.after.Notification;
import vazifa2.after.NotificationFactory;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== BEFORE: Factory EMAS ===");
        NotificationBefore.send("EMAIL", "gulruh@example.com", "Salom!");
        NotificationBefore.send("SMS",   "+998901234567",      "Kod: 1234");
        NotificationBefore.send("PUSH",  "device-token-123",   "Yangi xabar");

        System.out.println();
        System.out.println("=== AFTER: NotificationFactory ===");

        // Mijoz faqat tur nomini biladi — qanday yaratilishini bilmaydi
        String[] turlar = {"EMAIL", "SMS", "PUSH", "TELEGRAM"};
        String[] qabul   = {"gulruh@example.com", "+998901234567", "device-123", "gulruh_tg"};
        String   xabar   = "Topshiriq qabul qilindi!";

        for (int i = 0; i < turlar.length; i++) {
            Notification n = NotificationFactory.create(turlar[i]);
            n.send(qabul[i], xabar);
        }

        System.out.println();
        System.out.println("Factory pattern afzalligi: yangi tur qo'shish uchun");
        System.out.println("faqat NotificationFactory'da 1 qator + yangi sinf — boshqa hech narsa o'zgarmadi!");
    }
}
