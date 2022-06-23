package io.github.pickdsm.pick_server_spring.domain.attendance.presentation.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@NoArgsConstructor
public class PostAttendanceRequest {

    private String state;
    private Long studentId;
    private String reason;
    private String teacherId;
    private Long locationId;
    private LocalDate startDate;
    private int startPeriod;
    private LocalDate endDate;
    private int endPeriod;

}
