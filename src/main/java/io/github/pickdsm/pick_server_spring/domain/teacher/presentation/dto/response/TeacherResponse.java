package io.github.pickdsm.pick_server_spring.domain.teacher.presentation.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class TeacherResponse {

	private final String name;
	private final String teacherId;

}
