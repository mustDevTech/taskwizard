package com.example.taskwizard.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;

/**
 * Configuration class for setting up DataSource bean
 * Used for configuring database connection properties
 */
@Configuration
@PropertySource("classpath:application.yml")
public class DataBaseConfig {
    @Value("${spring.datasource.url}")
    private String dbHost;

    @Value("${spring.datasource.username}")
    private String dbUsername;

    @Value("${spring.datasource.password}")
    private String dbPassword;

    @Value("${spring.datasource.driver-class-name}")
    private String dbDriver;

    /**
     * Method to configure and provide DataSource bean
     * @return DataSource bean configured with properties
     */
    @Bean
    public DataSource getDataSource() {
        return DataSourceBuilder.create()
                .url(dbHost)
                .username(dbUsername)
                .password(dbPassword)
                .driverClassName(dbDriver)
                .build();
    }
}