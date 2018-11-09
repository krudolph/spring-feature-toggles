package de.kimrudolph.features;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.BAD_REQUEST, reason="Feature is not active!")
public class FeatureNotActiveException extends Exception {

    public FeatureNotActiveException(final String message) {

        super(message);
    }
}
