public class Patient extends Person {
    private String medicalHistory;
    private String illness;

    public Patient(String id, String name, String contactInfo, String medicalHistory, String illness) {
        super(id, name, contactInfo);
        this.medicalHistory = medicalHistory;
        this.illness = illness;
    }

    public String getMedicalHistory() { return medicalHistory; }
    public void setMedicalHistory(String medicalHistory) { this.medicalHistory = medicalHistory; }
    public String getIllness() { return illness; }
    public void setIllness(String illness) { this.illness = illness; }

    @Override
    public String toString() {
        return "Patient[" + id + ", " + name + ", Illness: " + illness + "]";
    }
}
