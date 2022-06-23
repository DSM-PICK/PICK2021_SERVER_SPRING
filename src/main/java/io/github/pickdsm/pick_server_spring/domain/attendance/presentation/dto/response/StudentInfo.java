package io.github.pickdsm.pick_server_spring.domain.attendance.presentation.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class StudentInfo {

    private final String gcn;
    private final Long id;
    private final String name;
    private final List<StudentAttendance> studentAttendance;

}
