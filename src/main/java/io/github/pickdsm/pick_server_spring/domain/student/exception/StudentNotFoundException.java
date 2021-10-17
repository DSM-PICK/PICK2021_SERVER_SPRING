package io.github.pickdsm.pick_server_spring.domain.student.exception;

import io.github.pickdsm.pick_server_spring.global.error.exception.ErrorCode;
import io.github.pickdsm.pick_server_spring.global.error.exception.PickException;

public class StudentNotFoundException extends PickException {

	public StudentNotFoundException() {
		super(ErrorCode.STUDENT_NOT_FOUND);
	}

}
