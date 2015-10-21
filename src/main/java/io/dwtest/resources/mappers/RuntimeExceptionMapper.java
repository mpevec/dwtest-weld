package io.dwtest.resources.mappers;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 * Created by pevecmi on 15/10/2015.
 */
@Provider
public class RuntimeExceptionMapper implements ExceptionMapper<RuntimeException> {

	@Override
	public Response toResponse(RuntimeException e) {
		e.printStackTrace();
		return Response.status(Response.Status.BAD_REQUEST).header("x-exception", e.getMessage()).build();
	}
}