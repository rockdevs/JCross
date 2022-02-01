package core.concretes;

import connection.connector.abstracts.CrossConnector;
import context.executor.abstracts.ScriptExecutor;
import context.executor.concretes.EntityScriptExecutor;
import context.generator.abstracts.ScriptGenerator;
import context.generator.concretes.EntityScriptGenerator;
import core.abstracts.AbstractJCrossEngine;
import core.abstracts.AnnotatedInitializer;

public class AnnotatedCrossEngine extends AbstractJCrossEngine implements AnnotatedInitializer {

    private final ScriptGenerator scriptGenerator = new EntityScriptGenerator();
    private final ScriptExecutor scriptExecutor = new EntityScriptExecutor();

    @Override
    public void reflector() {

    }

}
