package io.github.pickdsm.pick_server_spring.domain.affiliated_after_school.exception;

import io.github.pickdsm.pick_server_spring.global.error.exception.ErrorCode;
import io.github.pickdsm.pick_server_spring.global.error.exception.PickException;

public class AlreadyExistStudentException extends PickException {

	public static final PickException EXCEPTION
			= new AlreadyExistStudentException();

	private AlreadyExistStudentException() {
		super(ErrorCode.ALREADY_EXIST_STUDENT);
	}

}
