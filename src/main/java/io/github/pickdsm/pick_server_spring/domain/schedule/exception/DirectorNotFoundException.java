package io.github.pickdsm.pick_server_spring.domain.schedule.exception;

import io.github.pickdsm.pick_server_spring.global.error.exception.ErrorCode;
import io.github.pickdsm.pick_server_spring.global.error.exception.PickException;

public class DirectorNotFoundException extends PickException {

	public static final PickException EXCEPTION
			= new DirectorNotFoundException();

	private DirectorNotFoundException() {
		super(ErrorCode.DIRECTOR_NOT_FOUND);
	}

}
