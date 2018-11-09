package de.kimrudolph.controllers;

import de.kimrudolph.features.FeatureToggle;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FeatureDemoController {

    @FeatureToggle("ORDER_CAR")
    @GetMapping("/car")
    public String car() {

        return "index";
    }

    @FeatureToggle("ORDER_SPACESHIP")
    @GetMapping("/spaceship")
    public String spaceship() {

        return "index";
    }

    @FeatureToggle("ORDER_PLANET")
    @GetMapping("/planet")
    public String planet() {

        return "index";
    }
}
