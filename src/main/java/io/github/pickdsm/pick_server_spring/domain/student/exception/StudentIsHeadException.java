package io.github.pickdsm.pick_server_spring.domain.student.exception;

import io.github.pickdsm.pick_server_spring.global.error.exception.ErrorCode;
import io.github.pickdsm.pick_server_spring.global.error.exception.PickException;

public class StudentIsHeadException extends PickException {

	public StudentIsHeadException() {
		super(ErrorCode.STUDENT_IS_HEAD);
	}

}
