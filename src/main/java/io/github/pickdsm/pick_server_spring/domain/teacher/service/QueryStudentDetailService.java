package io.github.pickdsm.pick_server_spring.domain.teacher.service;

import java.util.List;
import java.util.stream.Collectors;

import io.github.pickdsm.pick_server_spring.domain.affiliated_after_school.facade.AffiliatedAfterSchoolFacade;
import io.github.pickdsm.pick_server_spring.domain.student.domain.repository.StudentRepository;
import io.github.pickdsm.pick_server_spring.domain.teacher.presentation.dto.response.StudentDetailResponse;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class QueryStudentDetailService {

	private final StudentRepository studentRepository;
	private final AffiliatedAfterSchoolFacade affiliatedAfterSchoolFacade;

	public List<StudentDetailResponse> execute(String name) {
		return studentRepository.findByNameLike(name)
				.stream().map(student ->
					new StudentDetailResponse(
							student.getId(),
							student.getGcn(),
							student.getName(),
							affiliatedAfterSchoolFacade.queryAffiliated(student),
							student.getMajor().getId()
					)
		).collect(Collectors.toList());
	}

}
