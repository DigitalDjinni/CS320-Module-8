import org.junit.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class AppointmentServiceTest {

    // Tests that a new appointment can be successfully added to the
    // AppointmentService
    @Test
    public void testAddAppointment() {

        // Current date/time
        Date nDate = new Date();

        // Adds one day to the current date
        Date tDate = new Date(nDate.getTime() + TimeUnit.DAYS.toMillis(1));

        AppointmentService service = new AppointmentService();
        service.addAppointment(new Appointment("0001", tDate, "Tomorrow Appointment"));
        assertNotNull(service.getAppointment("0001"));
        assertEquals("0001", service.getAppointment("0001").getAppointmentId());
        assertEquals(tDate, service.getAppointment("0001").getAppointmentDate());
        assertEquals("Tomorrow Appointment", service.getAppointment("0001").getDescription());
    }

    // Tests that adding a duplicate appointmentId to the AppointmentService throws
    // an
    // IllegalArgumentException
    @Test
    public void testAddAppointmentDuplicate() {

        // Current date/time
        Date nDate = new Date();

        // Adds one day to the current date
        Date tDate = new Date(nDate.getTime() + TimeUnit.DAYS.toMillis(1));

        AppointmentService service = new AppointmentService();
        Appointment appointment1 = new Appointment("0002", tDate, "Some Appointment");
        service.addAppointment(appointment1);

        Appointment appointment2 = new Appointment("0002", tDate, "Important Appointment");
        assertThrows(IllegalArgumentException.class, () -> service.addAppointment(appointment2));
    }

    // Verification that the appointment is deleted correctly
    @Test
    public void testDeleteAppointment() {

        // Current date/time
        Date nDate = new Date();

        // Adds one day to the current date
        Date tDate = new Date(nDate.getTime() + TimeUnit.DAYS.toMillis(1));

        AppointmentService service = new AppointmentService();
        service.addAppointment(new Appointment("0002", tDate, "Some Appointment"));
        service.deleteAppointment("0002");
        assertNull(service.getAppointment("0002"));
    }
}
