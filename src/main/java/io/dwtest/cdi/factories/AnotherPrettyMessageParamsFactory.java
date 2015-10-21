package io.dwtest.cdi.factories;


import io.dwtest.cdi.Message;
import io.dwtest.cdi.enums.PrettyMessageType;
import io.dwtest.cdi.bindings.DecideProgrammaticWithParamsBinding;
import io.dwtest.cdi.bindings.DecideProgrammaticWithParamsBindingLiteral;
import io.dwtest.cdi.bindings.PrettyBindingLiteral;

import javax.enterprise.inject.Any;
import javax.enterprise.inject.Instance;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;
import javax.inject.Inject;
import java.lang.annotation.Annotation;

/**
 * Created by pevecmi on 20/10/2015.
 */
public class AnotherPrettyMessageParamsFactory {

	@Inject @Any
	private Instance<Message> message;

	@Produces
	@DecideProgrammaticWithParamsBinding
	public Message getMeSome(InjectionPoint injectionPoint) {

		int weightFromInjectionPoint = 0;
		for (Annotation annotation : injectionPoint.getQualifiers()) {
			if (annotation instanceof DecideProgrammaticWithParamsBindingLiteral) {
				weightFromInjectionPoint = ((DecideProgrammaticWithParamsBindingLiteral) annotation).getWeight();
				break;
			}
		}

		if(weightFromInjectionPoint <= 5) {
			return message.select(new PrettyBindingLiteral(PrettyMessageType.LESS_PRETTY)).get();
		}
		return message.select(new PrettyBindingLiteral(PrettyMessageType.MORE_PRETTY)).get();
	}

}
