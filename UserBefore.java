package vazifa3.before;

// MUAMMO: Ko'p parametrli konstruktor — "Telescoping Constructor" anti-pattern
// Qaysi parametr nima ekanini bilish qiyin, ixtiyoriy maydonlar muammoli
public class UserBefore {
    private String firstName;
    private String lastName;
    private String email;
    private String phone;      // ixtiyoriy
    private int age;           // ixtiyoriy
    private String address;    // ixtiyoriy

    // 7 ta parametr — qaysi biri nima? Chalkash!
    public UserBefore(String firstName, String lastName, String email,
                      String phone, int age, String address) {
        if (firstName == null || firstName.isEmpty())
            throw new IllegalArgumentException("Ism bo'sh bo'lmasligi kerak");
        if (!email.contains("@"))
            throw new IllegalArgumentException("Email noto'g'ri");
        this.firstName = firstName;
        this.lastName  = lastName;
        this.email     = email;
        this.phone     = phone;
        this.age       = age;
        this.address   = address;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName + " <" + email + "> tel:" + phone +
               " yosh:" + age + " manzil:" + address;
    }
}
