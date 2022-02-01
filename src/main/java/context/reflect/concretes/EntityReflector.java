package context.reflect.concretes;

public class EntityReflector {
    private final ConfigurationReflector reflector;

    public EntityReflector(String mainClassPath) {
        this.reflector = new ConfigurationReflector();
    }

}
