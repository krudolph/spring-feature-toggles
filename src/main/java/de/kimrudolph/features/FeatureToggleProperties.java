package de.kimrudolph.features;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * Reads and maps all feature.SOME_FEATURE=true properties.
 */
@Component
@Data
@ConfigurationProperties
public class FeatureToggleProperties {

    private final Map<String, Boolean> features = new HashMap<>();

    public boolean isActive(String feature) {

        return features.getOrDefault(feature, false);
    }
}
