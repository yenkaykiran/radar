package com.rest.get;

import java.util.Set;
import java.util.HashSet;
import javax.ws.rs.core.Application;

public class RadarRestApplication extends Application {

	private Set<Object> singletons = new HashSet<Object>();
	private Set<Class<?>> empty = new HashSet<Class<?>>();
	public RadarRestApplication(){
	     singletons.add(new GetAllHosts());
	}
	@Override
	public Set<Class<?>> getClasses() {
	     return empty;
	}
	@Override
	public Set<Object> getSingletons() {
	     return singletons;
	}
}
