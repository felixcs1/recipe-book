package com.bbc.news.felix.ioc;

import com.bbc.news.felix.RecipeEndpoint;
import com.bbc.news.felix.controller.RecipeController;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JerseyConfig extends ResourceConfig {
    public JerseyConfig() {
        register(RecipeEndpoint.class);
    }
}
