package io.dwtest.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.google.common.base.Optional;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import java.io.File;
import java.io.IOException;

/**
 * Created by pevecmi on 19/10/2015.
 */
@RequestScoped
public class DwConfigCustomReader {

	// http://www.tutorialspoint.com/guava/guava_optional_class.htm
	private Optional<DwConfigCustom> configOptional;


	@Produces
	public Optional<DwConfigCustom> getConfig() {
		return configOptional;
	}

	/**
	 * Reading config object from yaml in case if we dont have it yet in this request
	 * @param yamlSource
	 */
	public void readConfig(File yamlSource) {
		if(configOptional == null) {
			DwConfigCustom config = null;
			if(yamlSource.exists() && yamlSource.canRead()) {

				// https://github.com/FasterXML/jackson-dataformat-yaml
				ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
				try {
					config = mapper.readValue(yamlSource, DwConfigCustom.class);
				} catch (IOException e) {}
			}
			configOptional = Optional.fromNullable(config);
		}
	}
}
