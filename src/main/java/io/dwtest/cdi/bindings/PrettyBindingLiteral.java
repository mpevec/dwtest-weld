package io.dwtest.cdi.bindings;

import io.dwtest.cdi.enums.PrettyMessageType;

import javax.enterprise.util.AnnotationLiteral;

/**
 * Created by pevecmi on 20/10/2015.
 */
public class PrettyBindingLiteral extends AnnotationLiteral<PrettyBinding> implements PrettyBinding {

	private PrettyMessageType type;

	public PrettyBindingLiteral(PrettyMessageType type) {
		this.type = type;
	}

	@Override
	public PrettyMessageType value() {
		return type;
	}
}
