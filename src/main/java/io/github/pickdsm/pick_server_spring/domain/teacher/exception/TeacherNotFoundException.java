package io.github.pickdsm.pick_server_spring.domain.teacher.exception;

import io.github.pickdsm.pick_server_spring.global.error.exception.ErrorCode;
import io.github.pickdsm.pick_server_spring.global.error.exception.PickException;

public class TeacherNotFoundException extends PickException {

	public TeacherNotFoundException() {
		super(ErrorCode.TEACHER_NOT_FOUND);
	}

}