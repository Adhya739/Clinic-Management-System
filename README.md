#Clinic Patient Management System
A real-world clinic management system that streamlines the handling of patient records, doctor profiles, appointment scheduling, and data persistence for a small hospital or clinic. This replaces manual paperwork with an efficient, organized software approach, utilizing modern Java programming techniques.​


#Overview
This Java application allows small clinics to manage patient records, doctor details, and appointments all in one place. It automates everyday tasks and provides quick, reliable search and filter capabilities.​

#Features
Register and manage patient information (name, contact, history, illness)

Register and manage doctors (profile, specialty, schedule)

Book, view, and manage appointments (date, time, doctor, patient)

Prevent scheduling conflicts with robust date/time checks

Search and filter:

Appointments by date

Doctors by specialty

Patients by name or ID

Save records for patients, doctors, and appointments to files

User authentication (optional extension for larger clinics)​

#Technologies Used
Java (OOP: Inheritance, Encapsulation)

Data Structures: ArrayList, HashMap

Date/Time Management: java.time

#File Input/Output: Serialization/text files

 GUI: JavaFX/Swing

 Testing: JUnit​

#Installation
Ensure Java JDK (version 8 or higher) is installed

Download or clone this repository

Open the project in your favorite Java IDE (IntelliJ, Eclipse, NetBeans)

Build/compile the project

#Running the Project
Locate the main class, usually named Main.java

Run with your IDE's "Run" feature or from the command line:

bash
javac Main.java
java Main
Use prompts to select options: manage patients, doctors, appointments, or view/search data.​

#Testing Instructions
Unit test core features using JUnit (if included)

Manually:

Add practical test data for patients and doctors

Attempt to schedule overlapping appointments (should fail)

Search/filter by name, specialty, and date

Exit and restart to verify data persisted through File I/O


Main menu

Patient registration

Appointment scheduling view

Doctor profile and specialty search

#Contributing
Pull requests are welcome! For major changes, open an issue first to discuss what you would like to change.


