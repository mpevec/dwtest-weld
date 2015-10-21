package io.dwtest.cdi;

import javax.enterprise.context.ApplicationScoped;

/**
 * Created by pevecmi on 12/10/2015.
 */
@ApplicationScoped
public class MessageSingleton implements Message {
	private int no = 0;

	@Override
	public String getMessage() {
		this.no++;
		return "Message from Singleton, no.: " + this.no;
	}
}
