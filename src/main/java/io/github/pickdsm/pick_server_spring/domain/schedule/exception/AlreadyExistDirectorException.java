package io.github.pickdsm.pick_server_spring.domain.schedule.exception;

import io.github.pickdsm.pick_server_spring.global.error.exception.ErrorCode;
import io.github.pickdsm.pick_server_spring.global.error.exception.PickException;

public class AlreadyExistDirectorException extends PickException {

	public static final PickException EXCEPTION
			= new AlreadyExistDirectorException();

	private AlreadyExistDirectorException() {
		super(ErrorCode.ALREADY_EXIST_DIRECTOR);
	}

}
