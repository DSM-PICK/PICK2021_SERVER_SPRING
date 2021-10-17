package io.github.pickdsm.pick_server_spring.domain.major.exception;

import io.github.pickdsm.pick_server_spring.global.error.exception.ErrorCode;
import io.github.pickdsm.pick_server_spring.global.error.exception.PickException;

public class MajorNotFoundException extends PickException {

	public MajorNotFoundException() {
		super(ErrorCode.MAJOR_NOT_FOUND);
	}

}
