package io.dwtest.resources;

import com.google.common.base.Optional;
import io.dwtest.cdi.Message;
import io.dwtest.cdi.MessageSingleton;
import io.dwtest.cdi.bindings.*;
import io.dwtest.cdi.enums.PrettyMessageType;
import io.dwtest.config.DwConfigCustom;
import javax.enterprise.inject.Instance;
import javax.inject.Inject;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.io.IOException;

/**
 * Created by pevecmi on 07/10/2015.
 */
@Path("dwtest")
public class DwTestResource {

	@Inject
	private MessageSingleton singleton;

	@Inject
	private Optional<DwConfigCustom> config;

	@Inject @JustTextBinding
	private Message justTextMessage;

	@Inject @PrettyBinding(PrettyMessageType.LESS_PRETTY)
	private Message lessPrettyMessage;

	@Inject @PrettyBinding(PrettyMessageType.MORE_PRETTY)
	private Message morePrettyMessage;

	@Inject @DecideBinding
	private Message decidedMessage;

	@Inject @DecideProgrammaticBinding
	private Message decidedProgrammaticMessage;

	@Inject @DecideProgrammaticWithParamsBinding
	private Instance<Message> decidedProgrammaticWithParamsMessage;

	// CDI - I.
	@GET
	@Path("justtm")
	@Produces(MediaType.TEXT_PLAIN)
	public String justTextMessage() {
		return justTextMessage.getMessage();
	}

	// CDI - II.
	@GET
	@Path("lessp")
	@Produces(MediaType.TEXT_PLAIN)
	public String lessPrettyMessage() {
		return lessPrettyMessage.getMessage();
	}

	// CDI - III.
	@GET
	@Path("morep")
	@Produces(MediaType.TEXT_PLAIN)
	public String morePrettyMessage() {
		return morePrettyMessage.getMessage();
	}

	// CDI - IV.
	@GET
	@Path("decided")
	@Produces(MediaType.TEXT_PLAIN)
	public String decidedMessage() {
		return decidedMessage.getMessage();
	}

	// CDI - V.
	@GET
	@Path("decidedp")
	@Produces(MediaType.TEXT_PLAIN)
	public String decidedpMessage() {
		return decidedProgrammaticMessage.getMessage();
	}

	// CDI - VI.
	@GET
	@Path("decidedpp")
	@Produces(MediaType.TEXT_PLAIN)
	public String decidedppMessage() {
		int anyWeightLessThan5 = 3;
		Message msg = decidedProgrammaticWithParamsMessage.select(new DecideProgrammaticWithParamsBindingLiteral(anyWeightLessThan5)).get();
		return msg.getMessage();
	}

	// CDI - Request scoped, producer configuration
	@GET
	@Path("config")
	@Produces(MediaType.TEXT_PLAIN)
	public String config() throws IOException {
		if (config.isPresent()) {
			return "Configuration param1: " + config.get().getParameter1();
		}
		return "Unknown Configuration!";
	}

	// CDI - Singleton
	@GET
	@Path("singleton")
	@Produces(MediaType.TEXT_PLAIN)
	public String singleton() {
		return singleton.getMessage();
	}

	// JAX-RS Exception Mapper test
	@GET
	@Path("exc")
	@Produces(MediaType.TEXT_PLAIN)
	public String exc() {
		if (4 < 5) {
			throw new RuntimeException("test exception");
		}
		return "";
	}

	// JSR353 STUFF - I
	@GET
	@Path("type")
	@Produces(MediaType.APPLICATION_JSON)
	public JsonObject testJsr353() {
		return Json.createObjectBuilder().add("firstName", "any first name").build();
	}

	// JSR353 STUFF - II
	@GET
	@Path("typea")
	@Produces(MediaType.APPLICATION_JSON)
	public JsonArray testJsr353Array() {
		JsonObject json = Json.createObjectBuilder().add("firstName", "any first name").build();
		return Json.createArrayBuilder().add(json).build();
	}
}
