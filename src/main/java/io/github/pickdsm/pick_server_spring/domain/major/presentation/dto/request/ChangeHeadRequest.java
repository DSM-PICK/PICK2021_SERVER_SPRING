package io.github.pickdsm.pick_server_spring.domain.major.presentation.dto.request;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ChangeHeadRequest {

	@NotNull(message = "major_id는 Null이면 안됩니다.")
	private Long majorId;

	@NotEmpty(message = "student_id는 비어있으면 안됩니다.")
	private String studentId;

}
