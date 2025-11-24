import java.util.ArrayList;
import java.util.List;

public class Doctor extends Person {
    private String specialty;
    private List<Appointment> schedule;

    public Doctor(String id, String name, String contactInfo, String specialty) {
        super(id, name, contactInfo);
        this.specialty = specialty;
        this.schedule = new ArrayList<>();
    }

    public String getSpecialty() { return specialty; }
    public void setSpecialty(String specialty) { this.specialty = specialty; }
    public List<Appointment> getSchedule() { return schedule; }
    public void addAppointment(Appointment appointment) {
        schedule.add(appointment);
    }

    @Override
    public String toString() {
        return "Doctor[" + id + ", " + name + ", Specialty: " + specialty + "]";
    }
}
