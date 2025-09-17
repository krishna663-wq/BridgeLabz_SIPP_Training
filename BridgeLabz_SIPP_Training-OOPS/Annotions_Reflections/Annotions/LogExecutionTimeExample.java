import java.lang.annotation.*;
import java.lang.reflect.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface LogExecutionTime {}

class Processor {
    @LogExecutionTime
    public void taskOne() throws InterruptedException {
        Thread.sleep(200);
    }

    @LogExecutionTime
    public void taskTwo() throws InterruptedException {
        Thread.sleep(500);
    }
}

public class LogExecutionTimeExample {
    public static void main(String[] args) throws Exception {
        Processor p = new Processor();
        for (Method m : Processor.class.getDeclaredMethods()) {
            if (m.isAnnotationPresent(LogExecutionTime.class)) {
                long start = System.nanoTime();
                m.invoke(p);
                long end = System.nanoTime();
                System.out.println(m.getName() + " executed in " + (end - start) / 1_000_000 + " ms");
            }
        }
    }
}
