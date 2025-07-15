package velox.api.layer1.layers.strategies.interfaces;

public interface InvalidateInterface {

    void invalidate();

    @Deprecated
    void invalidateSynchronous();
}