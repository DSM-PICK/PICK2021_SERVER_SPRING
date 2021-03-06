package io.github.pickdsm.pick_server_spring.domain.teacher.service;

import io.github.pickdsm.pick_server_spring.domain.teacher.domain.Teacher;
import io.github.pickdsm.pick_server_spring.domain.teacher.domain.repository.TeacherRepository;
import io.github.pickdsm.pick_server_spring.domain.teacher.domain.types.Role;
import io.github.pickdsm.pick_server_spring.domain.teacher.exception.AlreadyExistTeacherException;
import io.github.pickdsm.pick_server_spring.domain.teacher.exception.InvalidCodeException;
import io.github.pickdsm.pick_server_spring.domain.teacher.presentation.dto.request.RegisterRequest;
import io.github.pickdsm.pick_server_spring.domain.teacher.presentation.dto.response.TokenResponse;
import io.github.pickdsm.pick_server_spring.domain.teacher.utils.JwtUtils;
import io.github.pickdsm.pick_server_spring.global.security.jwt.JwtTokenProvider;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RegisterTeacherService {

	@Value("${teacher.code}")
	private String code;

	private final TeacherRepository teacherRepository;
	private final PasswordEncoder passwordEncoder;
	private final JwtTokenProvider jwtTokenProvider;

	public TokenResponse execute(RegisterRequest request) {
		if(teacherRepository
				.findById(request.getId())
				.isPresent())
			throw AlreadyExistTeacherException.EXCEPTION;

		if(!request.getCode().equals(code))
			throw InvalidCodeException.EXCEPTION;

		Teacher teacher = teacherRepository.save(
				Teacher.builder()
				.id(request.getId())
				.name(request.getName())
				.password(
						passwordEncoder.encode(request.getPassword())
				)
				.role(Role.ROLE_DEFAULT)
				.build()
		);

		return JwtUtils.getToken(teacher);
	}

}
