package com.examen.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource({"classpath:qa.properties"})
@Profile("qa")
public class PropertiesQA {

}
