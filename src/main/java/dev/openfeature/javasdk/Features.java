package dev.openfeature.javasdk;

/**
 * An API for the type-specific fetch methods offered to users.
 */
public interface Features {

    Boolean getBooleanValue(String key, Boolean defaultValue);

    Boolean getBooleanValue(String key, Boolean defaultValue, EvaluationContext ctx);

    Boolean getBooleanValue(String key, Boolean defaultValue, EvaluationContext ctx, FlagEvaluationOptions options);

    FlagEvaluationDetails<Boolean> getBooleanDetails(String key, Boolean defaultValue);

    FlagEvaluationDetails<Boolean> getBooleanDetails(String key, Boolean defaultValue, EvaluationContext ctx);

    FlagEvaluationDetails<Boolean> getBooleanDetails(String key, Boolean defaultValue, EvaluationContext ctx,
                                                     FlagEvaluationOptions options);

    String getStringValue(String key, String defaultValue);

    String getStringValue(String key, String defaultValue, EvaluationContext ctx);

    String getStringValue(String key, String defaultValue, EvaluationContext ctx, FlagEvaluationOptions options);

    FlagEvaluationDetails<String> getStringDetails(String key, String defaultValue);

    FlagEvaluationDetails<String> getStringDetails(String key, String defaultValue, EvaluationContext ctx);

    FlagEvaluationDetails<String> getStringDetails(String key, String defaultValue, EvaluationContext ctx,
                                                   FlagEvaluationOptions options);

    Integer getIntegerValue(String key, Integer defaultValue);

    Integer getIntegerValue(String key, Integer defaultValue, EvaluationContext ctx);

    Integer getIntegerValue(String key, Integer defaultValue, EvaluationContext ctx, FlagEvaluationOptions options);

    FlagEvaluationDetails<Integer> getIntegerDetails(String key, Integer defaultValue);

    FlagEvaluationDetails<Integer> getIntegerDetails(String key, Integer defaultValue, EvaluationContext ctx);

    FlagEvaluationDetails<Integer> getIntegerDetails(String key, Integer defaultValue, EvaluationContext ctx,
                                                     FlagEvaluationOptions options);

    Double getDoubleValue(String key, Double defaultValue);

    Double getDoubleValue(String key, Double defaultValue, EvaluationContext ctx);

    Double getDoubleValue(String key, Double defaultValue, EvaluationContext ctx, FlagEvaluationOptions options);

    FlagEvaluationDetails<Double> getDoubleDetails(String key, Double defaultValue);

    FlagEvaluationDetails<Double> getDoubleDetails(String key, Double defaultValue, EvaluationContext ctx);

    FlagEvaluationDetails<Double> getDoubleDetails(String key, Double defaultValue, EvaluationContext ctx,
                                                   FlagEvaluationOptions options);

    Structure getObjectValue(String key, Structure defaultValue);

    Structure getObjectValue(String key, Structure defaultValue, EvaluationContext ctx);

    Structure getObjectValue(String key, Structure defaultValue, EvaluationContext ctx,
            FlagEvaluationOptions options);

    FlagEvaluationDetails<Structure> getObjectDetails(String key, Structure defaultValue);

    FlagEvaluationDetails<Structure> getObjectDetails(String key, Structure defaultValue,
            EvaluationContext ctx);

    FlagEvaluationDetails<Structure> getObjectDetails(String key, Structure defaultValue,
            EvaluationContext ctx,
            FlagEvaluationOptions options);
}
