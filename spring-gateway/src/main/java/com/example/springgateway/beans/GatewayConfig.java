package com.example.springgateway.beans;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class GatewayConfig {

    @Bean
    @Profile(value = "eureka-off")
    public RouteLocator routeLocatorEurekaOff(RouteLocatorBuilder routeLocatorBuilder) {
        return routeLocatorBuilder
                .routes()
                .route(route ->
                        route.path("/companies-crud/api/v1/company/**")
                                .uri("http://localhost:8080")
                )
                .route(route ->
                        route.path("/report-ms/api/v1/report/**")
                                .uri("http://localhost:7070")
                ).build();
    }

    @Bean
    @Profile(value = "eureka-on")
    public RouteLocator routeLocatorEurekaOn(RouteLocatorBuilder routeLocatorBuilder) {
        return routeLocatorBuilder
                .routes()
                .route(route ->
                        route.path("/companies-crud/api/v1/company/**")
                                .uri("lb://companies-crud-ms") // * Nombre del ms
                )
                .route(route ->
                        route.path("/report-ms/api/v1/report/**")
                                .uri("lb://report-ms") // * Nombre del ms
                ).build();
    }
}


