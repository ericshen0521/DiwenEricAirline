
package com.flightsearch.appconfiguration;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class MyAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		Class arr[] = { MyApplicationConfigurationClass.class };
		return arr;
	}

	@Override
	protected String[] getServletMappings() {
		String arr[] = { "/" };
		return arr;
	}

}
