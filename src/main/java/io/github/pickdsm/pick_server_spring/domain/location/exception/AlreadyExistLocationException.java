package io.github.pickdsm.pick_server_spring.domain.location.exception;

import io.github.pickdsm.pick_server_spring.global.error.exception.ErrorCode;
import io.github.pickdsm.pick_server_spring.global.error.exception.PickException;

public class AlreadyExistLocationException extends PickException {

    public static final PickException EXCEPTION = new AlreadyExistLocationException();

    private AlreadyExistLocationException() {
        super(ErrorCode.ALREADY_EXIST_LOCATION);
    }

}
