package io.github.pickdsm.pick_server_spring.domain.attendance.presentation.dto.response;

import io.github.pickdsm.pick_server_spring.domain.attendance.domain.type.State;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class QueryTodayAttendanceResponse {

    private final Long id;
    private final State state;
    private final int period;
    private final String reason;
    private final Long studentId;
    private final String name;
    private final String gcn;
    private final String teacherId;
    private final String teacherName;

}
