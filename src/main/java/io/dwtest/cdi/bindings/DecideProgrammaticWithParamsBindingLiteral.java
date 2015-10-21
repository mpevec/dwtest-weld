package io.dwtest.cdi.bindings;

import javax.enterprise.util.AnnotationLiteral;

/**
 * Created by pevecmi on 20/10/2015.
 */
public class DecideProgrammaticWithParamsBindingLiteral extends AnnotationLiteral<DecideProgrammaticWithParamsBinding> implements DecideProgrammaticWithParamsBinding {

	private int weight;

	public DecideProgrammaticWithParamsBindingLiteral(int weight) {
		this.weight = weight;
	}

	public int getWeight() {
		return weight;
	}
}
