package org.marlabs.connection;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@Configuration
@ComponentScan(basePackages = {"org.marlabs.entities"})
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = {"org.marlabs.CommonDataRepository.*"}, 
entityManagerFactoryRef = "localContainerEntityManagerFactoryBeanCommonDB", 
transactionManagerRef = "jpaTransactionManagerCommonDB")
public class CommonDabaseConfig {
	
	@Bean(name = "dataSourceCommonDB") 
    @ConfigurationProperties(prefix="spring.ds_CommonData")
    public DataSource commonDataSource() {
        return DataSourceBuilder.create().build();
    }
    
	@Bean(name = "localContainerEntityManagerFactoryBeanCommonDB")
	LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSourceCommonDB, Environment env) {
		
		LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
		entityManagerFactoryBean.setDataSource(commonDataSource());
		JpaVendorAdapter jpaVendorAdapter = new HibernateJpaVendorAdapter();
		entityManagerFactoryBean.setJpaVendorAdapter(jpaVendorAdapter);
		entityManagerFactoryBean.setPackagesToScan("org.marlabs.entities");
		
		Properties jpaProperties = new Properties();
		
		//Configures the used database dialect. This allows Hibernate to create SQL
		//that is optimized for the used database.
		jpaProperties.put("hibernate.dialect", env.getRequiredProperty("spring.jpa.properties.hibernate.dialect"));
		
		//Specifies the action that is invoked to the database when the Hibernate
		//SessionFactory is created or closed.
		jpaProperties.put("hibernate.hbm2ddl.auto", env.getRequiredProperty("spring.jpa.hibernate.ddl-auto"));
		
		//Configures the naming strategy that is used when Hibernate creates
		//new database objects and schema elements
		jpaProperties.put("spring.jpa.hibernate.naming-strategy", env.getRequiredProperty("spring.jpa.hibernate.naming-strategy"));
		
		//If the value of this property is true, Hibernate writes all SQL
		//statements to the console.
		jpaProperties.put("hibernate.show_sql", env.getRequiredProperty("spring.jpa.show-sql"));
		
		entityManagerFactoryBean.setJpaProperties(jpaProperties);
		
		return entityManagerFactoryBean;
		}
	
	@Bean(name = "jpaTransactionManagerCommonDB")
    PlatformTransactionManager transactionManager(@Qualifier("localContainerEntityManagerFactoryBeanCommonDB") EntityManagerFactory entityManagerFactoryBeanCommonDB) {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactoryBeanCommonDB);
        return transactionManager;
    }
	
}
