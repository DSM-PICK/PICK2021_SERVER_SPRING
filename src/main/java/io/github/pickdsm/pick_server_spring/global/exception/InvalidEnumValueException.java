package io.github.pickdsm.pick_server_spring.global.exception;

import io.github.pickdsm.pick_server_spring.global.error.exception.ErrorCode;
import io.github.pickdsm.pick_server_spring.global.error.exception.PickException;

public class InvalidEnumValueException extends PickException {

	public static final PickException EXCEPTION
			= new InvalidEnumValueException();

	private InvalidEnumValueException() {
		super(ErrorCode.INVALID_ENUM_VALUE);
	}

}
