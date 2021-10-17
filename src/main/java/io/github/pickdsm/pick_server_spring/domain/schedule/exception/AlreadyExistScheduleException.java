package io.github.pickdsm.pick_server_spring.domain.schedule.exception;

import io.github.pickdsm.pick_server_spring.global.error.exception.ErrorCode;
import io.github.pickdsm.pick_server_spring.global.error.exception.PickException;

public class AlreadyExistScheduleException extends PickException {

	public AlreadyExistScheduleException() {
		super(ErrorCode.ALREADY_EXIST_SCHEDULE);
	}

}
