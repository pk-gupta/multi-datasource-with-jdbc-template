package org.marlabs.connection;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties; 
import org.springframework.context.annotation.Bean; 
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate; 
import javax.sql.DataSource; 

@Configuration 
public class HRISDatabaseConfig{ 
	@Primary
    @Bean(name = "dataSourceHRIS") 
    @ConfigurationProperties(prefix="spring.ds_HRIS")
    public DataSource hrisDataSource() {
        return DataSourceBuilder.create().build();
    }
	@Primary
    @Qualifier("dataSourceHRIS")
    @Bean(name = "jdbcHRIS") 
    public JdbcTemplate jdbcTemplate(DataSource dataSourceHRIS) { 
        return new JdbcTemplate(dataSourceHRIS); 
    } 
} 

