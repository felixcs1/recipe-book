package com.bbc.news.felix.ioc;

import com.bbc.news.felix.endpoint.RecipeEndpoint;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JerseyConfig extends ResourceConfig {
    public JerseyConfig() {
        register(RecipeEndpoint.class);
    }
}
