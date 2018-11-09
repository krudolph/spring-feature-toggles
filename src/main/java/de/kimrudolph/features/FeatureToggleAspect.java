package de.kimrudolph.features;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * Checks and verifies the @FeatureToggle annotation.
 */
@Aspect
@Component
public class FeatureToggleAspect {

    @Autowired
    FeatureToggleProperties featureToggleProperties;

    @Before("@annotation(FeatureToggle)")
    public void checkFeature(JoinPoint joinPoint) throws Exception {

        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();

        FeatureToggle toggle = method.getAnnotation(FeatureToggle.class);

        String feature = toggle.value();
        if (!featureToggleProperties.isActive(feature)) {
            throw new FeatureNotActiveException(
                    "Feature '" + feature + "' is not active!");
        }

    }
}
