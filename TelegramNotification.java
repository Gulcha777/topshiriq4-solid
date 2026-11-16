package vazifa2.after;

// Yangi tur — Factory'da faqat 1 qator qo'shildi, boshqa kod o'zgarmadi!
public class TelegramNotification implements Notification {
    @Override
    public void send(String recipient, String message) {
        System.out.println("[TELEGRAM] " + recipient + " ga yuborildi: " + message);
    }
    @Override
    public String getType() { return "TELEGRAM"; }
}
