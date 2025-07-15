package velox.api.layer1.data;

import java.util.List;

public class OcoOrderSendParameters implements OrderSendParameters {
    
    public final List<SimpleOrderSendParameters> orders;

    public OcoOrderSendParameters(List<SimpleOrderSendParameters> orders) {
        this.orders = orders;
    }

    public OcoOrderSendParameters(SimpleOrderSendParameters... orders) {
        this.orders = List.of(orders);
    }

    @Override
    public String toString() {
        return "OcoOrderSendParameters{" +
                "orders=" + orders +
                '}';
    }
}