package io.github.pickdsm.pick_server_spring.domain.after_school.exception;

import io.github.pickdsm.pick_server_spring.domain.teacher.exception.AlreadyExistTeacherException;
import io.github.pickdsm.pick_server_spring.global.error.exception.ErrorCode;
import io.github.pickdsm.pick_server_spring.global.error.exception.PickException;

public class AlreadyExistDateAndLocationException extends PickException {

	public static final PickException EXCEPTION
			= new AlreadyExistDateAndLocationException();

	private AlreadyExistDateAndLocationException() {
		super(ErrorCode.ALREADY_EXIST_DATE_AND_LOCATION);
	}

}
