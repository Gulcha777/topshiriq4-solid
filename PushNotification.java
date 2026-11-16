package vazifa2.after;

public class PushNotification implements Notification {
    @Override
    public void send(String recipient, String message) {
        System.out.println("[PUSH] " + recipient + " ga yuborildi: " + message);
    }
    @Override
    public String getType() { return "PUSH"; }
}
