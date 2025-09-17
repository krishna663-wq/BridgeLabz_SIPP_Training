public class CircleWithChaining {
    double radius;

    // Default constructor
    public CircleWithChaining() {
        this(1.0); // Constructor chaining to parameterized constructor
    }

    // Parameterized constructor
    public CircleWithChaining(double radius) {
        this.radius = radius;
    }

    public void display() {
        System.out.println("Radius: " + radius);
    }
}