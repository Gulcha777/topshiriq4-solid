package vazifa2.after;

public class EmailNotification implements Notification {
    @Override
    public void send(String recipient, String message) {
        System.out.println("[EMAIL] " + recipient + " ga yuborildi: " + message);
    }
    @Override
    public String getType() { return "EMAIL"; }
}
