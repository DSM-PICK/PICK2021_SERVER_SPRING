package io.github.pickdsm.pick_server_spring.domain.after_school.service;

import io.github.pickdsm.pick_server_spring.domain.affiliated_after_school.facade.AffiliatedAfterSchoolFacade;
import io.github.pickdsm.pick_server_spring.domain.after_school.domain.AfterSchool;
import io.github.pickdsm.pick_server_spring.domain.after_school.domain.repository.AfterSchoolRepository;
import io.github.pickdsm.pick_server_spring.domain.after_school.exception.AfterSchoolNotFoundException;
import io.github.pickdsm.pick_server_spring.domain.after_school.presentation.dto.request.RemoveAfterSchoolStudentRequest;
import io.github.pickdsm.pick_server_spring.domain.student.domain.Student;
import io.github.pickdsm.pick_server_spring.domain.student.facade.StudentFacade;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RemoveAfterSchoolStudentService {

	private final AffiliatedAfterSchoolFacade affiliatedAfterSchoolFacade;
	private final AfterSchoolRepository afterSchoolRepository;
	private final StudentFacade studentFacade;

	public void execute(Long afterSchoolId, RemoveAfterSchoolStudentRequest request) {
		AfterSchool afterSchool = afterSchoolRepository
				.findById(afterSchoolId)
				.orElseThrow(() -> AfterSchoolNotFoundException.EXCEPTION);
		Student student = studentFacade
				.getStudentById(request.getStudentId());
		affiliatedAfterSchoolFacade.removeAffiliated(afterSchool, student);
	}

}
