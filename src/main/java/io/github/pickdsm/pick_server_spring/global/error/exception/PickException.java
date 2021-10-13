package io.github.pickdsm.pick_server_spring.global.error.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class PickException extends RuntimeException {

	private final ErrorCode errorCode;

}
