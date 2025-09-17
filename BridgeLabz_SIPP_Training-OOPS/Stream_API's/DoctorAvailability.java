import java.util.*;
import java.util.stream.*;

class Doctor {
    String name;
    String specialty;
    boolean weekendAvailable;
    Doctor(String name, String specialty, boolean weekendAvailable) {
        this.name = name;
        this.specialty = specialty;
        this.weekendAvailable = weekendAvailable;
    }
}

public class DoctorAvailability {
    public static void main(String[] args) {
        List<Doctor> doctors = Arrays.asList(
                new Doctor("Dr. Smith", "Cardiology", true),
                new Doctor("Dr. John", "Neurology", false),
                new Doctor("Dr. Emily", "Orthopedics", true),
                new Doctor("Dr. Clark", "Dermatology", true)
        );

        doctors.stream()
                .filter(d -> d.weekendAvailable)
                .sorted(Comparator.comparing(d -> d.specialty))
                .forEach(d -> System.out.println(d.name + " - " + d.specialty));
    }
}
