package io.github.pickdsm.pick_server_spring.global.error.exception;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
@JsonFormat(shape = Shape.OBJECT)
public enum ErrorCode {

	EXPIRED_ACCESS_TOKEN(401, "SECURITY-401-1", "Expired access token."),
	EXPIRED_REFRESH_TOKEN(401, "SECURITY-401-2", "Expired refresh token"),
	INVALID_TOKEN(401, "SECURITY-401-3", "Invalid token."),

	INVALID_ENUM_VALUE(400, "GLOBAL-400-1", "Invalid enum value."),

	ALREADY_EXIST_TEACHER(400, "TEACHER-400-1", "Already exist teacher."),
	INVALID_CODE(401, "TEACHER-401-1", "Invalid code."),
	CREDENTIALS_NOT_FOUND(401, "TEACHER-401-2", "Credentials not found."),
	WRONG_PASSWORD(401, "TEACHER-401-3", "Wrong password."),
	TEACHER_NOT_FOUND(404, "TEACHER-404-1", "Teacher not found."),

	SCHEDULE_NOT_FOUND(404, "SCHEDULE-404-1", "Schedule not found."),
	DIRECTOR_NOT_FOUND(404, "SCHEDULE-404-2", "Director not found."),
	ALREADY_EXIST_SCHEDULE(409, "SCHEDULE-409-1", "Already exist schedule.");

	private final int status;
	private final String code;
	private final String message;

}
