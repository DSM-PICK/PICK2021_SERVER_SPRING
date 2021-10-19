package io.github.pickdsm.pick_server_spring.domain.affiliated_after_school.facade;

import io.github.pickdsm.pick_server_spring.domain.affiliated_after_school.domain.AffiliatedAfterSchool;
import io.github.pickdsm.pick_server_spring.domain.affiliated_after_school.domain.repository.AffiliatedAfterSchoolRepository;
import io.github.pickdsm.pick_server_spring.domain.affiliated_after_school.exception.AlreadyExistStudentException;
import io.github.pickdsm.pick_server_spring.domain.after_school.domain.AfterSchool;
import io.github.pickdsm.pick_server_spring.domain.student.domain.Student;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AffiliatedAfterSchoolFacade {

	private final AffiliatedAfterSchoolRepository affiliatedAfterSchoolRepository;

	public void createAffiliated(AfterSchool afterSchool, Student student) {
		if(affiliatedAfterSchoolRepository
				.findByAfterSchoolAndStudent(afterSchool.getId(),
						student.getId())
				.isPresent())
			throw new AlreadyExistStudentException();
		affiliatedAfterSchoolRepository.save(
				AffiliatedAfterSchool.builder()
				.afterSchool(afterSchool)
				.student(student)
				.build()
		);
	}

}
