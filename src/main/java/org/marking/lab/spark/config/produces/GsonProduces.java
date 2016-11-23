package org.marking.lab.spark.config.produces;

import javax.enterprise.inject.Produces;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class GsonProduces {
	
	@Produces
	public Gson getGson() {
		
		return new GsonBuilder()
				.setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
				.serializeNulls()
				.create();
	}
	
}
