package io.github.pickdsm.pick_server_spring.domain.major.service;

import javax.transaction.Transactional;

import io.github.pickdsm.pick_server_spring.domain.major.domain.Major;
import io.github.pickdsm.pick_server_spring.domain.major.domain.repository.MajorRepository;
import io.github.pickdsm.pick_server_spring.domain.major.exception.MajorNotFoundException;
import io.github.pickdsm.pick_server_spring.domain.major.presentation.dto.request.AddMemberRequest;
import io.github.pickdsm.pick_server_spring.domain.student.domain.Student;
import io.github.pickdsm.pick_server_spring.domain.student.facade.StudentFacade;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AddMemberService {

	private final MajorRepository majorRepository;
	private final StudentFacade studentFacade;

	@Transactional
	public void execute(AddMemberRequest request) {
		Major major = majorRepository
				.findById(request.getMajorId())
				.orElseThrow(() -> MajorNotFoundException.EXCEPTION);
		Student student = studentFacade
				.getStudentById(request.getStudentId());
		student.changeMajor(major);
	}

}
