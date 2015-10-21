package io.dwtest.config;

import io.dropwizard.Bundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.jboss.weld.environment.servlet.BeanManagerResourceBindingListener;
import org.jboss.weld.environment.servlet.Listener;

/**
 * Created by pevecmi on 19/10/2015.
 */
public class WeldBundle implements Bundle {

	@Override
	public void initialize(Bootstrap<?> bootstrap) {
	}

	@Override
	public void run(Environment environment) {
		environment.getApplicationContext().addEventListener(new BeanManagerResourceBindingListener());
		environment.getApplicationContext().addEventListener(new Listener());
	}
}
