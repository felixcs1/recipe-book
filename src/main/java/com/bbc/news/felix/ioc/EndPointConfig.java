package com.bbc.news.felix.ioc;

import com.bbc.news.felix.controller.RecipeControllerInMemoryImpl;
import com.bbc.news.felix.controller.RecipeControllerInterface;
import com.bbc.news.felix.endpoint.RecipeEndpoint;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
public class EndPointConfig {

    @Bean
    public RecipeControllerInMemoryImpl recipeControllerInMemoryImpl() {
        log.info("registering bean!!!!");
        return new RecipeControllerInMemoryImpl();
    }

    @Bean
    public RecipeEndpoint recipeEndpoint(RecipeControllerInterface recipeControllerInMemoryImpl) {
        log.info("registering bean!!!!");
        return new RecipeEndpoint(recipeControllerInMemoryImpl);
    }

    @Bean
    public String testBean() {
        log.info("registering test bean!!!!");
        return "HELLO";
    }
}
