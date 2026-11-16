package vazifa3.after;

// Asosiy xizmat — Decorator qo'shiladi
public class NotificationService {

    public void sendWelcome(User user) {
        System.out.println("Xush kelibsiz, " + user.getFirstName() + "! Email: " + user.getEmail());
    }
}
