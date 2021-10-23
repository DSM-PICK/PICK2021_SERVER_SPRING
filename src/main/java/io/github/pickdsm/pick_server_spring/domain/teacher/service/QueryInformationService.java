package io.github.pickdsm.pick_server_spring.domain.teacher.service;

import io.github.pickdsm.pick_server_spring.domain.teacher.domain.Teacher;
import io.github.pickdsm.pick_server_spring.domain.teacher.domain.repository.TeacherRepository;
import io.github.pickdsm.pick_server_spring.domain.teacher.exception.TeacherNotFoundException;
import io.github.pickdsm.pick_server_spring.domain.teacher.presentation.dto.response.InformationResponse;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class QueryInformationService {

	private final TeacherRepository teacherRepository;

	public InformationResponse execute(String teacherId) {
		Teacher teacher = teacherRepository
				.findById(teacherId)
				.orElseThrow(() -> TeacherNotFoundException.EXCEPTION);
		Long locationId = null;
		String locationName = null;

		if(teacher.getLocation() != null) {
			locationId = teacher.getLocation().getId();
			locationName = teacher.getLocation().getName();
		}

		return new InformationResponse(
				locationId, locationName,
				teacher.getName()
		);
	}

}
