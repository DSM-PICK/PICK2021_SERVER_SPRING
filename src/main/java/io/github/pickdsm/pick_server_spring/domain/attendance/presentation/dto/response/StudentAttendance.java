package io.github.pickdsm.pick_server_spring.domain.attendance.presentation.dto.response;

import io.github.pickdsm.pick_server_spring.domain.attendance.domain.type.State;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class StudentAttendance {

    private final int period;
    private final String locationName;
    private final State state;

}
