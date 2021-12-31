package io.github.pickdsm.pick_server_spring.domain.teacher.presentation.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class TeacherScheduleResponse {

    private final List<TeacherResponseElement> teachers;

}
