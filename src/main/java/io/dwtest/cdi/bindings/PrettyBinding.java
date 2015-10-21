package io.dwtest.cdi.bindings;

import io.dwtest.cdi.enums.PrettyMessageType;

import javax.inject.Qualifier;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by pevecmi on 08/10/2015.
 */
@Qualifier
@Target({METHOD, FIELD, PARAMETER, TYPE})
@Retention(RUNTIME)
public @interface PrettyBinding {
	PrettyMessageType value();
}
