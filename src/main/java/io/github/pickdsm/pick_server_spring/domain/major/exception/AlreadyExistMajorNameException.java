package io.github.pickdsm.pick_server_spring.domain.major.exception;

import io.github.pickdsm.pick_server_spring.global.error.exception.ErrorCode;
import io.github.pickdsm.pick_server_spring.global.error.exception.PickException;

public class AlreadyExistMajorNameException extends PickException {

	public static final PickException EXCEPTION
			= new AlreadyExistMajorNameException();

	private AlreadyExistMajorNameException() {
		super(ErrorCode.ALREADY_EXIST_MAJOR_NAME);
	}

}
