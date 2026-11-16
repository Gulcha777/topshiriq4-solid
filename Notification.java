package vazifa2.after;

// Umumiy interfeys
public interface Notification {
    void send(String recipient, String message);
    String getType();
}
