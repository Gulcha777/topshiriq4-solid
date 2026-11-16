package vazifa2.before;

// MUAMMO: Factory EMAS — mijoz o'zi tur tanlaydi, kod takrorlanadi
// Yangi tur qo'shish uchun hamma joyda if/else o'zgartiriladi
public class NotificationBefore {

    // Har safar yangi tur uchun bu metodni o'zgartirish kerak — OCP buzilgan!
    public static void send(String type, String recipient, String message) {
        if (type.equals("EMAIL")) {
            System.out.println("Email yuborildi -> " + recipient + ": " + message);
        } else if (type.equals("SMS")) {
            System.out.println("SMS yuborildi -> " + recipient + ": " + message);
        } else if (type.equals("PUSH")) {
            System.out.println("Push yuborildi -> " + recipient + ": " + message);
        } else {
            throw new IllegalArgumentException("Noma'lum tur: " + type);
        }
    }
}
