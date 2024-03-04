import org.junit.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class AppointmentTest {

    // Test the creation of an Appointment with valid parameters
    @Test
    public void createAppointmentTest() {

        // Current date/time
        Date nDate = new Date();

        // Adds one day to the current date
        Date tDate = new Date(nDate.getTime() + TimeUnit.DAYS.toMillis(1));

        Appointment appointment = new Appointment("0001", tDate, "Tomorrow Appointment");
        assertNotNull(appointment);
        assertEquals("0001", appointment.getAppointmentId());
    }

    // IllegalArgumentException is thrown when appointmentId is null
    @Test
    public void testInvalidAppointmentId() {

        // Current date/time
        Date nDate = new Date();

        // Adds one day to the current date
        Date tDate = new Date(nDate.getTime() + TimeUnit.DAYS.toMillis(1));

        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment(null, tDate, "Tomorrow Task");
        });
    }

    // IllegalArgumentException is thrown when appointmentId is too long
    @Test
    public void testInvalidAppointmentIdTooLong() {

        // Current date/time
        Date nDate = new Date();

        // Adds one day to the current date
        Date tDate = new Date(nDate.getTime() + TimeUnit.DAYS.toMillis(1));

        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("1234567891011", tDate, "Tomorrow Task");
        });
    }

    // IllegalArgumentException is thrown when appointmentDate is null
    @Test
    public void testInvalidAppointmentDate() {

        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("0001", null, "Tomorrow Task");
        });
    }

    // IllegalArgumentException is thrown when appointmentDate is in the past
    @Test
    public void testInvalidAppointmentDatePast() {

        // Current date/time
        Date nDate = new Date();

        // Adds subtracts one to the current date
        Date pDate = new Date(nDate.getTime() - TimeUnit.DAYS.toMillis(1));

        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("0001", pDate, "Yesterday's Task");
        });
    }

    // IllegalArgumentException is thrown when appointmentDescription is null
    @Test
    public void testInvalidAppointmentDescription() {

        // Current date/time
        Date nDate = new Date();

        // Adds one day to the current date
        Date tDate = new Date(nDate.getTime() + TimeUnit.DAYS.toMillis(1));

        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("0001", tDate, null);
        });
    }

    // IllegalArgumentException is thrown when appointmentId is too long
    @Test
    public void testInvalidAppointmentDescriptionTooLong() {

        // Current date/time
        Date nDate = new Date();

        // Adds one day to the current date
        Date tDate = new Date(nDate.getTime() + TimeUnit.DAYS.toMillis(1));

        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("0001", tDate,
                    "This task is set for tomorrow and must at all costs be done tomorrow. It is very very important that it is done tomorrow and not today, and it certantly cannot be taken back in time and done yesterday or put of for some date after tomorrow.");
        });
    }

}
