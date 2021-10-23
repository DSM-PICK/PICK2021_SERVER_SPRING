package io.github.pickdsm.pick_server_spring.domain.teacher.exception;

import io.github.pickdsm.pick_server_spring.global.error.exception.ErrorCode;
import io.github.pickdsm.pick_server_spring.global.error.exception.PickException;

public class AlreadyExistTeacherException extends PickException {

	public static final PickException EXCEPTION
			= new AlreadyExistTeacherException();

	private AlreadyExistTeacherException() {
		super(ErrorCode.ALREADY_EXIST_TEACHER);
	}

}
