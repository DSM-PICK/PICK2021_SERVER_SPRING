package io.github.pickdsm.pick_server_spring.global.error.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {

	ALREADY_EXIST_TEACHER(400, "Already exist teacher."),
	INVALID_CODE(401, "Invalid code."),
	CREDENTIALS_NOT_FOUND(401, "Credentials not found.");

	private final int status;
	private final String message;

}
