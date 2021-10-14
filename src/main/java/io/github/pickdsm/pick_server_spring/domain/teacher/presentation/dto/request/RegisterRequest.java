package io.github.pickdsm.pick_server_spring.domain.teacher.presentation.dto.request;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Getter
@NoArgsConstructor
public class RegisterRequest {

	@NotEmpty(message = "id는 비어있으면 안됩니다.")
	@Size(max = 10, message = "id는 10자를 넘어서는 안됩니다.")
	private String id;

	@NotEmpty(message = "name는 비어있으면 안됩니다.")
	@Size(max = 5, message = "name는 5자를 넘어서는 안됩니다.")
	private String name;

	@NotEmpty(message = "password는 비어있으면 안됩니다.")
	@Pattern(regexp = "^(?=.*[a-z])(?=.*[0-9])(?=.*[~!@#*_])[a-zA-Z0-9~!@#*_]{8,32}$"
	, message = "password는 영문(대소문자 구분), 숫자, 특수기호(~!@#*_) 포함 8자리 이상입니다.")
	private String password;

	@NotEmpty(message = "code는 비어잇으면 안됩니다.")
	private String code;

}
