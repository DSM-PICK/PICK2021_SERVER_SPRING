package io.github.pickdsm.pick_server_spring.domain.major.presentation.dto.request;

import javax.validation.constraints.NotEmpty;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ChangeNameRequest {

	@NotEmpty(message = "major_name는 비어있으면 안됩니다.")
	private String majorName;

}
