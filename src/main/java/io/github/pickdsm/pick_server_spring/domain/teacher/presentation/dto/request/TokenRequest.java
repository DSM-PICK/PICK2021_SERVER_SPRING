package io.github.pickdsm.pick_server_spring.domain.teacher.presentation.dto.request;

import javax.validation.constraints.NotEmpty;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class TokenRequest {

	@NotEmpty(message = "refresh_token은 비어있으면 안됩니다.")
	private String refreshToken;

}
