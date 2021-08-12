package ru.mail.java.junior.library.config;

import javax.sql.DataSource;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import liquibase.integration.spring.SpringLiquibase;

@Configuration
@EnableAutoConfiguration
@ComponentScan(basePackages = "ru.mail.java.junior.library")
@PropertySource(value = "classpath:application.properties")
@EnableTransactionManagement
@EntityScan(basePackages = "ru.mail.java.junior.library.core.domain")
@EnableJpaRepositories(value = "ru.mail.java.junior.library.core.database.jpa")
public class SpringCoreConfiguration {

	@Bean
	public SpringLiquibase springLiquibase(DataSource dataSource) {
		SpringLiquibase liquibase = new SpringLiquibase();
		liquibase.setChangeLog("classpath:/db/changelog/changelog-master.xml");
		liquibase.setShouldRun(true);
		liquibase.setDataSource(dataSource);
		return liquibase;
	}

}