import java.lang.reflect.Constructor;

class Student {
    String name;
    Student() { this.name = "Default Student"; }
}

public class StudentReflection {
    public static void main(String[] args) throws Exception {
        Class<?> clazz = Class.forName("Student");
        Constructor<?> constructor = clazz.getDeclaredConstructor();
        Object obj = constructor.newInstance();
        System.out.println("Created object: " + obj.getClass().getName());
    }
}
