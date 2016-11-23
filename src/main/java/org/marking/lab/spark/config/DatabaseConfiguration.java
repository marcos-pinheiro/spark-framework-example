package org.marking.lab.spark.config;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.Config.Sources;

@Sources({"classpath:config.properties"})
public interface DatabaseConfiguration extends Config {
	
	@Key("db.driver")
	String driver();
	
	@Key("db.url")
	String url();
	
	@Key("db.username")
	String username();
	
	@Key("db.password")
	String password();
}
