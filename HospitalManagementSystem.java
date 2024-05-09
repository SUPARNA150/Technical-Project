import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class HospitalManagementSystem {
    private static Map<Long, Patient> patients = new HashMap<>();
    private static long nextPatientId = 1;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        // Admin Login
        String pwd = "Kolkata@1";
        System.out.println("Welcome to Admin Login Page:");
        System.out.println("Enter your password.");
        String pwd_check = sc.nextLine();

        if (pwd_check.equals(pwd)) {
            System.out.println("Welcome Admin.\n\n");
            do {
                System.out.println("Menu:");
                System.out.println("1. Patient Registration");
                System.out.println("2. View Patient Details");
                System.out.println("3. Search Patient by PID");
                System.out.println("4. Update Patients by Email Domain");
                System.out.println("5. Delete Patients by Mobile number");
                System.out.println("6. Exit");
                System.out.print("Enter your choice: ");
                choice = sc.nextInt();

                switch (choice) {
                    case 1:
                        System.out.println("You have selected the Patient Registration Feature.");
                        registerPatient(sc);
                        break;
                    case 2:
                        System.out.println("You have selected the View Patient Details Feature.");
                        viewPatientDetails();
                        break;
                    case 3:
                        System.out.println("You have selected the Search Patient Feature.");
                        searchPatientById(sc);
                        break;
                    case 4:
                        System.out.println("You have selected the Update Patients by Email Domain Feature.");
                        updatePatientsByEmailDomain(sc);
                        break;
                    case 5:
                        System.out.println("You have selected the Delete Patients by Mobile number Feature.");
                        deletePatientsByMobileNumber(sc);
                        break;
                    case 6:
                        System.out.println("Good Bye Administrator!!. Terminating the Program.");
                        break;
                    default:
                        System.out.println(
                                "You have selected an inappropriate option. Kindly select an appropriate option.");
                }
            } while (choice != 6);
        } else {
            System.out.println("Invalid Password!!");
        }

        sc.close();
    }

    private static void registerPatient(Scanner sc) {
        System.out.print("Enter First Name: ");
        String firstName = sc.next();

        System.out.print("Enter Last Name: ");
        String lastName = sc.next();

        System.out.print("Enter Email ID: ");
        String email = sc.next();

        System.out.print("Enter Mobile Number: ");
        long mobileNumber = sc.nextLong();

        System.out.print("Enter Gender: ");
        String gender = sc.next();

        System.out.print("Enter City: ");
        String city = sc.next();

        System.out.print("Enter Doctor ID: ");
        String doctorId = sc.next();

        sc.nextLine();

        System.out.print("Enter Doctor Name: ");
        String doctorName = sc.nextLine();

        System.out.print("Enter Address: ");
        String address = sc.nextLine();

        System.out.print("Enter Contact No: ");
        long contactNo = sc.nextLong();

        // Generate PID
        int year = Calendar.getInstance().get(Calendar.YEAR);
        int hospitalCode = 1234; // Replace with actual hospital code
        long serialNumber = ++nextPatientId;
        long pid = Long.parseLong(String.format("%04d%04d%02d", year, hospitalCode, serialNumber));

        Patient patient = new Patient(pid, firstName, lastName, email, mobileNumber, gender, city, doctorId, doctorName,
                address, contactNo);
        patients.put(pid, patient);

        System.out.println("Patient registered successfully with PID: " + pid);
    }

    private static void viewPatientDetails() {
        System.out.println("Patient Details:\n");
        for (Map.Entry<Long, Patient> entry : patients.entrySet()) {
            Patient patient = entry.getValue();
            System.out.println("PID: " + patient.getPid());
            System.out.println("Name: " + patient.getFirstName() + " " + patient.getLastName());
            System.out.println("Email: " + patient.getEmail());
            System.out.println("Mobile Number: " + patient.getMobileNumber());
            System.out.println("Gender: " + patient.getGender());
            System.out.println("City: " + patient.getCity());
            System.out.println("Doctor ID: " + patient.getDoctorId());
            System.out.println("Doctor Name: " + patient.getDoctorName());
            System.out.println("Address: " + patient.getAddress());
            System.out.println("Contact No: " + patient.getContactNo());
            System.out.println();
        }
    }

    private static void searchPatientById(Scanner sc) {
        System.out.print("Enter PID: ");
        long pid = sc.nextLong();
        if (patients.containsKey(pid)) {
            System.out.println("Patient found:");
            System.out.println(patients.get(pid));
        } else {
            System.out.println("Patient not found.");
        }
    }

    private static void updatePatientsByEmailDomain(Scanner sc) {
        System.out.print("Enter Email Domain: ");
        String emailDomain = sc.next();
        boolean updated = false;
        for (Patient patient : patients.values()) {
            if (patient.getEmail().equals(emailDomain)) {
                // Update patient information here
                System.out.println("Enter new First Name: ");
                String newFirstName = sc.next();
                patient.firstName = newFirstName;

                System.out.println("Enter new Last Name: ");
                String newLastName = sc.next();
                patient.lastName = newLastName;

                System.out.println("Enter new Mobile Number: ");
                long newMobileNumber = sc.nextLong();
                patient.mobileNumber = newMobileNumber;

                System.out.println("Enter new Gender: ");
                String newGender = sc.next();
                patient.gender = newGender;

                System.out.println("Enter new City: ");
                String newCity = sc.next();
                patient.city = newCity;

                System.out.println("Enter new Doctor ID: ");
                String newDoctorId = sc.next();
                patient.doctorId = newDoctorId;

                sc.nextLine();

                System.out.println("Enter new Doctor Name: ");
                String newDoctorName = sc.nextLine();
                patient.doctorName = newDoctorName;

                System.out.println("Enter new Address: ");
                String newAddress = sc.nextLine();
                patient.address = newAddress;

                System.out.println("Enter new Contact No: ");
                long newContactNo = sc.nextLong();
                patient.contactNo = newContactNo;

                updated = true;
            }
        }
        if (updated) {
            System.out.println("Patient(s) with email domain '" + emailDomain + "' updated.");
        } else {
            System.out.println("No patient found with email domain '" + emailDomain + "'.");
        }
    }

    private static void deletePatientsByMobileNumber(Scanner sc) {
        System.out.print("Enter Mobile Number: ");
        long mobileNumber = sc.nextLong();
        for (Map.Entry<Long, Patient> entry : patients.entrySet()) {
            if (entry.getValue().getMobileNumber() == mobileNumber) {
                patients.remove(entry.getKey());
                System.out.println("Patient with mobile number '" + mobileNumber + "' deleted.");
                return;
            }
        }
        System.out.println("Patient with mobile number '" + mobileNumber + "' not found.");
    }

    private static class Patient {
        private long pid;
        private String firstName;
        private String lastName;
        private String email;
        private long mobileNumber;
        private String gender;
        private String city;
        private String doctorId;
        private String doctorName;
        private String address;
        private long contactNo;

        public Patient(long pid, String firstName, String lastName, String email, long mobileNumber, String gender,
                String city, String doctorId, String doctorName, String address, long contactNo) {
            this.pid = pid;
            this.firstName = firstName;
            this.lastName = lastName;
            this.email = email;
            this.mobileNumber = mobileNumber;
            this.gender = gender;
            this.city = city;
            this.doctorId = doctorId;
            this.doctorName = doctorName;
            this.address = address;
            this.contactNo = contactNo;
        }

        public long getPid() {
            return pid;
        }

        public String getFirstName() {
            return firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public String getEmail() {
            return email;
        }

        public long getMobileNumber() {
            return mobileNumber;
        }

        public String getGender() {
            return gender;
        }

        public String getCity() {
            return city;
        }

        public String getDoctorId() {
            return doctorId;
        }

        public String getDoctorName() {
            return doctorName;
        }

        public String getAddress() {
            return address;
        }

        public long getContactNo() {
            return contactNo;
        }

        @Override
        public String toString() {
            return "PID: " + pid +
                    ", Name: " + firstName + " " + lastName +
                    ", Email: " + email +
                    ", Mobile Number: " + mobileNumber +
                    ", Gender: " + gender +
                    ", City: " + city +
                    ", Doctor ID: " + doctorId +
                    ", Doctor Name: " + doctorName +
                    ", Address: " + address +
                    ", Contact No: " + contactNo;
        }
    }
}
