package com.example.springjpauuidconverter;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.io.IOException;

@SpringBootApplication
@EnableJpaRepositories
@EntityScan
public class SpringJpaUuidConverterApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringJpaUuidConverterApplication.class, args);
    }


    @Bean
    public DataSource dataSource() throws IOException {
        return DataSourceBuilder.create()
                .driverClassName("org.h2.Driver")
                .url("jdbc:h2:mem:testDB;DB_CLOSE_DELAY=-1")
                .username("sa")
                .password("sa")
                .build();
    }

    private static class DBInfo {
        public String url;
        public String username;
        public String password;
    }
}
