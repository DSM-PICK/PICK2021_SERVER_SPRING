package io.github.pickdsm.pick_server_spring.domain.major.presentation.dto.request;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CreateMajorRequest {

	@NotEmpty(message = "major_name은 비어있으면 안됩니다.")
	private String majorName;

	@NotEmpty(message = "head_name은 비어있으면 안됩니다.")
	private String headName;

	@NotEmpty(message = "head_gcn은 비어있으면 안됩니다.")
	private String headGcn;

	@NotEmpty(message = "location_name은 비어있으면 안됩니다.")
	private String locationName;

	@NotEmpty(message = "teacher_id은 비어있으면 안됩니다.")
	private String teacherId;

}
