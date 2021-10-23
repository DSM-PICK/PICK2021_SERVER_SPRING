package io.github.pickdsm.pick_server_spring.domain.student.exception;

import io.github.pickdsm.pick_server_spring.domain.teacher.exception.AlreadyExistTeacherException;
import io.github.pickdsm.pick_server_spring.global.error.exception.ErrorCode;
import io.github.pickdsm.pick_server_spring.global.error.exception.PickException;

public class StudentIsHeadException extends PickException {

	public static final PickException EXCEPTION
			= new StudentIsHeadException();

	private StudentIsHeadException() {
		super(ErrorCode.STUDENT_IS_HEAD);
	}

}
