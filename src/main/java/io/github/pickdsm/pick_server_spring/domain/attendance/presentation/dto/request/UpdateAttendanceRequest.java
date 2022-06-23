package io.github.pickdsm.pick_server_spring.domain.attendance.presentation.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UpdateAttendanceRequest {

    private Long attendanceId;
    private int period;
    private Long studentId;
    private String state;
    private Long locationId;

}
