package com.keyin;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.util.Optional;

@Configuration
public class DatabaseConfig {

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(Optional.ofNullable(System.getenv("DB_DRIVER")).orElse("org.postgresql.Driver"));
        dataSource.setUrl(Optional.ofNullable(System.getenv("DB_URL")).orElse("jdbc:postgresql://localhost:5432/My_Florida_Library"));
        dataSource.setUsername(Optional.ofNullable(System.getenv("DB_USERNAME")).orElse("postgres"));
        dataSource.setPassword(Optional.ofNullable(System.getenv("DB_PASSWORD")).orElse("password"));
        return dataSource;
    }
    @Service
    public class BookService {

        private final DataSource dataSource;

        @Autowired
        public BookService(DataSource dataSource) {
            this.dataSource = dataSource;
        }}
        }
