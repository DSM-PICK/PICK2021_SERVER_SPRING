package io.github.pickdsm.pick_server_spring.domain.after_school.presentation.dto.request;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CreateAfterSchoolStudentRequest {

	@NotEmpty(message = "student_id는 비어있으면 안됩니다.")
	private String studentId;

}
