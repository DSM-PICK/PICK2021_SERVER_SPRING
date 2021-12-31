package io.github.pickdsm.pick_server_spring.domain.after_school.presentation.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class AfterSchoolResponse {

	private final Long afterSchoolId;
	private final String name;
	private final String teacherName;
	private final String locationName;

}
