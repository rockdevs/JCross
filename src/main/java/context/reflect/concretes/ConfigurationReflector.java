package context.reflect.concretes;

import connection.connector.abstracts.CrossConnector;
import org.reflections.Reflections;
import org.reflections.scanners.*;
import org.reflections.util.ClasspathHelper;

import java.util.Set;
import java.util.regex.Pattern;

public class ConfigurationReflector {

    private CrossConnector connector;

    private volatile Reflections reflections;


    public void getReflections() {
        if(reflections==null){
            synchronized (ConfigurationReflector.class) {
                if (reflections == null) {
                    reflections = new Reflections(ClasspathHelper.forJavaClassPath(),Scanners.Resources,Scanners.TypesAnnotated,Scanners.SubTypes,Scanners.FieldsAnnotated);
                }
            }
        }
    }

    public Set<String> getJCrossXmlPaths() {
        if(reflections==null) getReflections();
        return reflections.getResources(Pattern.compile(".*cross\\.xml"));
    }


}
