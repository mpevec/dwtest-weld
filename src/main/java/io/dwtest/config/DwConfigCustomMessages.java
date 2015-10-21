package io.dwtest.config;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * Created by pevecmi on 08/10/2015.
 */
public class DwConfigCustomMessages {

	@NotEmpty
	private String message1;

	@NotEmpty
	private String message2;

	@NotEmpty
	private String message3;

	@NotEmpty
	private String message4;

	public String getMessage1() {
		return message1;
	}

	public void setMessage1(String message1) {
		this.message1 = message1;
	}

	public String getMessage2() {
		return message2;
	}

	public void setMessage2(String message2) {
		this.message2 = message2;
	}

	public String getMessage3() {
		return message3;
	}

	public void setMessage3(String message3) {
		this.message3 = message3;
	}

	public String getMessage4() {
		return message4;
	}

	public void setMessage4(String message4) {
		this.message4 = message4;
	}
}
