package io.github.pickdsm.pick_server_spring.domain.teacher.facade;

import io.github.pickdsm.pick_server_spring.domain.teacher.domain.Teacher;
import io.github.pickdsm.pick_server_spring.domain.teacher.domain.repository.TeacherRepository;
import io.github.pickdsm.pick_server_spring.domain.teacher.exception.CredentialsNotFoundException;
import io.github.pickdsm.pick_server_spring.global.security.AuthDetails;
import lombok.RequiredArgsConstructor;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TeacherFacade {

	private final TeacherRepository teacherRepository;

	public Teacher getTeacherById(String id) {
		return teacherRepository.findById(id)
				.orElseThrow(CredentialsNotFoundException::new);
	}

	public String getCurrentTeacherId() {
		Object details = SecurityContextHolder
				.getContext().getAuthentication().getPrincipal();
		if(details instanceof AuthDetails) {
			return ((AuthDetails)details).getTeacher().getId();
		}
		throw new CredentialsNotFoundException();
	}

}
