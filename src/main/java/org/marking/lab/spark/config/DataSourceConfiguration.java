package org.marking.lab.spark.config;

import javax.enterprise.inject.Produces;
import javax.sql.DataSource;

import org.aeonbits.owner.ConfigFactory;
import org.apache.commons.dbcp2.BasicDataSource;

public class DataSourceConfiguration {

	private static BasicDataSource connectionPool;
	
	public void init() {
		
		final DatabaseConfiguration configuration = ConfigFactory.create(DatabaseConfiguration.class);

		connectionPool = new BasicDataSource();
		connectionPool.setUsername(configuration.username());
		connectionPool.setPassword(configuration.password());
		connectionPool.setDriverClassName(configuration.driver());
		connectionPool.setUrl(configuration.url());
		connectionPool.setInitialSize(1);
	}
	
	
	@Produces
	public DataSource getDefaultDataSource() {
		return connectionPool;
	}
}
