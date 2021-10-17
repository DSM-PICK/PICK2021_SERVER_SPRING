package io.github.pickdsm.pick_server_spring.domain.after_school.exception;

import io.github.pickdsm.pick_server_spring.global.error.exception.ErrorCode;
import io.github.pickdsm.pick_server_spring.global.error.exception.PickException;

public class AlreadyExistAfterSchoolNameException extends PickException {

	public AlreadyExistAfterSchoolNameException() {
		super(ErrorCode.ALREADY_EXIST_AFTER_SCHOOL_NAME);
	}

}
