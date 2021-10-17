package io.github.pickdsm.pick_server_spring.domain.major.presentation.dto.request;

import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ChangeHeadRequest {

	@NotNull(message = "major_id는 Null이면 안됩니다.")
	private Long majorId;

	@NotNull(message = "student_id는 Null이면 안됩니다.")
	private Long studentId;

}
