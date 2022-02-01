package core.abstracts;

public abstract class AbstractJCrossEngine implements CrossEngineStarter {
    @Override
    public void run() {
        reflector();
    }
}
