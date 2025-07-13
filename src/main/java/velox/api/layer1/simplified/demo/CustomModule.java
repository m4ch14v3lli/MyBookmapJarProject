package velox.api.layer1.simplified.demo;

public abstract class CustomModule {
    public abstract void initialize(String alias,
                                    velox.api.layer1.data.InstrumentInfo info,
                                    Api api,
                                    InitialState initialState);

    public abstract void stop();
}
