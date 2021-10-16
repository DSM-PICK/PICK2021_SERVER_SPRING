package io.github.pickdsm.pick_server_spring.global.security.exception;

import io.github.pickdsm.pick_server_spring.global.error.exception.ErrorCode;
import io.github.pickdsm.pick_server_spring.global.error.exception.PickException;

public class ExpiredRefreshTokenException extends PickException {

	public ExpiredRefreshTokenException() {
		super(ErrorCode.EXPIRED_REFRESH_TOKEN);
	}

}
