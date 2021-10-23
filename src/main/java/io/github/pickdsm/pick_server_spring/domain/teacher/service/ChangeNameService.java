package io.github.pickdsm.pick_server_spring.domain.teacher.service;

import javax.transaction.Transactional;

import io.github.pickdsm.pick_server_spring.domain.teacher.domain.repository.TeacherRepository;
import io.github.pickdsm.pick_server_spring.domain.teacher.exception.CredentialsNotFoundException;
import io.github.pickdsm.pick_server_spring.domain.teacher.facade.TeacherFacade;
import io.github.pickdsm.pick_server_spring.domain.teacher.presentation.dto.request.NameRequest;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ChangeNameService {

	private final TeacherFacade teacherFacade;
	private final TeacherRepository teacherRepository;

	@Transactional
	public void execute(NameRequest request) {
		teacherRepository
				.findById(teacherFacade.getCurrentTeacherId())
				.orElseThrow(() -> CredentialsNotFoundException.EXCEPTION)
				.changeName(request.getName());
	}

}
