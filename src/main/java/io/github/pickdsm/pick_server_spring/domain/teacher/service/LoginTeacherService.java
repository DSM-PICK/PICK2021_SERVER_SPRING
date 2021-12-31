package io.github.pickdsm.pick_server_spring.domain.teacher.service;

import io.github.pickdsm.pick_server_spring.domain.teacher.domain.Teacher;
import io.github.pickdsm.pick_server_spring.domain.teacher.domain.repository.TeacherRepository;
import io.github.pickdsm.pick_server_spring.domain.teacher.exception.CredentialsNotFoundException;
import io.github.pickdsm.pick_server_spring.domain.teacher.exception.WrongPasswordException;
import io.github.pickdsm.pick_server_spring.domain.teacher.presentation.dto.request.LoginRequest;
import io.github.pickdsm.pick_server_spring.domain.teacher.presentation.dto.response.LoginResponse;
import io.github.pickdsm.pick_server_spring.domain.teacher.utils.JwtUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginTeacherService {

	private final TeacherRepository teacherRepository;
	private final PasswordEncoder passwordEncoder;

	public LoginResponse execute(LoginRequest request) {
		Teacher teacher = teacherRepository
				.findById(request.getId())
				.orElseThrow(() -> CredentialsNotFoundException.EXCEPTION);

		if(!passwordEncoder.matches(request.getPassword(),
				teacher.getPassword()))
			throw WrongPasswordException.EXCEPTION;

		return new LoginResponse(JwtUtils.getToken(teacher), teacher.getLocationId(), teacher.getLocationName());

	}

}
