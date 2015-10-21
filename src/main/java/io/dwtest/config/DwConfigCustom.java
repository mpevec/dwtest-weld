package io.dwtest.config;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.NotEmpty;
import javax.validation.Valid;

/**
 * Created by pevecmi on 07/10/2015.
 */
public class DwConfigCustom {

	@NotEmpty
	@JsonProperty
	private String parameter1;

	@Valid
	private DwConfigCustomMessages messages;

	public String getParameter1() {
		return parameter1;
	}

	public void setParameter1(String parameter1) {
		this.parameter1 = parameter1;
	}

	public DwConfigCustomMessages getMessages() {
		return messages;
	}

	public void setMessages(DwConfigCustomMessages messages) {
		this.messages = messages;
	}
}

