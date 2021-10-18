package io.github.pickdsm.pick_server_spring.domain.after_school.exception;

import io.github.pickdsm.pick_server_spring.global.error.exception.ErrorCode;
import io.github.pickdsm.pick_server_spring.global.error.exception.PickException;

public class AfterSchoolNotFoundException extends PickException {

	public AfterSchoolNotFoundException() {
		super(ErrorCode.AFTER_SCHOOL_NOT_FOUND);
	}

}
