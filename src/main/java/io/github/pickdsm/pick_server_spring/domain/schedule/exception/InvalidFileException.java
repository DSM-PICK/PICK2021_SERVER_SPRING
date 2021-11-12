package io.github.pickdsm.pick_server_spring.domain.schedule.exception;

import io.github.pickdsm.pick_server_spring.global.error.exception.ErrorCode;
import io.github.pickdsm.pick_server_spring.global.error.exception.PickException;

public class InvalidFileException extends PickException {

	public static final PickException EXCEPTION =
			new InvalidFileException();

	private InvalidFileException() {
		super(ErrorCode.INVALID_FILE);
	}

}
