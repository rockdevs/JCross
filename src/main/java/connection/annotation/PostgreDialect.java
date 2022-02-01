package connection.annotation;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@SqlDialect
public @interface PostgreDialect {
    boolean enable() default true;
}
