package com.pprabhu.resttemplate.restapi.config;


import com.pprabhu.resttemplate.config.AppConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class ConfigResource {

    @Autowired
    AppConfig appConfig;

    @GetMapping("/config")
    public ResponseEntity<ConfigEntry> getConfig(@RequestParam("key") String key ) {
        if(appConfig.getEnvironment() == AppConfig.AppEnv.prod) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }
        if(key==null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        Optional<String> configValue = appConfig.getConfig(key);
        if(configValue.isPresent()) {
            ConfigEntry configEntry = new ConfigEntry(key, configValue.get());
            return ResponseEntity.ok(configEntry);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/config/env")
    public String getEnv() {
        return appConfig.getEnvironment().toString();
    }

}
