package io.github.pickdsm.pick_server_spring.domain.teacher.service;

import io.github.pickdsm.pick_server_spring.domain.teacher.domain.repository.TeacherRepository;
import io.github.pickdsm.pick_server_spring.domain.teacher.exception.CredentialsNotFoundException;
import io.github.pickdsm.pick_server_spring.domain.teacher.facade.TeacherFacade;
import io.github.pickdsm.pick_server_spring.domain.teacher.presentation.dto.request.ChangeNameRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class ChangeNameService {

	private final TeacherRepository teacherRepository;

	@Transactional
	public void execute(ChangeNameRequest request) {
		teacherRepository
				.findById(request.getTeacherId())
				.orElseThrow(() -> CredentialsNotFoundException.EXCEPTION)
				.changeName(request.getName());
	}

}
