package velox.api.layer1.messages.indicators;

public class IndicatorLineStyle {

    public static final IndicatorLineStyle DEFAULT = new IndicatorLineStyle(); 
    public static final IndicatorLineStyle NONE = new IndicatorLineStyle(); 
    public static final IndicatorLineStyle SHORT_DASHES = new IndicatorLineStyle(); 
    public static final IndicatorLineStyle SHORT_DASHES_WIDE_LEFT_NARROW_RIGHT = new IndicatorLineStyle(); 

    public final short mainLineStyleMask;
    public final short mainLineStyleMultiplier;
    public final int mainLineWidth;
    public final short rightLineStyleMask;
    public final short rightLineStyleMultiplier;
    public final int rightLineWidth;

    public IndicatorLineStyle() {
        this.mainLineStyleMask = 0; 
        this.mainLineStyleMultiplier = 1; 
        this.mainLineWidth = 1; 
        this.rightLineStyleMask = 0; 
        this.rightLineStyleMultiplier = 1; 
        this.rightLineWidth = 1; 
    }

    public IndicatorLineStyle(short mainLineStyleMask, short mainLineStyleMultiplier, int mainLineWidth,
                              short rightLineStyleMask, short rightLineStyleMultiplier, int rightLineWidth) {
        this.mainLineStyleMask = mainLineStyleMask;
        this.mainLineStyleMultiplier = mainLineStyleMultiplier;
        this.mainLineWidth = mainLineWidth;
        this.rightLineStyleMask = rightLineStyleMask;
        this.rightLineStyleMultiplier = rightLineStyleMultiplier;
        this.rightLineWidth = rightLineWidth;
    }
}