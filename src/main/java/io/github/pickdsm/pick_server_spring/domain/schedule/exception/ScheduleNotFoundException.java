package io.github.pickdsm.pick_server_spring.domain.schedule.exception;

import io.github.pickdsm.pick_server_spring.global.error.exception.ErrorCode;
import io.github.pickdsm.pick_server_spring.global.error.exception.PickException;

public class ScheduleNotFoundException extends PickException {

	public static final PickException EXCEPTION
			= new ScheduleNotFoundException();

	private ScheduleNotFoundException() {
		super(ErrorCode.SCHEDULE_NOT_FOUND);
	}

}
