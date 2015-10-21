package io.dwtest.resources.filters;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.PreMatching;
import javax.ws.rs.ext.Provider;
import java.io.IOException;

/**
 * Created by pevecmi on 15/10/2015.
 */
@Provider
@PreMatching
public class TestFilter implements ContainerRequestFilter {



	public void filter(ContainerRequestContext requestCtx) throws IOException {
		String path = requestCtx.getUriInfo().getPath();
		System.out.println(" ------------- Filtering request path: " + path + " ----------------- ");

	}
}
