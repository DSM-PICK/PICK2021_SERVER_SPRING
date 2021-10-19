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
	ALREADY_EXIST_SCHEDULE(409, "SCHEDULE-409-1", "Already exist schedule."),
	ALREADY_EXIST_DIRECTOR(409, "SCHEDULE-409-2", "Already exist director."),

	NOT_MAJOR_MEMBER(400, "MAJOR-400-1", "Not major member"),
	MAJOR_NOT_FOUND(404, "MAJOR-404-1", "Major not found."),
	ALREADY_EXIST_MAJOR_NAME(409, "MAJOR-409-1", "Already exist major name."),

	STUDENT_IS_HEAD(400, "STUDENT-400-1", "Student is head."),
	STUDENT_NOT_FOUND(404, "STUDENT-404-1", "Student not found."),

	LOCATION_NOT_FOUND(404, "LOCATION-404-1", "Location not found."),

	AFTER_SCHOOL_NOT_FOUND(404, "AFTER_SCHOOL-404-1", "After school not found."),
	ALREADY_EXIST_AFTER_SCHOOL_NAME(409, "AFTER_SCHOOL-409-1", "Already exist after school name."),
	ALREADY_EXIST_DATE_AND_LOCATION(409, "AFTER_SCHOOL-409-2", "Already exist date and location."),
	ALREADY_EXIST_STUDENT(409, "AFTER_SCHOOL-409-1", "Already exist student.");

	private final int status;
	private final String code;
	private final String message;

}
