package io.github.pickdsm.pick_server_spring.domain.student.facade;

import io.github.pickdsm.pick_server_spring.domain.student.domain.Student;
import io.github.pickdsm.pick_server_spring.domain.student.domain.repository.StudentRepository;
import io.github.pickdsm.pick_server_spring.domain.student.exception.StudentNotFoundException;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class StudentFacade {

	private final StudentRepository studentRepository;

	public Student getStudentById(String id) {
		return studentRepository.findById(id)
				.orElseThrow(StudentNotFoundException::new);
	}

	public Student getStudentByNameAndGcn(String name, String gcn) {
		return studentRepository.findByNameAndGcn(name, gcn)
				.orElseThrow(StudentNotFoundException::new);
	}

}
