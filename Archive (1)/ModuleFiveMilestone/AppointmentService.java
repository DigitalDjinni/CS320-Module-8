import java.util.HashMap;
import java.util.Map;

public class AppointmentService {

    private Map<String, Appointment> appointments;

    public AppointmentService() {
        this.appointments = new HashMap<>();
    }

    // Add an appointment
    public void addAppointment(Appointment appointment) {
        if (appointments.containsKey(appointment.getAppointmentId())) {
            throw new IllegalArgumentException("appointmentId already exists");
        }
        appointments.put(appointment.getAppointmentId(), appointment);
    }

    // Delete an appointment
    public void deleteAppointment(String appointmentId) {
        if (!appointments.containsKey(appointmentId)) {
            throw new IllegalArgumentException("appointmentId does not exist");
        }
        appointments.remove(appointmentId);
    }

    // Retrieves an appointment by its appointmentId
    public Appointment getAppointment(String appointmentId) {
        return appointments.get(appointmentId);
    }
}
