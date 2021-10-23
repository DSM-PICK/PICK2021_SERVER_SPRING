package io.github.pickdsm.pick_server_spring.domain.teacher.exception;

import io.github.pickdsm.pick_server_spring.global.error.exception.ErrorCode;
import io.github.pickdsm.pick_server_spring.global.error.exception.PickException;

public class WrongPasswordException extends PickException {

	public static final PickException EXCEPTION
			= new WrongPasswordException();

	private WrongPasswordException() {
		super(ErrorCode.WRONG_PASSWORD);
	}

}
