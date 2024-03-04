import java.util.Date;

public class Appointment {

    private final String appointmentId;
    private Date appointmentDate;
    private String description;

    // Constructor
    public Appointment(String appointmentId, Date appointmentDate, String description) {
        if (appointmentId == null || appointmentId.length() > 10) {
            throw new IllegalArgumentException("Invalid appointmentId");
        }
        this.appointmentId = appointmentId;
        setAppointmentDate(appointmentDate);
        setDescription(description);
    }

    // Getters and Setters
    public String getAppointmentId() {
        return appointmentId;
    }

    public Date getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(Date appointmentDate) {
        if (appointmentDate == null || appointmentDate.before(new Date())) {
            throw new IllegalArgumentException("Invalid appointmentDate");
        }
        this.appointmentDate = new Date(appointmentDate.getTime());
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        if (description == null || description.length() > 50) {
            throw new IllegalArgumentException("Invalid description");
        }
        this.description = description;
    }
}