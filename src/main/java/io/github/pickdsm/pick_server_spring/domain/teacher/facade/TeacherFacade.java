package io.github.pickdsm.pick_server_spring.domain.teacher.facade;

import io.github.pickdsm.pick_server_spring.domain.teacher.domain.Teacher;
import io.github.pickdsm.pick_server_spring.domain.teacher.domain.repository.TeacherRepository;
import io.github.pickdsm.pick_server_spring.domain.teacher.exception.CredentialsNotFoundException;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TeacherFacade {

	private final TeacherRepository teacherRepository;

	public Teacher getTeacherById(String id) {
		return teacherRepository.findById(id)
				.orElseThrow(CredentialsNotFoundException::new);
	}

}
