package io.dwtest.cdi;


import io.dwtest.cdi.bindings.PrettyBinding;
import io.dwtest.cdi.enums.PrettyMessageType;

/**
 * Created by pevecmi on 09/10/2015.
 */
@PrettyBinding(PrettyMessageType.MORE_PRETTY)
public class MorePrettyMessage implements Message {

	@Override
	public String getMessage() {
		return "More Pretty Message";
	}
}
