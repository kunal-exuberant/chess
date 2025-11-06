import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Patient {
    private String name;
    private int age;

    public Patient(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}

class Doctor {
    private String name;
    private String specialty;

    public Doctor(String name, String specialty) {
        this.name = name;
        this.specialty = specialty;
    }

    public String getName() {
        return name;
    }

    public String getSpecialty() {
        return specialty;
    }
}

class Appointment {
    private Patient patient;
    private Doctor doctor;
    private String date;

    public Appointment(Patient patient, Doctor doctor, String date) {
        this.patient = patient;
        this.doctor = doctor;
        this.date = date;
    }

    public void displayAppointment() {
        System.out.println("Appointment Details:");
        System.out.println("Patient: " + patient.getName() + ", Age: " + patient.getAge());
        System.out.println("Doctor: " + doctor.getName() + ", Specialty: " + doctor.getSpecialty());
        System.out.println("Date: " + date);
    }
}

public class HospitalManagementApp {
    private List<Patient> patients = new ArrayList<>();
    private List<Doctor> doctors = new ArrayList<>();
    private List<Appointment> appointments = new ArrayList<>();

    public void addPatient(String name, int age) {
        patients.add(new Patient(name, age));
    }

    public void addDoctor(String name, String specialty) {
        doctors.add(new Doctor(name, specialty));
    }

    public void scheduleAppointment(String patientName, String doctorName, String date) {
        Patient patient = patients.stream().filter(p -> p.getName().equals(patientName)).findFirst().orElse(null);
        Doctor doctor = doctors.stream().filter(d -> d.getName().equals(doctorName)).findFirst().orElse(null);
        
        if (patient != null && doctor != null) {
            appointments.add(new Appointment(patient, doctor, date));
            System.out.println("Appointment scheduled successfully.");
        } else {
            System.out.println("Patient or Doctor not found.");
        }
    }

    public void displayAppointments() {
        for (Appointment appointment : appointments) {
            appointment.displayAppointment();
        }
    }

    public static void main(String[] args) {
        HospitalManagementApp app = new HospitalManagementApp();
        Scanner scanner = new Scanner(System.in);

        // Sample data
        app.addPatient("John Doe", 30);
        app.addPatient("Jane Smith", 25);
        app.addDoctor("Dr. Brown", "Cardiology");
        app.addDoctor("Dr. Green", "Neurology");

        // Schedule an appointment
        System.out.println("Scheduling an appointment...");
        app.scheduleAppointment("John Doe", "Dr. Brown", "2023-10-01");

        // Display all appointments
        app.displayAppointments();

        scanner.close();
    }
}