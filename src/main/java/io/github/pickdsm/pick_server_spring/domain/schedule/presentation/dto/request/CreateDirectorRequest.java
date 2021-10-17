package io.github.pickdsm.pick_server_spring.domain.schedule.presentation.dto.request;

import java.time.LocalDate;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CreateDirectorRequest {

	@Min(value = 3, message = "floor는 3이상의 값이어야 합니다.")
	@Max(value = 5, message = "floor는 5이하의 값이어야 합니다.")
	private Integer floor;

	@NotNull(message = "date는 Null이면 안됩니다.")
	private LocalDate date;

	@NotEmpty(message = "teacher_id는 비어있으면 안됩니다.")
	private String teacherId;

}
