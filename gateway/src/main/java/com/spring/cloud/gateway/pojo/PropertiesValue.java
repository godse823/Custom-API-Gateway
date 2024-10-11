package com.spring.cloud.gateway.pojo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
public class PropertiesValue {
    @Value("${application1.baseUrl}")
    public String firstApplicationBaseUrl;
    @Value("${application1.baseUrl}")
    public String secondApplicationBaseUrl;

}
