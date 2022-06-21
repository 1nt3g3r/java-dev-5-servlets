import com.goit.javacore5.Calculated;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.annotation.WebFilter;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;


public class App {
    @Calculated("2+7")
    public int test;

    public String getGreeting() {
        return "Hello world.";
    }

    public static void main(String[] args) throws IllegalAccessException {
        App app = new App();
        process(app);
        System.out.println("app.test = " + app.test);
    }

    private static void process(Object object) throws IllegalAccessException {
        for (Field field : object.getClass().getDeclaredFields()) {
            field.setAccessible(true); // You might want to set modifier to public first.

            Calculated calculated = field.getAnnotation(Calculated.class);

            if (calculated != null) {
                String value = calculated.value();

                String[] valueParts = value.split("");
                int number1 = Integer.parseInt(valueParts[0]);
                int number2 = Integer.parseInt(valueParts[2]);

                int result = number1 + number2;

                field.setInt(object, result);
            }
        }
    }
}
