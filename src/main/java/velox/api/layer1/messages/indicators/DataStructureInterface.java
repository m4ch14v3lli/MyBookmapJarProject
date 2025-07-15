package velox.api.layer1.messages.indicators;

import java.util.ArrayList;
import java.util.List;

public interface DataStructureInterface {

    enum StandardEvents {
        // Define standard events here
    }

    class TreeResponseInterval {
        // Define properties and methods for TreeResponseInterval
    }

    ArrayList<TreeResponseInterval> get(long t0, long intervalWidth, int intervalNumber, String alias, StandardEvents[] interestedEvents);

    TreeResponseInterval get(long t1, String alias, StandardEvents[] interestedEvents);

    List<TreeResponseInterval> get(Class<?> strategyClass, String generatorName, long t0, long intervalWidth, int intervalNumber, String alias, Class<?>[] customEvents);

    List<Object> get(Class<?> strategyClass, String generatorName, long t0, long t1, String alias) throws IllegalArgumentException;

    List<? extends CustomGeneratedEvent> get(Class<?> strategyClass, String generatorName, long t1, String alias);
}