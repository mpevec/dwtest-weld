package io.dwtest;

import com.fasterxml.jackson.datatype.jsr353.JSR353Module;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import io.dwtest.config.DwConfiguration;
import io.dwtest.config.WeldBundle;
import io.dwtest.resources.DwTestResource;
import io.dwtest.resources.filters.ConfigReaderFilter;
import io.dwtest.resources.filters.TestFilter;
import io.dwtest.resources.mappers.RuntimeExceptionMapper;


/**
 * Created by pevecmi on 07/10/2015.
 */
public class DwTestApplication extends Application<DwConfiguration> {

	public static void main(String[] args) throws Exception {
		new DwTestApplication().run(args);
	}

	@Override
	public void initialize(Bootstrap<DwConfiguration> bootstrap) {

		// Jackson transformations for data of type JSR-353 (https://github.com/FasterXML/jackson-datatype-jsr353)
		bootstrap.getObjectMapper().registerModule(new JSR353Module());

		// Weld (CDI) support
		bootstrap.addBundle(new WeldBundle());
	}

	@Override
	public void run(DwConfiguration config, Environment environment) throws Exception {
		environment.jersey().register(RuntimeExceptionMapper.class);
		environment.jersey().register(ConfigReaderFilter.class);
		environment.jersey().register(TestFilter.class);
		environment.jersey().register(DwTestResource.class);
	}
}
