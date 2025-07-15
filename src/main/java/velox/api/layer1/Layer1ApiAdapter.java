package velox.api.layer1;

/**
 * Interface Layer1ApiAdapter extends all possible Layer1 listeners, capable of listening to 
 * any Layer1 API events. It provides default empty implementations for these events.
 */
public interface Layer1ApiAdapter extends Layer1ApiInstrumentAdapter, 
                                            Layer1ApiDataAdapter, 
                                            Layer1ApiMboDataAdapter, 
                                            Layer1ApiTradingAdapter, 
                                            Layer1ApiAdminAdapter, 
                                            Layer1ApiListener {
    // This interface serves as a composite adapter for various Layer1 API components.
    // Specific method implementations would be defined in concrete classes that implement this interface.
}