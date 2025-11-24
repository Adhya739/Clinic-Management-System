# Clinic Management System

This Core Java application is designed for a small clinic to manage patient records, doctors, and appointment scheduling, automating the manual process and preventing conflicts.

# Features

- Register, update, delete, and list patients and doctors
- Book/cancel appointments with automated schedule conflict checking
- Search patients by ID/name, doctors by specialty
- List all appointments
- All data is persisted to files

# Technologies Used

- Java OOP (Inheritance)
- Data Structures: HashMap, ArrayList
- java.time (date/time handling)
- Simple File I/O (storage)

# Installation & Running

1. Clone/download this repository
2. Open in your Java IDE
3. Compile everything inside `src/`
   ```
   javac src/*.java
   ```
4. Run the main system
   ```
   java -cp src ClinicSystem
   ```

# Testing

Compile and run:
```
javac tests/ClinicSystemTest.java
java -cp tests ClinicSystemTest
```

