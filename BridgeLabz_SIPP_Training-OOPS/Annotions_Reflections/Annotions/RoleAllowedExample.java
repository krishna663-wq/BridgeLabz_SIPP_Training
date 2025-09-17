import java.lang.annotation.*;
import java.lang.reflect.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface RoleAllowed {
    String value();
}

class AdminSystem {
    @RoleAllowed("ADMIN")
    public void deleteUser() {
        System.out.println("User deleted!");
    }
}

public class RoleAllowedExample {
    public static void main(String[] args) throws Exception {
        String currentRole = "USER";
        Method m = AdminSystem.class.getMethod("deleteUser");
        RoleAllowed ra = m.getAnnotation(RoleAllowed.class);
        if (ra.value().equals(currentRole)) {
            m.invoke(new AdminSystem());
        } else {
            System.out.println("Access Denied!");
        }
    }
}
