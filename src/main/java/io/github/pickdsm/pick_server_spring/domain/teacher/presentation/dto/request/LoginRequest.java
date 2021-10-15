package io.github.pickdsm.pick_server_spring.domain.teacher.presentation.dto.request;

import javax.validation.constraints.NotEmpty;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class LoginRequest {

	@NotEmpty(message = "id는 비어있으면 안됩니다.")
	private String id;

	@NotEmpty(message = "password는 비어있으면 안됩니다.")
	private String password;

}
