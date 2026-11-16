package vazifa2.after;

public class SmsNotification implements Notification {
    @Override
    public void send(String recipient, String message) {
        System.out.println("[SMS] " + recipient + " ga yuborildi: " + message);
    }
    @Override
    public String getType() { return "SMS"; }
}
