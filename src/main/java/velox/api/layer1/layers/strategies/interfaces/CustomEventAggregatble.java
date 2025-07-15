package velox.api.layer1.layers.strategies.interfaces;

public interface CustomEventAggregatble {

    void aggregateAggregationWithAggregation(CustomGeneratedEvent aggregation1, CustomGeneratedEvent aggregation2);

    void aggregateAggregationWithValue(CustomGeneratedEvent aggregation, CustomGeneratedEvent value);

    CustomGeneratedEvent getInitialValue(long t);
}