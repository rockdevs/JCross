package connection.annotation;


@SqlDialect
public @interface MySqlDialect {
    boolean enable() default true;
}