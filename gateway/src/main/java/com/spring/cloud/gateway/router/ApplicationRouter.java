package com.spring.cloud.gateway.router;

import com.spring.cloud.gateway.pojo.PropertiesValue;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.URI;

import static com.spring.cloud.gateway.constant.AppConstants.APP1_ROUTE;
import static com.spring.cloud.gateway.constant.AppConstants.APP2_ROUTE;
import static com.spring.cloud.gateway.constant.AppConstants.GATEWAY_ROUTE;

@Configuration
public class ApplicationRouter {

    @Bean
    public RouteLocator gatewayRoutesMarketing(RouteLocatorBuilder builder, PropertiesValue propertiesValue) {

        String firstApplicationBaseUrl = propertiesValue.firstApplicationBaseUrl;
        String firstApplicationApiBaseUrlPath = URI.create(firstApplicationBaseUrl).getPath();


        String secondApplicationBaseUrl = propertiesValue.secondApplicationBaseUrl;
        String secondApplicationApiBaseUrlPath = URI.create(secondApplicationBaseUrl).getPath();

        return builder.routes()
                .route(r -> r.path(GATEWAY_ROUTE + "/app1/v1/**")
                        .filters(f -> f.rewritePath(GATEWAY_ROUTE + APP1_ROUTE, firstApplicationApiBaseUrlPath + APP1_ROUTE))
                        .uri(firstApplicationBaseUrl))

                .route(r -> r.path(GATEWAY_ROUTE + "/app2/v2/**")
                        .filters(f -> f.rewritePath(GATEWAY_ROUTE + APP2_ROUTE, secondApplicationApiBaseUrlPath + APP2_ROUTE))
                        .uri(secondApplicationBaseUrl))

                .build();
    }
}
