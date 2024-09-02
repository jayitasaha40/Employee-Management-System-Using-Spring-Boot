package com.coding.jayita.learn.Configuration;

import org.modelmapper.ModelMapper;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.coding.jayita.learn.DB;
import com.coding.jayita.learn.DevDB;
import com.coding.jayita.learn.ProdDB;

@Configuration
public class AppConfig {

    @Bean //Supplies Instances
    @ConditionalOnProperty(name = "project.mode", havingValue = "production")
    public DB prodDB()
    {
        return new ProdDB();
    }

    @Bean
    @ConditionalOnProperty(name = "project.mode", havingValue = "development")
    public DB devDb()
    {
        return new DevDB();
    }

    @Bean
    public ModelMapper getModelMapper()
    {
        return new ModelMapper();
    }
}
