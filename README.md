# Topshiriq 4 — Design Patterns (M4 + A4)

**Talaba:** Xamroyeva Gulruh  
**Guruh:** 1-1DIM-24  
**Fan:** Dasturlash texnologiyalari  
**Institut:** Aniq fanlar va intellektual muhandislik texnologiyalari ilmiy-tadqiqot instituti  
**Universitet:** Buxoro Davlat Universiteti — 2026

---

## Mavzu

GoF (Gang of Four) Design Patterns — **yaratuvchi** va **strukturaviy** namunalar.

---

## Loyiha tuzilmasi

```
src/
├── vazifa1/                      # Singleton Pattern
│   ├── before/
│   │   └── LoggerBefore.java     # Thread-safe EMAS Singleton (muammo)
│   ├── after/
│   │   └── Logger.java           # Double-Checked Locking Singleton (yechim)
│   └── Main.java                 # Before/After demo + 10-oqimli test
│
├── vazifa2/                      # Factory Method Pattern
│   ├── before/
│   │   └── NotificationBefore.java  # if/else zanjiri (muammo)
│   ├── after/
│   │   ├── Notification.java        # Interfeys
│   │   ├── EmailNotification.java   # Implementatsiya
│   │   ├── SmsNotification.java     # Implementatsiya
│   │   ├── PushNotification.java    # Implementatsiya
│   │   ├── TelegramNotification.java# Yangi tur (OCP demo)
│   │   └── NotificationFactory.java # Factory sinfi
│   └── Main.java                    # Before/After demo
│
└── vazifa3/                      # Builder + Decorator Pattern
    ├── before/
    │   └── UserBefore.java       # Telescoping Constructor (muammo)
    ├── after/
    │   ├── User.java             # Builder pattern (yechim)
    │   ├── NotificationService.java       # Asosiy xizmat
    │   └── LoggingNotificationDecorator.java  # Decorator (logging)
    └── Main.java                 # Before/After + Validatsiya + Decorator demo
```

---

## Kompilyatsiya va ishga tushirish

```bash
# Kompilyatsiya
javac -encoding UTF-8 -d out \
  src/vazifa1/before/LoggerBefore.java \
  src/vazifa1/after/Logger.java \
  src/vazifa1/Main.java \
  src/vazifa2/before/NotificationBefore.java \
  src/vazifa2/after/Notification.java \
  src/vazifa2/after/EmailNotification.java \
  src/vazifa2/after/SmsNotification.java \
  src/vazifa2/after/PushNotification.java \
  src/vazifa2/after/TelegramNotification.java \
  src/vazifa2/after/NotificationFactory.java \
  src/vazifa2/Main.java \
  src/vazifa3/before/UserBefore.java \
  src/vazifa3/after/User.java \
  src/vazifa3/after/NotificationService.java \
  src/vazifa3/after/LoggingNotificationDecorator.java \
  src/vazifa3/Main.java

# Ishga tushirish
java -cp out vazifa1.Main
java -cp out vazifa2.Main
java -cp out vazifa3.Main
```

---

## O'rganilgan namunalar

| # | Namuna | Turi | Muammo | Yechim |
|---|--------|------|--------|--------|
| 1 | **Singleton** | Yaratuvchi | Ko'p oqimda bir nechta nusxa | Double-Checked Locking + `volatile` |
| 2 | **Factory Method** | Yaratuvchi | `if/else` zanjiri (OCP buzilgan) | Interface + Factory sinfi |
| 3 | **Builder** | Yaratuvchi | Telescoping Constructor | Inner Builder sinfi + method chaining |
| 4 | **Decorator** | Strukturaviy | Meros orqali kengaytirish | Wrapping pattern |

---

## SOLID tamoyillari

- **SRP** — har bir sinf bitta vazifani bajaradi
- **OCP** — mavjud kodni o'zgartirmasdan kengaytirish (Telegram qo'shish)
- **LSP** — `Notification` implementatsiyalari bir-birini almashtiradi
- **ISP** — kichik, maqsadga yo'naltirilgan interfeyslar
- **DIP** — abstraksiyaga bog'liqlik (`Notification` interfeysi)
