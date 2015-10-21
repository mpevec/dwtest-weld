package io.dwtest.cdi;


import io.dwtest.cdi.bindings.PrettyBinding;
import io.dwtest.cdi.enums.PrettyMessageType;

/**
 * Created by pevecmi on 09/10/2015.
 */
@PrettyBinding(PrettyMessageType.LESS_PRETTY)
public class LessPrettyMessage implements Message {

	@Override
	public String getMessage() {
		return "Less Pretty Message";
	}
}
