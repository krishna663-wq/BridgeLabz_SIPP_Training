public class CourseManagement {
    String courseName;
    int duration;
    double fee;
    static String instituteName = "ABC Institute"; // Class variable

    public CourseManagement(String courseName, int duration, double fee) {
        this.courseName = courseName;
        this.duration = duration;
        this.fee = fee;
    }

    // Instance method
    public void displayCourseDetails() {
        System.out.println("Course: " + courseName + ", Duration: " + duration + " months, Fee: " + fee + ", Institute: " + instituteName);
    }

    // Class method
    public static void updateInstituteName(String name) {
        instituteName = name;
    }
}