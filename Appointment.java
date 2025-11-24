import java.time.LocalDate;
import java.time.LocalTime;

public class Appointment {
    private String id;
    private LocalDate date;
    private LocalTime time;
    private Doctor doctor;
    private Patient patient;

    public Appointment(String id, LocalDate date, LocalTime time, Doctor doctor, Patient patient) {
        this.id = id;
        this.date = date;
        this.time = time;
        this.doctor = doctor;
        this.patient = patient;
    }

    public String getId() { return id; }
    public LocalDate getDate() { return date; }
    public LocalTime getTime() { return time; }
    public Doctor getDoctor() { return doctor; }
    public Patient getPatient() { return patient; }

    @Override
    public String toString() {
        return "Appointment[" + id + ", " + date + " " + time +
                ", Doctor: " + doctor.getName() + ", Patient: " + patient.getName() + "]";
    }
}
