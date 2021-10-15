package io.github.pickdsm.pick_server_spring.global.security.exception;

import io.github.pickdsm.pick_server_spring.global.error.exception.ErrorCode;
import io.github.pickdsm.pick_server_spring.global.error.exception.PickException;

public class InvalidTokenException extends PickException {

	public InvalidTokenException() {
		super(ErrorCode.INVALID_TOKEN);
	}

}
