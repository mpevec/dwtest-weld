package io.dwtest.resources.filters;

import io.dwtest.config.DwConfigCustomReader;
import javax.inject.Inject;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.PreMatching;
import javax.ws.rs.ext.Provider;
import java.io.File;
import java.io.IOException;

/**
 * Created by pevecmi on 15/10/2015.
 */
@Provider
@PreMatching
public class ConfigReaderFilter implements ContainerRequestFilter {

	private static final File configFile = new File("config-custom.yml");

	@Inject
	private DwConfigCustomReader configReader;

	public void filter(ContainerRequestContext requestCtx) throws IOException {
		configReader.readConfig(configFile);
	}
}
