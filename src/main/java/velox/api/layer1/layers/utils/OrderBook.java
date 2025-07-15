package velox.api.layer1.layers.utils;

import java.util.TreeMap;

public class OrderBook {
    protected TreeMap<Integer, Long> bidMap;
    protected TreeMap<Integer, Long> askMap;
    public static final int NONE = -1;

    public OrderBook() {
        this.bidMap = new TreeMap<>();
        this.askMap = new TreeMap<>();
    }

    public OrderBook(OrderBook orderBook) {
        this.bidMap = new TreeMap<>(orderBook.bidMap);
        this.askMap = new TreeMap<>(orderBook.askMap);
    }

    public void clear() {
        bidMap.clear();
        askMap.clear();
    }

    public TreeMap<Integer, Long> getBidMap() {
        return bidMap;
    }

    public TreeMap<Integer, Long> getAskMap() {
        return askMap;
    }

    public int getBestBidPriceOrNone() {
        return bidMap.isEmpty() ? NONE : bidMap.lastKey();
    }

    public int getBestAskPriceOrNone() {
        return askMap.isEmpty() ? NONE : askMap.firstKey();
    }

    public double getMidPriceOrNan() {
        int bestBid = getBestBidPriceOrNone();
        int bestAsk = getBestAskPriceOrNone();
        return (bestBid == NONE || bestAsk == NONE) ? Double.NaN : (bestBid + bestAsk) / 2.0;
    }

    public boolean isEmpty() {
        return bidMap.isEmpty() && askMap.isEmpty();
    }

    public void onUpdate(boolean isBid, int price, long size) {
        // Logic to handle updates
    }

    public void onUpdate(DepthAggregationEvent depthAggregationEvent) {
        // Logic to handle depth aggregation updates
    }

    public void replace(String orderId, int price, int size) {
        // Logic to replace an order
    }

    public void cancel(String orderId) {
        // Logic to cancel an order
    }

    public Order getOrder(String orderId) {
        // Logic to retrieve an order by its ID
        return null; // Placeholder return value
    }

    @Override
    public String toString() {
        return "OrderBook{" +
                "bidMap=" + bidMap +
                ", askMap=" + askMap +
                '}';
    }
}