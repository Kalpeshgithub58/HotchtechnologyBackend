package com.hotchtechnology.configuration;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@ComponentScan
public class ConfiguartionHochtrchnology {
	
	@Value("${spring.datasource.driver-class-name}")
	private String dbdriver;
	@Value("${spring.datasource.url}")
	private String dburl;
	@Value("${spring.datasource.username}")
	private String dbusername;
	@Value("${spring.datasource.data-password}")
	private String dbpassword;
	
	@Bean
	public DataSource datasource() {
		DriverManagerDataSource datasource = new DriverManagerDataSource();
		datasource.setDriverClassName(dbdriver);
		datasource.setUrl(dburl);
		datasource.setUsername(dbusername);
		datasource.setPassword(dbpassword);

		return datasource;

	}

	@Bean
	public JdbcTemplate jdbcTemplate() {
		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		jdbcTemplate.setDataSource(datasource());
		return jdbcTemplate;

	}
}
