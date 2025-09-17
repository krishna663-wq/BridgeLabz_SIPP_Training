import java.lang.annotation.*;
import java.lang.reflect.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface ImportantMethod {
    String level() default "HIGH";
}

class Project {
    @ImportantMethod
    public void start() {}

    @ImportantMethod(level = "LOW")
    public void cleanup() {}
}

public class ImportantMethodExample {
    public static void main(String[] args) throws Exception {
        for (Method m : Project.class.getDeclaredMethods()) {
            if (m.isAnnotationPresent(ImportantMethod.class)) {
                ImportantMethod im = m.getAnnotation(ImportantMethod.class);
                System.out.println(m.getName() + " -> Level: " + im.level());
            }
        }
    }
}
