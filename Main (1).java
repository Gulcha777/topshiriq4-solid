package vazifa3;

import vazifa3.before.UserBefore;
import vazifa3.after.User;
import vazifa3.after.NotificationService;
import vazifa3.after.LoggingNotificationDecorator;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== BEFORE: Telescoping Constructor ===");
        // Qaysi parametr nima ekanini bilish qiyin!
        UserBefore u1 = new UserBefore("Gulruh", "Xamroyeva",
                "gulruh@example.com", "+998901234567", 20, "Buxoro");
        System.out.println(u1);

        System.out.println();
        System.out.println("=== AFTER: Builder Pattern ===");

        // Faqat majburiy maydonlar
        User user1 = new User.Builder("Gulruh", "Xamroyeva", "gulruh@example.com")
                .build();
        System.out.println("Minimal: " + user1);

        // Barcha maydonlar — method chaining bilan
        User user2 = new User.Builder("Alisher", "Navoiy", "alisher@example.com")
                .phone("+998901234567")
                .age(25)
                .address("Hirot, O'zbekiston")
                .build();
        System.out.println("To'liq:  " + user2);

        // Validatsiya
        System.out.println();
        System.out.println("=== Validatsiya tekshiruvi ===");
        try {
            User invalid = new User.Builder("", "Xamroyeva", "gulruh@example.com").build();
        } catch (IllegalArgumentException e) {
            System.out.println("Xato ushlandi: " + e.getMessage());
        }
        try {
            User invalid2 = new User.Builder("Gulruh", "X", "noto'g'ri-email").build();
        } catch (IllegalArgumentException e) {
            System.out.println("Xato ushlandi: " + e.getMessage());
        }

        System.out.println();
        System.out.println("=== Decorator: Logging qo'shildi ===");
        NotificationService service = new NotificationService();
        LoggingNotificationDecorator decorated = new LoggingNotificationDecorator(service);
        decorated.sendWelcome(user1);
    }
}
