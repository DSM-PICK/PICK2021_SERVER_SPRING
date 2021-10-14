package io.github.pickdsm.pick_server_spring.domain.teacher.exception;

import io.github.pickdsm.pick_server_spring.global.error.exception.ErrorCode;
import io.github.pickdsm.pick_server_spring.global.error.exception.PickException;

public class InvalidCodeException extends PickException {

	public InvalidCodeException() {
		super(ErrorCode.INVALID_CODE);
	}

}
