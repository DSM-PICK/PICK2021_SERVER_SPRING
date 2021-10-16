package io.github.pickdsm.pick_server_spring.domain.teacher.presentation.dto.request;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class NameRequest {

	@NotEmpty(message = "name는 비어있으면 안됩니다.")
	@Size(max = 5, message = "name는 5자를 넘어서는 안됩니다.")
	private String name;

}
