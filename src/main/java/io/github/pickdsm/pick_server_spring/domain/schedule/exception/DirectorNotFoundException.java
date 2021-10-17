package io.github.pickdsm.pick_server_spring.domain.schedule.exception;

import io.github.pickdsm.pick_server_spring.global.error.exception.ErrorCode;
import io.github.pickdsm.pick_server_spring.global.error.exception.PickException;

public class DirectorNotFoundException extends PickException {

	public DirectorNotFoundException() {
		super(ErrorCode.DIRECTOR_NOT_FOUND);
	}

}
