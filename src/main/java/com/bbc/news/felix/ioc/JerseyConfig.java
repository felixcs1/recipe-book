package com.bbc.news.felix.ioc;

import com.bbc.news.felix.endpoint.RecipeEndpoint;
import lombok.extern.slf4j.Slf4j;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
public class JerseyConfig extends ResourceConfig {
    public JerseyConfig(RecipeEndpoint recipeEndpoint) {
        register(recipeEndpoint);
    }
}
