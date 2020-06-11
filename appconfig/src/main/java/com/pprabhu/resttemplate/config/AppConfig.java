package com.pprabhu.resttemplate.config;

import java.util.Arrays;
import java.util.Optional;

public interface AppConfig {

    enum AppEnv {
        dev, qa, stage, prod;

        public static Optional<AppEnv> fromString(String potentialAppEnv) {
            return Arrays.stream(AppEnv.values())
                    .filter( appEnv -> appEnv.name().equalsIgnoreCase(potentialAppEnv))
                    .findFirst();
        }

    }

    AppEnv getEnvironment();

    Optional<String> getConfig(String configKey);
}
