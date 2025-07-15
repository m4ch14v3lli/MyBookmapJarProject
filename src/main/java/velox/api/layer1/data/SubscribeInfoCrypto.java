package velox.api.layer1.data;

public class SubscribeInfoCrypto extends SubscribeInfo {
    public final double pips;
    public final double sizeMultiplier;

    public SubscribeInfoCrypto(String symbol, String exchange, String type, double pips, double sizeMultiplier) {
        super(symbol, exchange, type);
        this.pips = pips;
        this.sizeMultiplier = sizeMultiplier;
    }

    @Override
    public String toString() {
        return "SubscribeInfoCrypto{" +
                "symbol='" + symbol + '\'' +
                ", exchange='" + exchange + '\'' +
                ", type='" + type + '\'' +
                ", pips=" + pips +
                ", sizeMultiplier=" + sizeMultiplier +
                '}';
    }
}