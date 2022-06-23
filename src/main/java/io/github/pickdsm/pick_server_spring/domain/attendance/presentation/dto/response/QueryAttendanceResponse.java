package io.github.pickdsm.pick_server_spring.domain.attendance.presentation.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class QueryAttendanceResponse {

    private final String schedule;
    private final String locationName;
    private final String className;
    private final String headName;
    private final List<StudentInfo> studentList;

}
