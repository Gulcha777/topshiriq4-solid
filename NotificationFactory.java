package vazifa2.after;

// Factory — obyekt yaratish logikasi bir joyda
public class NotificationFactory {

    public static Notification create(String type) {
        switch (type.toUpperCase()) {
            case "EMAIL":    return new EmailNotification();
            case "SMS":      return new SmsNotification();
            case "PUSH":     return new PushNotification();
            case "TELEGRAM": return new TelegramNotification(); // yangi tur — faqat shu qator!
            default: throw new IllegalArgumentException("Noma'lum tur: " + type);
        }
    }
}
