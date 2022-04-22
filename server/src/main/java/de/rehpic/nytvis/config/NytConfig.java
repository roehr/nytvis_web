package de.rehpic.nytvis.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration("nytConfig")
@EnableConfigurationProperties
@ConfigurationProperties("nyt")
public class NytConfig {
    private String token;

    public String getToken() {
        return token;
    }
    public void setToken(String token) {
        this.token = token;
    }

}
