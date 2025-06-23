import java.util.ArrayList;
import java.util.List;

public class AppointmentService {
    private final List<Appointment> appointments = new ArrayList<>();

    public void addAppointment(Appointment appointment) {
        for (Appointment a : appointments) {
            if (a.getAppointmentID().equals(appointment.getAppointmentID())) {
                throw new IllegalArgumentException("Appointment ID already exists");
            }
        }
        appointments.add(appointment);
    }

    public void deleteAppointment(String appointmentID) {
        appointments.removeIf(a -> a.getAppointmentID().equals(appointmentID));
    }

    public Appointment getAppointment(String appointmentID) {
        for (Appointment a : appointments) {
            if (a.getAppointmentID().equals(appointmentID)) {
                return a;
            }
        }
        return null;
    }
}
