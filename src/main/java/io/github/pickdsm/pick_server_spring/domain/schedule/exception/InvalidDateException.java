package io.github.pickdsm.pick_server_spring.domain.schedule.exception;

import io.github.pickdsm.pick_server_spring.global.error.exception.ErrorCode;
import io.github.pickdsm.pick_server_spring.global.error.exception.PickException;

public class InvalidDateException extends PickException {

	public static final PickException EXCEPTION =
			new InvalidDateException();

	private InvalidDateException() {
		super(ErrorCode.INVALID_DATE);
	}

}
