import java.util.*;
import java.time.*;

// Main Entry Point and CLI
public class ClinicSystem {
    private Map<String, Patient> patientMap = new HashMap<>();
    private Map<String, Doctor> doctorMap = new HashMap<>();
    private Map<String, Appointment> appointmentMap = new HashMap<>();

    private final String PATIENTS_FILE = "data/patients.txt";
    private final String DOCTORS_FILE = "data/doctors.txt";
    private final String APPOINTMENTS_FILE = "data/appointments.txt";

    private Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        ClinicSystem system = new ClinicSystem();
        system.loadData();
        system.run();
        system.saveData();
        System.out.println("Thank you for using the Clinic Management System.");
    }

    private void run() {
        boolean running = true;
        while (running) {
            printMenu();
            String choice = scanner.nextLine();
            switch (choice) {
                case "1": registerPatient(); break;
                case "2": updatePatient(); break;
                case "3": deletePatient(); break;
                case "4": listPatients(); break;
                case "5": addDoctor(); break;
                case "6": updateDoctor(); break;
                case "7": deleteDoctor(); break;
                case "8": listDoctors(); break;
                case "9": bookAppointment(); break;
                case "10": listAppointments(); break;
                case "11": cancelAppointment(); break;
                case "12": searchDoctor(); break;
                case "13": searchPatient(); break;
                case "0": running = false; break;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }

    private void printMenu() {
        System.out.println("\n-- CLINIC MANAGEMENT MENU --");
        System.out.println("1. Register Patient");
        System.out.println("2. Update Patient");
        System.out.println("3. Delete Patient");
        System.out.println("4. List All Patients");
        System.out.println("5. Add Doctor");
        System.out.println("6. Update Doctor");
        System.out.println("7. Delete Doctor");
        System.out.println("8. List All Doctors");
        System.out.println("9. Book Appointment");
        System.out.println("10. List All Appointments");
        System.out.println("11. Cancel Appointment");
        System.out.println("12. Search Doctor by Specialty");
        System.out.println("13. Search Patient by Name or ID");
        System.out.println("0. Exit");
        System.out.print("Enter your choice: ");
    }

    /* PATIENT MANAGEMENT */

    private void registerPatient() {
        System.out.print("Patient ID: "); String id = scanner.nextLine();
        if (patientMap.containsKey(id)) {
            System.out.println("Patient with this ID already exists.");
            return;
        }
        System.out.print("Name: "); String name = scanner.nextLine();
        System.out.print("Contact Info: "); String contact = scanner.nextLine();
        System.out.print("Medical History: "); String history = scanner.nextLine();
        System.out.print("Illness: "); String illness = scanner.nextLine();
        Patient pat = new Patient(id, name, contact, history, illness);
        patientMap.put(id, pat);
        System.out.println("Patient added!");
    }

    private void updatePatient() {
        System.out.print("Enter Patient ID to update: ");
        String id = scanner.nextLine();
        Patient p = patientMap.get(id);
        if (p == null) { System.out.println("No such patient."); return; }
        System.out.println("Update (leave blank to keep old value):");
        System.out.print("New contact (" + p.getContactInfo() + "): ");
        String contact = scanner.nextLine();
        if (!contact.isBlank()) p.setContactInfo(contact);
        System.out.print("New medical history (" + p.getMedicalHistory() + "): ");
        String history = scanner.nextLine();
        if (!history.isBlank()) p.setMedicalHistory(history);
        System.out.print("New illness (" + p.getIllness() + "): ");
        String illness = scanner.nextLine();
        if (!illness.isBlank()) p.setIllness(illness);
        System.out.println("Patient updated!");
    }

    private void deletePatient() {
        System.out.print("Enter Patient ID to delete: ");
        String id = scanner.nextLine();
        if (!patientMap.containsKey(id)) { System.out.println("No such patient."); return; }
        System.out.print("Are you sure? (yes/no): ");
        String confirm = scanner.nextLine();
        if (confirm.equalsIgnoreCase("yes")) {
            patientMap.remove(id);
            System.out.println("Patient deleted.");
        } else {
            System.out.println("Cancelled.");
        }
    }

    private void listPatients() {
        if (patientMap.isEmpty()) { System.out.println("No patients registered."); return; }
        System.out.println("-- List of Patients --");
        patientMap.values().forEach(System.out::println);
    }


    /* DOCTOR MANAGEMENT */

    private void addDoctor() {
        System.out.print("Doctor ID: "); String id = scanner.nextLine();
        if (doctorMap.containsKey(id)) {
            System.out.println("Doctor with this ID already exists.");
            return;
        }
        System.out.print("Name: "); String name = scanner.nextLine();
        System.out.print("Contact Info: "); String contact = scanner.nextLine();
        System.out.print("Specialty: "); String specialty = scanner.nextLine();
        Doctor doc = new Doctor(id, name, contact, specialty);
        doctorMap.put(id, doc);
        System.out.println("Doctor added!");
    }

    private void updateDoctor() {
        System.out.print("Enter Doctor ID to update: ");
        String id = scanner.nextLine();
        Doctor d = doctorMap.get(id);
        if (d == null) { System.out.println("No such doctor."); return; }
        System.out.println("Update (leave blank to keep old value):");
        System.out.print("New contact (" + d.getContactInfo() + "): ");
        String contact = scanner.nextLine();
        if (!contact.isBlank()) d.setContactInfo(contact);
        System.out.print("New specialty (" + d.getSpecialty() + "): ");
        String specialty = scanner.nextLine();
        if (!specialty.isBlank()) d.setSpecialty(specialty);
        System.out.println("Doctor updated!");
    }

    private void deleteDoctor() {
        System.out.print("Enter Doctor ID to delete: ");
        String id = scanner.nextLine();
        if (!doctorMap.containsKey(id)) { System.out.println("No such doctor."); return; }
        System.out.print("Are you sure? (yes/no): ");
        String confirm = scanner.nextLine();
        if (confirm.equalsIgnoreCase("yes")) {
            doctorMap.remove(id);
            System.out.println("Doctor deleted.");
        } else {
            System.out.println("Cancelled.");
        }
    }

    private void listDoctors() {
        if (doctorMap.isEmpty()) { System.out.println("No doctors registered."); return; }
        System.out.println("-- List of Doctors --");
        doctorMap.values().forEach(System.out::println);
    }


    /* APPOINTMENT MANAGEMENT */

    private String generateAppointmentId() {
        return "A" + (appointmentMap.size() + 1);
    }

    private void bookAppointment() {
        String apptId = generateAppointmentId();
        System.out.print("Date (YYYY-MM-DD): "); String dateStr = scanner.nextLine();
        System.out.print("Time (HH:MM): "); String timeStr = scanner.nextLine();
        System.out.print("Doctor ID: "); String docId = scanner.nextLine();
        System.out.print("Patient ID: "); String patId = scanner.nextLine();
        try {
            LocalDate date = Utils.parseDate(dateStr);
            LocalTime time = Utils.parseTime(timeStr);
            Doctor doctor = doctorMap.get(docId);
            Patient patient = patientMap.get(patId);
            if (doctor == null || patient == null) {
                System.out.println("Doctor or Patient not found.");
                return;
            }
            // Check doctor schedule conflicts
            boolean conflict = appointmentMap.values().stream()
                    .anyMatch(a -> a.getDoctor().getId().equals(docId) &&
                            a.getDate().equals(date) && a.getTime().equals(time));
            if (conflict) {
                System.out.println("Doctor not available at this time.");
                return;
            }
            // Check patient appointment conflicts
            boolean patientConflict = appointmentMap.values().stream()
                    .anyMatch(a -> a.getPatient().getId().equals(patId) &&
                            a.getDate().equals(date) && a.getTime().equals(time));
            if (patientConflict) {
                System.out.println("Patient already has an appointment at this time.");
                return;
            }
            Appointment appt = new Appointment(apptId, date, time, doctor, patient);
            appointmentMap.put(apptId, appt);
            doctor.addAppointment(appt);
            System.out.println("Appointment booked! ID: " + apptId);
        } catch (Exception e) {
            System.out.println("Invalid date/time format.");
        }
    }

    private void listAppointments() {
        if (appointmentMap.isEmpty()) {
            System.out.println("No appointments scheduled.");
            return;
        }
        System.out.println("-- List of Appointments --");
        appointmentMap.values().forEach(System.out::println);
    }

    private void cancelAppointment() {
        System.out.print("Enter Appointment ID to cancel: ");
        String id = scanner.nextLine();
        Appointment a = appointmentMap.get(id);
        if (a == null) { System.out.println("No such appointment."); return; }
        System.out.print("Are you sure? (yes/no): ");
        String confirm = scanner.nextLine();
        if (confirm.equalsIgnoreCase("yes")) {
            appointmentMap.remove(id);
            System.out.println("Appointment cancelled.");
        } else {
            System.out.println("Cancelled.");
        }
    }

    /* SEARCH */

    private void searchDoctor() {
        System.out.print("Enter Specialty: "); String specialty = scanner.nextLine();
        List<Doctor> found = new ArrayList<>();
        for (Doctor d : doctorMap.values()) {
            if (d.getSpecialty().equalsIgnoreCase(specialty)) found.add(d);
        }
        if (found.isEmpty()) System.out.println("No doctors found.");
        else found.forEach(System.out::println);
    }

    private void searchPatient() {
        System.out.print("Enter Patient ID or Name: "); String query = scanner.nextLine();
        List<Patient> found = new ArrayList<>();
        for (Patient p : patientMap.values()) {
            if (p.getId().equalsIgnoreCase(query) || p.getName().equalsIgnoreCase(query))
                found.add(p);
        }
        if (found.isEmpty()) System.out.println("No patients found.");
        else found.forEach(System.out::println);
    }

    /* FILE PERSISTENCE */

    private void loadData() {
        // PATIENTS
        for (String line : FileManager.readFile(PATIENTS_FILE)) {
            try {
                String[] tokens = line.split("\\|");
                if (tokens.length < 5) continue;
                String id = tokens[0], name = tokens[1], contact = tokens[2];
                String history = tokens[3], illness = tokens[4];
                patientMap.put(id, new Patient(id, name, contact, history, illness));
            } catch (Exception ignored) { }
        }
        // DOCTORS
        for (String line : FileManager.readFile(DOCTORS_FILE)) {
            try {
                String[] tokens = line.split("\\|");
                if (tokens.length < 4) continue;
                String id = tokens[0], name = tokens[1], contact = tokens[2];
                String specialty = tokens[3];
                doctorMap.put(id, new Doctor(id, name, contact, specialty));
            } catch (Exception ignored) { }
        }
        // APPOINTMENTS
        for (String line : FileManager.readFile(APPOINTMENTS_FILE)) {
            try {
                String[] tokens = line.split("\\|");
                if (tokens.length < 5) continue;
                String id = tokens[0];
                LocalDate date = LocalDate.parse(tokens[1]);
                LocalTime time = LocalTime.parse(tokens[2]);
                Doctor d = doctorMap.get(tokens[3]);
                Patient p = patientMap.get(tokens[4]);
                if (d != null && p != null) {
                    appointmentMap.put(id, new Appointment(id, date, time, d, p));
                    d.addAppointment(appointmentMap.get(id));
                }
            } catch (Exception ignored) { }
        }
    }

    private void saveData() {
        List<String> pats = new ArrayList<>();
        for (Patient p : patientMap.values())
            pats.add(p.getId() + "|" + p.getName() + "|" + p.getContactInfo() + "|" + p.getMedicalHistory() + "|" + p.getIllness());
        FileManager.writeFile(PATIENTS_FILE, pats);

        List<String> docs = new ArrayList<>();
        for (Doctor d : doctorMap.values())
            docs.add(d.getId() + "|" + d.getName() + "|" + d.getContactInfo() + "|" + d.getSpecialty());
        FileManager.writeFile(DOCTORS_FILE, docs);

        List<String> appts = new ArrayList<>();
        for (Appointment a : appointmentMap.values())
            appts.add(a.getId() + "|" + a.getDate() + "|" + a.getTime() +
                    "|" + a.getDoctor().getId() + "|" + a.getPatient().getId());
        FileManager.writeFile(APPOINTMENTS_FILE, appts);
    }
}
