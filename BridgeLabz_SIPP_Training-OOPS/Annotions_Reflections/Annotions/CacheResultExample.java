import java.lang.annotation.*;
import java.lang.reflect.*;
import java.util.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface CacheResult {}

class ExpensiveCalc {
    private Map<Integer, Integer> cache = new HashMap<>();

    @CacheResult
    public int fibonacci(int n) {
        if (cache.containsKey(n)) return cache.get(n);
        int result = (n <= 1) ? n : fibonacci(n - 1) + fibonacci(n - 2);
        cache.put(n, result);
        return result;
    }
}

public class CacheResultExample {
    public static void main(String[] args) throws Exception {
        ExpensiveCalc ec = new ExpensiveCalc();
        Method m = ExpensiveCalc.class.getMethod("fibonacci", int.class);
        if (m.isAnnotationPresent(CacheResult.class)) {
            System.out.println("Fib(10): " + m.invoke(ec, 10));
            System.out.println("Fib(10) Cached: " + m.invoke(ec, 10));
        }
    }
}
