import org.junit.jupiter.api.Test;
import java.util.Calendar;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class AppointmentServiceTest {

    @Test
    public void testAddAppointment() {
        AppointmentService service = new AppointmentService();
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_MONTH, 1);
        Appointment appt = new Appointment("AP1", cal.getTime(), "Meeting");
        service.addAppointment(appt);
        assertEquals("Meeting", service.getAppointment("AP1").getDescription());
    }

    @Test
    public void testDeleteAppointment() {
        AppointmentService service = new AppointmentService();
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_MONTH, 2);
        Appointment appt = new Appointment("AP2", cal.getTime(), "Lunch");
        service.addAppointment(appt);
        service.deleteAppointment("AP2");
        assertNull(service.getAppointment("AP2"));
    }

    @Test
    public void testAddDuplicateAppointmentID() {
        AppointmentService service = new AppointmentService();
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_MONTH, 3);
        Date date = cal.getTime();

        Appointment appt1 = new Appointment("DUP1", date, "First");
        Appointment appt2 = new Appointment("DUP1", date, "Second");
        service.addAppointment(appt1);
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            service.addAppointment(appt2);
        });
        assertEquals("Appointment ID already exists", exception.getMessage());
    }
}
