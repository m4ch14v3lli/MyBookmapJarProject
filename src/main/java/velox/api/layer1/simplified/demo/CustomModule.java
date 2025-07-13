package velox.api.layer1.simplified.demo;

public interface Api {}
public class InitialState {}
/**
 * Base class for modules annotated with Layer1SimpleAttachable.
 * Provides way for Bookmap to interact with module.
 *
 * This class serves as the base contract for custom modules in the Bookmap platform.
 * Known subclasses include AllDataModule and CustomModuleAdapter.
 */
public class CustomModule {

    /**
     * Called before any other method
     *
     * @param alias host instrument (the one where checkbox was checked)
     * @param info instrument info. Might be an instance of a subclass, providing some extra data
     * @param api object for interacting with Bookmap
     * @param initialState additional information partially replacing historical data, such
     *                    as last trade price
     */
    public abstract void initialize(String alias,
                                    velox.api.layer1.data.InstrumentInfo info,
                                    Api api,
                                    InitialState initialState);

    /**
     * Called before unloading the module. If you have started any thread or
     * allocated any resources - that's a good place to release those.
     */
    public abstract void stop();
}

// Example implementation:
/*
@Layer1SimpleAttachable
public class MyCustomModule extends CustomModule {

    private Api api;
    private String instrumentAlias;
    private volatile boolean isRunning = false;

    @Override
    public void initialize(String alias,
                          InstrumentInfo info,
                          Api api,
                          InitialState initialState) {
        this.api = api;
        this.instrumentAlias = alias;
        this.isRunning = true;

        // Initialize your module logic here
        System.out.println("Module initialized for instrument: " + alias);

        // Access initial state if needed
        if (initialState != null) {
            // Use initial state data
        }
    }

    @Override
    public void stop() {
        this.isRunning = false;

        // Clean up resources
        // Stop any running threads
        // Close connections, etc.

        System.out.println("Module stopped for instrument: " + instrumentAlias);
    }
}
*/