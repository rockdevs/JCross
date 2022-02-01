package connection.annotation;


@SqlDialect
public @interface OracleDialect {
    boolean enable() default true;
}