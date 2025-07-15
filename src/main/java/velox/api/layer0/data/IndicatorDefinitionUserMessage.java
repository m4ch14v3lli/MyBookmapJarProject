package velox.api.layer0.data;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.util.IllegalFormatException;

/**
 * Deprecated class for defining indicators, similar to Recorder API.
 * Use Layer1ApiUserMessageModifyIndicator or Layer1ApiUserMessageModifyScreenSpacePainter instead.
 * 
 * @deprecated Use velox.api.layer1.messages.indicators.Layer1ApiUserMessageModifyIndicator
 *             or velox.api.layer1.messages.indicators.Layer1ApiUserMessageModifyScreenSpacePainter
 */
@Deprecated
public class IndicatorDefinitionUserMessage extends Object {
    
    /**
     * Indicator ID used to reference it later
     */
    public final int id;
    
    /**
     * Alias of the instrument indicator is applied to
     */
    public final String alias;
    
    /**
     * Name shown in Bookmap UI
     */
    public final String indicatorName;
    
    /**
     * Style of the line to the left of current time line
     * One bits mean visible pixels, zero bits - invisible; use 0 to hide the line
     */
    public final short mainLineStyleMask;
    
    /**
     * How many pixels correspond to one bit of mainLineStyleMask
     */
    public final short mainLineStyleMultiplier;
    
    /**
     * Width of the line to the left of current time line
     */
    public final int mainLineWidth;
    
    /**
     * Color of the line
     */
    public final Color lineColor;
    
    /**
     * Style of the line to the right of current time line (extension)
     * One bits mean visible pixels, zero bits - invisible; use 0 to hide the line
     */
    public final short rightLineStyleMask;
    
    /**
     * How many pixels correspond to one bit of rightLineStyleMask
     */
    public final short rightLineStyleMultiplier;
    
    /**
     * Width of the line to the right of current time line
     */
    public final int rightLineWidth;
    
    /**
     * Icon displayed at points defined by IndicatorPointUserMessage
     * Use null if you don't want any
     */
    public final BufferedImage icon;
    
    /**
     * Offset of the icon by X axis (positive offset moves icon to the right)
     */
    public final int iconOffsetX;
    
    /**
     * Offset of the icon by Y axis (positive offset moves icon to the top)
     */
    public final int iconOffsetY;
    
    /**
     * True to show on main chart, false to show on bottom panel
     */
    public final boolean showOnMainChart;
    
    /**
     * Format used to convert value to string
     * Null keeps default formatting, non-null values are passed to String.format()
     */
    public final String valueFormat;
    
    /**
     * Define new custom indicator with value format
     *
     * @param id indicator id (used to reference it later)
     * @param alias alias of the instrument indicator is applied to
     * @param indicatorName name shown in Bookmap UI
     * @param mainLineStyleMask style of the line to the left of current time line
     * @param mainLineStyleMultiplier how many pixels correspond to one bit of mainLineStyleMask
     * @param mainLineWidth width of the line to the left of current time line
     * @param lineColor color of the line
     * @param rightLineStyleMask style of the line to the right of current time line
     * @param rightLineStyleMultiplier how many pixels correspond to one bit of rightLineStyleMask
     * @param rightLineWidth width of the line to the right of current time line
     * @param icon icon displayed at points; use null if you don't want any
     * @param iconOffsetX offset of the icon by X axis
     * @param iconOffsetY offset of the icon by Y axis
     * @param showOnMainChart true to show on main chart, false to show on bottom panel
     * @param valueFormat format used to convert value to string
     * @throws IllegalFormatException invalid valueFormat argument
     */
    public IndicatorDefinitionUserMessage(int id,
                                        String alias,
                                        String indicatorName,
                                        short mainLineStyleMask,
                                        short mainLineStyleMultiplier,
                                        int mainLineWidth,
                                        Color lineColor,
                                        short rightLineStyleMask,
                                        short rightLineStyleMultiplier,
                                        int rightLineWidth,
                                        BufferedImage icon,
                                        int iconOffsetX,
                                        int iconOffsetY,
                                        boolean showOnMainChart,
                                        String valueFormat) throws IllegalFormatException {
        this.id = id;
        this.alias = alias;
        this.indicatorName = indicatorName;
        this.mainLineStyleMask = mainLineStyleMask;
        this.mainLineStyleMultiplier = mainLineStyleMultiplier;
        this.mainLineWidth = mainLineWidth;
        this.lineColor = lineColor;
        this.rightLineStyleMask = rightLineStyleMask;
        this.rightLineStyleMultiplier = rightLineStyleMultiplier;
        this.rightLineWidth = rightLineWidth;
        this.icon = icon;
        this.iconOffsetX = iconOffsetX;
        this.iconOffsetY = iconOffsetY;
        this.showOnMainChart = showOnMainChart;
        this.valueFormat = valueFormat;
    }
    
    /**
     * Define new custom indicator without value format
     *
     * @param id indicator id (used to reference it later)
     * @param alias alias of the instrument indicator is applied to
     * @param indicatorName name shown in Bookmap UI
     * @param mainLineStyleMask style of the line to the left of current time line
     * @param mainLineStyleMultiplier how many pixels correspond to one bit of mainLineStyleMask
     * @param mainLineWidth width of the line to the left of current time line
     * @param lineColor color of the line
     * @param rightLineStyleMask style of the line to the right of current time line
     * @param rightLineStyleMultiplier how many pixels correspond to one bit of rightLineStyleMask
     * @param rightLineWidth width of the line to the right of current time line
     * @param icon icon displayed at points; use null if you don't want any
     * @param iconOffsetX offset of the icon by X axis
     * @param iconOffsetY offset of the icon by Y axis
     * @param showOnMainChart true to show on main chart, false to show on bottom panel
     */
    public IndicatorDefinitionUserMessage(int id,
                                        String alias,
                                        String indicatorName,
                                        short mainLineStyleMask,
                                        short mainLineStyleMultiplier,
                                        int mainLineWidth,
                                        Color lineColor,
                                        short rightLineStyleMask,
                                        short rightLineStyleMultiplier,
                                        int rightLineWidth,
                                        BufferedImage icon,
                                        int iconOffsetX,
                                        int iconOffsetY,
                                        boolean showOnMainChart) {
        this(id, alias, indicatorName, mainLineStyleMask, mainLineStyleMultiplier, 
             mainLineWidth, lineColor, rightLineStyleMask, rightLineStyleMultiplier, 
             rightLineWidth, icon, iconOffsetX, iconOffsetY, showOnMainChart, null);
    }
    
    /**
     * Deprecated constructor - use the constructor with indicatorName parameter instead
     *
     * @deprecated Use IndicatorDefinitionUserMessage(int, String, String, short, short, int, Color, short, short, int, BufferedImage, int, int, boolean) instead
     */
    @Deprecated
    public IndicatorDefinitionUserMessage(int id,
                                        String alias,
                                        short mainLineStyleMask,
                                        short mainLineStyleMultiplier,
                                        int mainLineWidth,
                                        Color lineColor,
                                        short rightLineStyleMask,
                                        short rightLineStyleMultiplier,
                                        int rightLineWidth,
                                        BufferedImage icon,
                                        int iconOffsetX,
                                        int iconOffsetY,
                                        boolean showOnMainChart) {
        this(id, alias, alias, mainLineStyleMask, mainLineStyleMultiplier, 
             mainLineWidth, lineColor, rightLineStyleMask, rightLineStyleMultiplier, 
             rightLineWidth, icon, iconOffsetX, iconOffsetY, showOnMainChart, null);
    }
}