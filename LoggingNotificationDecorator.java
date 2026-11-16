package vazifa3.after;

import vazifa1.after.Logger;

// Decorator — NotificationService ga logging qo'shadi, asosiy kodni o'zgartirmay
public class LoggingNotificationDecorator {

    private final NotificationService wrapped;
    private final Logger logger = Logger.getInstance();

    public LoggingNotificationDecorator(NotificationService service) {
        this.wrapped = service;
    }

    public void sendWelcome(User user) {
        logger.info("sendWelcome boshlandi: " + user.getEmail());
        wrapped.sendWelcome(user);
        logger.info("sendWelcome tugadi: " + user.getFirstName());
    }
}
