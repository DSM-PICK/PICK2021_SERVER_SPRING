package io.github.pickdsm.pick_server_spring.domain.schedule.presentation.dto.request;

import java.time.LocalDate;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ChangePeriodRequest {

	@NotNull(message = "date는 Null이면 안됩니다.")
	private LocalDate date;

	@Min(value = 2, message = "period는 2 이상이어야 합니다.")
	@Max(value = 5, message = "period는 5 이상이어야 합니다.")
	private Integer	period;

}
