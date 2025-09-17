import java.lang.annotation.*;
import java.lang.reflect.*;
import java.util.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface JsonField {
    String name();
}

class Person {
    @JsonField(name = "user_name")
    String username;

    @JsonField(name = "user_age")
    int age;

    Person(String u, int a) {
        this.username = u;
        this.age = a;
    }
}

public class JsonFieldExample {
    public static String toJson(Object obj) throws Exception {
        Map<String, Object> jsonMap = new HashMap<>();
        for (Field f : obj.getClass().getDeclaredFields()) {
            if (f.isAnnotationPresent(JsonField.class)) {
                JsonField jf = f.getAnnotation(JsonField.class);
                f.setAccessible(true);
                jsonMap.put(jf.name(), f.get(obj));
            }
        }
        return jsonMap.toString();
    }

    public static void main(String[] args) throws Exception {
        Person p = new Person("Krishna", 22);
        System.out.println(toJson(p));
    }
}
