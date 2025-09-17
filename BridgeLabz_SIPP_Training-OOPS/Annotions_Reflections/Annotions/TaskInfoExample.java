import java.lang.annotation.*;
import java.lang.reflect.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface TaskInfo {
    String priority();
    String assignedTo();
}

class TaskManager {
    @TaskInfo(priority = "HIGH", assignedTo = "Pratul")
    public void completeTask() {
        System.out.println("Task completed");
    }
}

public class TaskInfoExample {
    public static void main(String[] args) throws Exception {
        Method m = TaskManager.class.getMethod("completeTask");
        TaskInfo info = m.getAnnotation(TaskInfo.class);
        System.out.println("Priority: " + info.priority());
        System.out.println("Assigned To: " + info.assignedTo());
    }
}
