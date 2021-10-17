package io.github.pickdsm.pick_server_spring.domain.major.presentation.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class MajorResponse {

	private final Long majorId;
	private final String majorName;
	private final String locationName;
	private final String headName;

}
