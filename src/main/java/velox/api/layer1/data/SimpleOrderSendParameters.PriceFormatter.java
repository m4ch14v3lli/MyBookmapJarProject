package velox.api.layer1.data;

public interface SimpleOrderSendParameters {
    interface PriceFormatter {
        String format(double price);
    }
}