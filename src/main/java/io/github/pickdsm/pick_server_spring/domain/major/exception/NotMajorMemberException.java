package io.github.pickdsm.pick_server_spring.domain.major.exception;

import io.github.pickdsm.pick_server_spring.global.error.exception.ErrorCode;
import io.github.pickdsm.pick_server_spring.global.error.exception.PickException;

public class NotMajorMemberException extends PickException {

	public static final PickException EXCEPTION
			= new NotMajorMemberException();

	private NotMajorMemberException() {
		super(ErrorCode.NOT_MAJOR_MEMBER);
	}

}
