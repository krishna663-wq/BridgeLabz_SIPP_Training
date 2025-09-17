public class PersonCopyConstructor {
    String name;
    int age;

    // Parameterized constructor
    public PersonCopyConstructor(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Copy constructor
    public PersonCopyConstructor(PersonCopyConstructor other) {
        this.name = other.name;
        this.age = other.age;
    }

    public void display() {
        System.out.println("Name: " + name + ", Age: " + age);
    }
}