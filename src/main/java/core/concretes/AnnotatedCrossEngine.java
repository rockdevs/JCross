package core.concretes;

import connection.connector.abstracts.CrossConnector;
import context.executor.abstracts.ScriptExecutor;
import context.executor.concretes.EntityScriptExecutor;
import context.generator.abstracts.ScriptGenerator;
import context.generator.concretes.EntityScriptGenerator;
import context.reflect.concretes.CrossXMLReader;
import core.abstracts.AbstractJCrossEngine;
import core.abstracts.AnnotatedInitializer;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class AnnotatedCrossEngine extends AbstractJCrossEngine implements AnnotatedInitializer {

    private final ScriptGenerator scriptGenerator = new EntityScriptGenerator();
    private final ScriptExecutor scriptExecutor = new EntityScriptExecutor();

    @Override
    public void reflector() {
        try {
            new CrossXMLReader().render();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }

}
