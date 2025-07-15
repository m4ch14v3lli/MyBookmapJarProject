package velox.api.layer1.layers.strategies.interfaces;

public enum MouseModuleScore {
    CHART_DRAG(100), 
    GRAPH_LAYERS_MODULES_MAX(90), 
    GRAPH_LAYERS_MODULES_MIN(10), 
    MAX(100), 
    MIN(0), 
    NONE(0), 
    TRADING_CLICK(80);

    public final int score;

    MouseModuleScore(int score) {
        this.score = score;
    }

    public static MouseModuleScore[] values() {
        return MouseModuleScore.values();
    }

    public static MouseModuleScore valueOf(String name) {
        return MouseModuleScore.valueOf(name);
    }
}