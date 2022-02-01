package core.concretes;

import core.abstracts.CrossEngineStarter;
import core.abstracts.JCrossRunner;

public class ApplicationRunner implements JCrossRunner {
    CrossEngineStarter engine = new AnnotatedCrossEngine();
    @Override
    public void run(String mainClassPath) {
        engine.run(mainClassPath);
    }
}
