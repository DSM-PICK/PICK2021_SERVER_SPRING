package io.github.pickdsm.pick_server_spring.domain.teacher.presentation.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class StudentResponse {

	private final Long id;
	private final String gcn;
	private final String name;

}
