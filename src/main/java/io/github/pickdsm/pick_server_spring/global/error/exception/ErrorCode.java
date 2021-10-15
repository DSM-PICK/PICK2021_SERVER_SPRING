package io.github.pickdsm.pick_server_spring.global.error.exception;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
@JsonFormat(shape = Shape.OBJECT)
public enum ErrorCode {

	ALREADY_EXIST_TEACHER(400, "Already exist teacher."),
	INVALID_CODE(401, "Invalid code."),
	CREDENTIALS_NOT_FOUND(401, "Credentials not found."),
	EXPIRED_ACCESS_TOKEN(401, "Expired access token."),
	INVALID_TOKEN(401, "Invalid token."),
	WRONG_PASSWORD(401, "Wrong password.");

	private final int status;
	private final String message;

}
