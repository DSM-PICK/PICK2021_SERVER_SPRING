package io.github.pickdsm.pick_server_spring.domain.major.presentation.dto.request;

import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ChangeLocationRequest {

	@NotNull(message = "location_id는 Null이면 안됩니다.")
	private Long locationId;

}
