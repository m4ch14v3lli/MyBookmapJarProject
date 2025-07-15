package velox.api.layer1.data;

import java.util.List;

public class OsoOrderSendParameters implements OrderSendParameters {
    public final List<SimpleOrderSendParameters> orders;

    public OsoOrderSendParameters(List<SimpleOrderSendParameters> orders) {
        this.orders = orders;
    }

    @Override
    public String toString() {
        return "OsoOrderSendParameters{" +
                "orders=" + orders +
                '}';
    }
}