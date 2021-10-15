package io.github.pickdsm.pick_server_spring.global.security.exception;

import io.github.pickdsm.pick_server_spring.global.error.exception.ErrorCode;
import io.github.pickdsm.pick_server_spring.global.error.exception.PickException;

public class ExpiredAccessTokenException extends PickException {

	public ExpiredAccessTokenException() {
		super(ErrorCode.EXPIRED_ACCESS_TOKEN);
	}

}
