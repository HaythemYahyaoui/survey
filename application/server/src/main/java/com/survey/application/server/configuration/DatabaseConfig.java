package com.survey.application.server.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.sql.DataSource;


@Configuration
@EnableJpaRepositories("com.survey.application.infrastructure")
@EntityScan("com.survey.application.infrastructure")
public class DatabaseConfig {

    @Value( "${com.survey.infrastructure.database.url}" )
    private String url;

    @Value( "${com.survey.infrastructure.database.username}" )
    private String username;

    @Value( "${com.survey.infrastructure.database.password}" )
    private String password;

    @Bean(name = "surveyDataSource")
    public DataSource surveyDataSource()
    {
        DataSourceBuilder<?> dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.url(url);
        dataSourceBuilder.username(username);
        dataSourceBuilder.password(password);
        return dataSourceBuilder.build();
    }

}
