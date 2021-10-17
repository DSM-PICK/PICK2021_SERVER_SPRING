package io.github.pickdsm.pick_server_spring.domain.major.service;

import javax.transaction.Transactional;

import io.github.pickdsm.pick_server_spring.domain.major.domain.Major;
import io.github.pickdsm.pick_server_spring.domain.major.domain.repository.MajorRepository;
import io.github.pickdsm.pick_server_spring.domain.major.exception.MajorNotFoundException;
import io.github.pickdsm.pick_server_spring.domain.major.presentation.dto.request.ChangeHeadRequest;
import io.github.pickdsm.pick_server_spring.domain.student.domain.Student;
import io.github.pickdsm.pick_server_spring.domain.student.domain.repository.StudentRepository;
import io.github.pickdsm.pick_server_spring.domain.student.exception.StudentNotFoundException;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ChangeHeadService {

	private final MajorRepository majorRepository;
	private final StudentRepository studentRepository;

	@Transactional
	public void execute(ChangeHeadRequest request) {
		Major major = majorRepository.findById(request.getMajorId())
				.orElseThrow(MajorNotFoundException::new);
		Student student = studentRepository.findById(request.getStudentId())
				.orElseThrow(StudentNotFoundException::new);
		major.changeHead(student);
	}


}
