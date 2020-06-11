package com.pprabhu.resttemplate.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import java.util.Arrays;
import java.util.Optional;


@Configuration
@EnableConfigurationProperties
@ConfigurationProperties()
@PropertySource("classpath:application.yml")
public class YAMLConfig implements AppConfig{

    @Autowired
    private Environment env;

    @Override
    public AppEnv getEnvironment() {
        Optional<AppEnv> optionalAppEnv = Arrays.stream(env.getActiveProfiles())
                .map(s -> AppEnv.fromString(s))
                .filter(appEnv -> appEnv.isPresent())
                .findFirst()
                .map(appEnvOptional -> appEnvOptional.get());

        return optionalAppEnv.orElse(AppEnv.dev);
    }

    @Override
    public Optional<String> getConfig(String configKey) {
        String val = env.getProperty(configKey);
        return Optional.ofNullable(val);
    }





}
