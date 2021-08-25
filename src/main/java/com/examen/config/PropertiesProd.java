package com.examen.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource({"classpath:prod.properties"})
@Profile("prod")
public class PropertiesProd {

}
