package io.dwtest.cdi;


import io.dwtest.cdi.bindings.JustTextBinding;

/**
 * Created by pevecmi on 09/10/2015.
 */
@JustTextBinding
public class JustTextMessage implements Message {

	@Override
	public String getMessage() {
		return "Just Text Message";
	}
}
