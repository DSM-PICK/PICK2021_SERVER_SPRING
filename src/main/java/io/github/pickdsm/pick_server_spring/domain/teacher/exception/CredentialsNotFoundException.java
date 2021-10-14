package io.github.pickdsm.pick_server_spring.domain.teacher.exception;

import io.github.pickdsm.pick_server_spring.global.error.exception.ErrorCode;
import io.github.pickdsm.pick_server_spring.global.error.exception.PickException;

public class CredentialsNotFoundException extends PickException {

	public CredentialsNotFoundException() {
		super(ErrorCode.CREDENTIALS_NOT_FOUND);
	}

}
