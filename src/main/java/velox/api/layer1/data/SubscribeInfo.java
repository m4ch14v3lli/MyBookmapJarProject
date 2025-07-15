package velox.api.layer1.data;

public class SubscribeInfo {
    public final String symbol;
    public final String exchange;
    public final String type;

    public SubscribeInfo(String symbol, String exchange, String type) {
        this.symbol = symbol;
        this.exchange = exchange;
        this.type = type;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof SubscribeInfo)) return false;
        SubscribeInfo other = (SubscribeInfo) obj;
        return symbol.equals(other.symbol) && 
               exchange.equals(other.exchange) && 
               type.equals(other.type);
    }

    @Override
    public int hashCode() {
        return symbol.hashCode() + exchange.hashCode() + type.hashCode();
    }

    @Override
    public String toString() {
        return "SubscribeInfo{" +
                "symbol='" + symbol + '\'' +
                ", exchange='" + exchange + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}