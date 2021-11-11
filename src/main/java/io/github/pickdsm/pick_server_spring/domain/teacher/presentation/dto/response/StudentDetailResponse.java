package io.github.pickdsm.pick_server_spring.domain.teacher.presentation.dto.response;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class StudentDetailResponse {

	private final Long id;
	private final String gcn;
	private final String name;
	private final List<Long> afterSchoolId;
	private final Long majorId;

}
