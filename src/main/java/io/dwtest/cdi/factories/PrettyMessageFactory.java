package io.dwtest.cdi.factories;


import io.dwtest.cdi.Message;
import io.dwtest.cdi.enums.PrettyMessageType;
import io.dwtest.cdi.bindings.DecideBinding;
import io.dwtest.cdi.bindings.PrettyBinding;

import javax.enterprise.inject.Instance;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import java.util.Random;

/**
 * Created by pevecmi on 20/10/2015.
 */
public class PrettyMessageFactory {

	@Inject @PrettyBinding(PrettyMessageType.LESS_PRETTY)
	private Instance<Message> lessPrettyMessage;

	@Inject @PrettyBinding(PrettyMessageType.MORE_PRETTY)
	private Instance<Message> morePrettyMessage;

	@Produces
	@DecideBinding
	public Message getMeSome() {
		Random random = new Random();
		if(random.nextInt(11) <= 5) {
			return lessPrettyMessage.get();
		}
		return morePrettyMessage.get();
	}

}
