## Feature Toggles

Use with thymeleaf

    <span th:if="${!feature.isActive('ORDER_SPACESHIP')}">ORDER_SPACESHIP feature is disabled</span>

or as an annotation

        @FeatureToggle("ORDER_SPACESHIP")
        @GetMapping("/spaceship")
        public String spaceship() {

            return "index";
        }

