import org.junit.jupiter.api.Test;
import java.util.Calendar;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class AppointmentTest {

    @Test
    public void testValidAppointment() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_MONTH, 1); // future date
        Date futureDate = cal.getTime();
        Appointment appt = new Appointment("A1", futureDate, "Doctor appointment");
        assertEquals("A1", appt.getAppointmentID());
        assertEquals("Doctor appointment", appt.getDescription());
    }

    @Test
    public void testSetAppointmentDate() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_MONTH, 2);
        Date futureDate = cal.getTime();
        Appointment appt = new Appointment("A2", futureDate, "Test appointment");

        cal.add(Calendar.DAY_OF_MONTH, 1);
        Date newDate = cal.getTime();
        appt.setAppointmentDate(newDate);
        assertEquals(newDate, appt.getAppointmentDate());
    }

    @Test
    public void testSetDescription() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_MONTH, 1);
        Date date = cal.getTime();
        Appointment appt = new Appointment("A3", date, "Original");
        appt.setDescription("Updated description");
        assertEquals("Updated description", appt.getDescription());
    }

    @Test
    public void testInvalidAppointmentID() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_MONTH, 1);
        Date date = cal.getTime();

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Appointment(null, date, "Test");
        });
        assertEquals("Invalid appointment ID", exception.getMessage());

        exception = assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("TooLongAppointmentID", date, "Test");
        });
        assertEquals("Invalid appointment ID", exception.getMessage());
    }

    @Test
    public void testInvalidDate() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_MONTH, -1);
        Date pastDate = cal.getTime();

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("A4", pastDate, "Past date");
        });
        assertEquals("Appointment date cannot be in the past or null", exception.getMessage());
    }

    @Test
    public void testInvalidDescription() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_MONTH, 1);
        Date date = cal.getTime();

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("A5", date, null);
        });
        assertEquals("Invalid description", exception.getMessage());

        exception = assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("A5", date, "This description is definitely way too long to be considered valid since it has more than 50 characters.");
        });
        assertEquals("Invalid description", exception.getMessage());
    }
}
