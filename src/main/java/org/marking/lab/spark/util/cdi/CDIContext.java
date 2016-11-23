package org.marking.lab.spark.util.cdi;

import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;

public class CDIContext {
	
	private static final CDIContext INSTANCE = new CDIContext();

	private final Weld weld;
	private final WeldContainer container;
	
	
	private CDIContext() {
		this.weld = new Weld();
		this.container = weld.initialize();
		Runtime.getRuntime().addShutdownHook(new Thread() {
			@Override
			public void run() {
				weld.shutdown();
			}
		});
	}
	
	public static final CDIContext getInstance() {
		return INSTANCE;
	}
	

	public <T> T getBean(Class<T> type) {
		return container.instance().select(type).get();
	}
}
