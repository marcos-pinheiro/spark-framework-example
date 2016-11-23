package org.marking.lab.spark.config.produces;

import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.sql.DataSource;

import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;

public class JooqProduces {
	
	@Inject
	private DataSource dataSource;
	
	@Produces
	public DSLContext getDSLContext() {
		return DSL.using(dataSource, SQLDialect.MYSQL);
	}
}
