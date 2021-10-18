package io.github.pickdsm.pick_server_spring.domain.after_school.presentation.dto.request;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UpdateAfterSchoolRequest {

	@NotEmpty(message = "name은 비어있으면 안됩니다.")
	private String name;

	@NotEmpty(message = "teacher_id는 비어있으면 안됩니다.")
	private String teacherId;

	@NotNull(message = "location_id는 Null이면 안됩니다.")
	private Long locationId;

	@Size(min = 3, max = 3, message = "day는 세 글자여야 합니다.")
	private String day;

}
