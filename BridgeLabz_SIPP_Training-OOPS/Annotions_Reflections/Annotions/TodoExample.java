import java.lang.annotation.*;
import java.lang.reflect.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface Todo {
    String task();
    String assignedTo();
    String priority() default "MEDIUM";
}

class DevWork {
    @Todo(task = "Implement login", assignedTo = "Rahul")
    public void login() {}

    @Todo(task = "Fix payment bug", assignedTo = "Anjali", priority = "HIGH")
    public void payment() {}
}

public class TodoExample {
    public static void main(String[] args) throws Exception {
        for (Method m : DevWork.class.getDeclaredMethods()) {
            if (m.isAnnotationPresent(Todo.class)) {
                Todo t = m.getAnnotation(Todo.class);
                System.out.println("Task: " + t.task() + ", Assigned: " + t.assignedTo() + ", Priority: " + t.priority());
            }
        }
    }
}
