package io.github.pickdsm.pick_server_spring.domain.schedule.presentation.dto.request;

import java.time.LocalDate;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CreateRequest {

	@NotNull(message = "date는 Null이면 안됩니다.")
	private LocalDate date;

	@NotEmpty(message = "name는 비어있으면 안됩니다.")
	private String name;

}
