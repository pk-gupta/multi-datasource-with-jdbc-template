package org.marlabs.commonDatabaseScheduler;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class,DataSourceTransactionManagerAutoConfiguration.class})
@Configuration 
@ComponentScan(basePackages = {"org.marlabs.*"})
@PropertySource({"classpath:application.properties"})
@SpringBootApplication
public class CommonDatabaseApplication {

    public static void main(String[] args) {
        SpringApplication.run(CommonDatabaseApplication.class, args);
    }
}
