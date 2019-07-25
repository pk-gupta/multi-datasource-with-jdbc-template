package org.marlabs.connection;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties; 
import org.springframework.context.annotation.Bean; 
import org.springframework.context.annotation.Configuration; 
import org.springframework.jdbc.core.JdbcTemplate; 
import javax.sql.DataSource; 

@Configuration 
public class IISDabaseConfig{ 
	
	@Bean(name = "dataSourceIIS") 
    @ConfigurationProperties(prefix="spring.ds_IIS")
    public DataSource iisDataSource() {
        return DataSourceBuilder.create().build();
    }
    @Bean(name = "jdbcIIS") 
    public JdbcTemplate jdbcTemplate(DataSource dataSourceIIS) { 
        return new JdbcTemplate(dataSourceIIS); 
    } 
}
