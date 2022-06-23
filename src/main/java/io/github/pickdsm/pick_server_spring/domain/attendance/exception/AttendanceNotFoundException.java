package io.github.pickdsm.pick_server_spring.domain.attendance.exception;

import io.github.pickdsm.pick_server_spring.global.error.exception.ErrorCode;
import io.github.pickdsm.pick_server_spring.global.error.exception.PickException;

public class AttendanceNotFoundException extends PickException {

    public static final PickException EXCEPTION = new AttendanceNotFoundException();

    private AttendanceNotFoundException() {
        super(ErrorCode.ATTENDANCE_NOT_FOUND);
    }


}
