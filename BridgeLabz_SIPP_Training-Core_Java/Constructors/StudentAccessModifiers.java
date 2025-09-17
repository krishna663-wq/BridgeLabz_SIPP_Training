class StudentAccessModifiers {
    public int rollNumber;
    protected String name;
    private double CGPA;

    public StudentAccessModifiers(int rollNumber, String name, double CGPA) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.CGPA = CGPA;
    }

    public double getCGPA() {
        return CGPA;
    }

    public void setCGPA(double CGPA) {
        this.CGPA = CGPA;
    }
}

class PostgraduateStudent extends StudentAccessModifiers {
    public PostgraduateStudent(int rollNumber, String name, double CGPA) {
        super(rollNumber, name, CGPA);
    }

    public void display() {
        System.out.println("Roll Number: " + rollNumber + ", Name: " + name);
    }
}