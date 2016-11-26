package org.marking.lab.spark;

import spark.servlet.SparkApplication;
import static spark.Spark.*;

import org.marking.lab.spark.config.ApplicationRoutes;
import org.marking.lab.spark.config.DataSourceConfiguration;
import org.marking.lab.spark.util.cdi.CDIContext;

public class Application implements SparkApplication {

	public static void main(String[] args) {
		new Application().init();
	}

	
	@Override
	public void init() {
		final CDIContext context = CDIContext.getInstance();
		
		port(8080);
		
		DataSourceConfiguration sourceConfiguration = new DataSourceConfiguration();
		sourceConfiguration.init();
		
		ApplicationRoutes routes = context.getBean(ApplicationRoutes.class);
		routes.init();
	}
}
