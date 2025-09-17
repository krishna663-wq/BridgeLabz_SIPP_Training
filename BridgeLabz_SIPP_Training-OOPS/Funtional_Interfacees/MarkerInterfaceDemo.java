interface SensitiveData {}

class PatientRecord implements SensitiveData {
    String name;
    String disease;
    PatientRecord(String name, String disease) {
        this.name = name;
        this.disease = disease;
    }
}

public class MarkerInterfaceDemo {
    public static void main(String[] args) {
        PatientRecord record = new PatientRecord("Amit", "Flu");

        if (record instanceof SensitiveData) {
            System.out.println("Encrypting Patient Data before saving...");
        } else {
            System.out.println("Saving without encryption...");
        }
    }
}
