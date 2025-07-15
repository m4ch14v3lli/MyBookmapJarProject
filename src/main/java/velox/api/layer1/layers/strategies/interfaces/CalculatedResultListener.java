package velox.api.layer1.layers.strategies.interfaces;

public interface CalculatedResultListener {
    
    boolean isCancelled();

    void provideResponse(Object value);

    void setCompleted();
}