package io.github.pickdsm.pick_server_spring.domain.teacher.presentation.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class TeacherResponseElement {
    private final String teacherId;
    private final String teacherName;
    private final int floor;
}