package vazifa3.after;

// Builder pattern — ko'p parametrli, ixtiyoriy maydonli obyekt uchun
public class User {
    // Majburiy maydonlar
    private final String firstName;
    private final String lastName;
    private final String email;
    // Ixtiyoriy maydonlar
    private final String phone;
    private final int    age;
    private final String address;

    // Private konstruktor — faqat Builder orqali yaratiladi
    private User(Builder builder) {
        this.firstName = builder.firstName;
        this.lastName  = builder.lastName;
        this.email     = builder.email;
        this.phone     = builder.phone;
        this.age       = builder.age;
        this.address   = builder.address;
    }

    // Getterlar
    public String getFirstName() { return firstName; }
    public String getLastName()  { return lastName; }
    public String getEmail()     { return email; }
    public String getPhone()     { return phone; }
    public int    getAge()       { return age; }
    public String getAddress()   { return address; }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("User{").append(firstName).append(" ").append(lastName);
        sb.append(", email=").append(email);
        if (phone   != null) sb.append(", tel=").append(phone);
        if (age     > 0)     sb.append(", yosh=").append(age);
        if (address != null) sb.append(", manzil=").append(address);
        sb.append("}");
        return sb.toString();
    }

    // ===== BUILDER =====
    public static class Builder {
        // Majburiy
        private final String firstName;
        private final String lastName;
        private final String email;
        // Ixtiyoriy — default qiymatlari
        private String phone   = null;
        private int    age     = 0;
        private String address = null;

        public Builder(String firstName, String lastName, String email) {
            if (firstName == null || firstName.isEmpty())
                throw new IllegalArgumentException("Ism bo'sh bo'lmasligi kerak");
            if (email == null || !email.contains("@"))
                throw new IllegalArgumentException("Email noto'g'ri: " + email);
            this.firstName = firstName;
            this.lastName  = lastName;
            this.email     = email;
        }

        public Builder phone(String phone) {
            this.phone = phone;
            return this;   // method chaining uchun
        }

        public Builder age(int age) {
            if (age < 0 || age > 150)
                throw new IllegalArgumentException("Yosh noto'g'ri: " + age);
            this.age = age;
            return this;
        }

        public Builder address(String address) {
            this.address = address;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }
}
