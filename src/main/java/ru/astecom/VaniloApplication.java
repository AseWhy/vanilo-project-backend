package ru.astecom;

import io.github.asewhy.conversions.support.annotations.EnableConversions;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableJpaAuditing
@EnableConversions
@EnableJpaRepositories
@SpringBootApplication
@EnableAutoConfiguration
@EnableTransactionManagement
public class VaniloApplication {
    public static void main(String[] args){
        SpringApplication.run(VaniloApplication.class, args);
    }
}
