package io.github.pickdsm.pick_server_spring.domain.schedule.presentation.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Getter
@NoArgsConstructor
public class CreateDirectorRequest {

	@Min(value = 2, message = "floor는 2이상의 값이어야 합니다.")
	@Max(value = 5, message = "floor는 5이하의 값이어야 합니다.")
	private Integer floor;

	@NotNull(message = "date는 Null이면 안됩니다.")
	private LocalDate date;

	@NotEmpty(message = "teacher_id는 비어있으면 안됩니다.")
	private String teacherId;

}
