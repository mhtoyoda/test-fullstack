package com.test.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
@ConfigurationProperties(prefix = "parameters.datasource")
public class DatabaseConfig extends HikariConfig {

    @Bean
    public DataSource dataSource(){
        return new HikariDataSource(this);
    }
}
