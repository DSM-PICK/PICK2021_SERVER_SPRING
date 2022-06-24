package io.github.pickdsm.pick_server_spring.domain.attendance.presentation.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@NoArgsConstructor
public class QueryAttendanceRequest {

    private LocalDate date;

}
