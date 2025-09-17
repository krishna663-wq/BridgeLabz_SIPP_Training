import java.lang.annotation.*;
import java.lang.reflect.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface MaxLength {
    int value();
}

class User {
    @MaxLength(8)
    String username;

    public User(String username) throws Exception {
        this.username = username;
        for (Field f : User.class.getDeclaredFields()) {
            if (f.isAnnotationPresent(MaxLength.class)) {
                MaxLength ml = f.getAnnotation(MaxLength.class);
                if (username.length() > ml.value()) {
                    throw new IllegalArgumentException("Username exceeds max length!");
                }
            }
        }
    }
}

public class MaxLengthExample {
    public static void main(String[] args) throws Exception {
        new User("Krishna"); 
        // new User("ThisNameIsTooLong"); // Throws exception
    }
}
