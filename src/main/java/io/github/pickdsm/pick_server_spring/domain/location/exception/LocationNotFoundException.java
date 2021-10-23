package io.github.pickdsm.pick_server_spring.domain.location.exception;

import io.github.pickdsm.pick_server_spring.global.error.exception.ErrorCode;
import io.github.pickdsm.pick_server_spring.global.error.exception.PickException;

public class LocationNotFoundException extends PickException {

	public static final PickException EXCEPTION
			= new LocationNotFoundException();

	private LocationNotFoundException() {
		super(ErrorCode.LOCATION_NOT_FOUND);
	}

}
