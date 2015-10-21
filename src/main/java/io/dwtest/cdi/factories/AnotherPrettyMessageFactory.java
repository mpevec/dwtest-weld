package io.dwtest.cdi.factories;


import io.dwtest.cdi.Message;
import io.dwtest.cdi.enums.PrettyMessageType;
import io.dwtest.cdi.bindings.DecideProgrammaticBinding;
import io.dwtest.cdi.bindings.PrettyBindingLiteral;

import javax.enterprise.inject.Any;
import javax.enterprise.inject.Instance;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import java.util.Random;

/**
 * Created by pevecmi on 20/10/2015.
 */
public class AnotherPrettyMessageFactory {

	@Inject @Any
	private Instance<Message> message;

	@Produces
	@DecideProgrammaticBinding
	public Message getMeSome() {
		Random random = new Random();
		if(random.nextInt(11) <= 5) {
			return message.select(new PrettyBindingLiteral(PrettyMessageType.LESS_PRETTY)).get();
		}
		return message.select(new PrettyBindingLiteral(PrettyMessageType.MORE_PRETTY)).get();
	}

}
