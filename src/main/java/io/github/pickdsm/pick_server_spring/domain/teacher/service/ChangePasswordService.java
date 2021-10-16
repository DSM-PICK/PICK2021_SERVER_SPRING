package io.github.pickdsm.pick_server_spring.domain.teacher.service;

import javax.transaction.Transactional;

import io.github.pickdsm.pick_server_spring.domain.teacher.domain.Teacher;
import io.github.pickdsm.pick_server_spring.domain.teacher.domain.repository.TeacherRepository;
import io.github.pickdsm.pick_server_spring.domain.teacher.exception.CredentialsNotFoundException;
import io.github.pickdsm.pick_server_spring.domain.teacher.facade.TeacherFacade;
import io.github.pickdsm.pick_server_spring.domain.teacher.presentation.dto.request.PasswordRequest;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ChangePasswordService {

	private final TeacherRepository teacherRepository;
	private final TeacherFacade teacherFacade;

	@Transactional
	public void execute(PasswordRequest request) {
		Teacher teacher = teacherRepository
				.findById(teacherFacade.getCurrentTeacherId())
				.orElseThrow(CredentialsNotFoundException::new);
		teacher.changePassword(request.getPassword());
	}

}
