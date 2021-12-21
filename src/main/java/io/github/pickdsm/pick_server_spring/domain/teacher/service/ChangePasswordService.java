package io.github.pickdsm.pick_server_spring.domain.teacher.service;

import io.github.pickdsm.pick_server_spring.domain.teacher.domain.Teacher;
import io.github.pickdsm.pick_server_spring.domain.teacher.domain.repository.TeacherRepository;
import io.github.pickdsm.pick_server_spring.domain.teacher.exception.CredentialsNotFoundException;
import io.github.pickdsm.pick_server_spring.domain.teacher.presentation.dto.request.ChangePasswordRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class ChangePasswordService {

	private final TeacherRepository teacherRepository;
	private final PasswordEncoder passwordEncoder;

	@Transactional
	public void execute(ChangePasswordRequest request) {
		Teacher teacher = teacherRepository
				.findById(request.getTeacherId())
				.orElseThrow(() -> CredentialsNotFoundException.EXCEPTION);
		teacher.changePassword(
				passwordEncoder.encode(request.getPassword())
		);
	}

}
