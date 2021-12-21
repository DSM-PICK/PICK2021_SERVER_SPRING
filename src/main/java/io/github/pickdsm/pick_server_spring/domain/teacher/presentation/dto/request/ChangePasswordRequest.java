package io.github.pickdsm.pick_server_spring.domain.teacher.presentation.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@Getter
@NoArgsConstructor
public class ChangePasswordRequest {

	@NotEmpty(message = "password는 비어있으면 안됩니다.")
	@Pattern(regexp = "^(?=.*[a-z])(?=.*[0-9])(?=.*[~!@#*_])[a-zA-Z0-9~!@#*_]{8,32}$"
			, message = "password는 영문(대소문자 구분), 숫자, 특수기호(~!@#*_) 포함 8자리 이상입니다.")
	private String password;

	@NotEmpty(message = "teacher_id는 비어있으면 안됩니다.")
	private String teacherId;

}
