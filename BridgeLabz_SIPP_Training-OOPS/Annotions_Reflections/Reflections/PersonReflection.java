import java.lang.reflect.Field;

class Person {
    private int age = 20;
}

public class PersonReflection {
    public static void main(String[] args) throws Exception {
        Person p = new Person();
        Field ageField = Person.class.getDeclaredField("age");
        ageField.setAccessible(true);

        System.out.println("Old Age: " + ageField.get(p));
        ageField.set(p, 30);
        System.out.println("New Age: " + ageField.get(p));
    }
}
