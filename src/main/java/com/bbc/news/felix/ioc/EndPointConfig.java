package com.bbc.news.felix.ioc;

import com.bbc.news.felix.controller.RecipeControllerDBImpl;
import com.bbc.news.felix.controller.RecipeControllerInterface;
import com.bbc.news.felix.endpoint.RecipeEndpoint;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

@Slf4j
@Configuration
public class EndPointConfig {

//    @Bean
//    public RecipeControllerInMemoryImpl recipeControllerInMemoryImpl() {
//        log.info("registering bean!!!!");
//        return new RecipeControllerInMemoryImpl();
//    }

    @Bean
    public RecipeControllerDBImpl recipeControllerDBImpl(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        return new RecipeControllerDBImpl(namedParameterJdbcTemplate);
    }

    @Bean
    public RecipeEndpoint recipeEndpoint(RecipeControllerInterface recipeControllerDBImpl) {
        log.info("registering DB bean!!!!");
        return new RecipeEndpoint(recipeControllerDBImpl);
    }
}
