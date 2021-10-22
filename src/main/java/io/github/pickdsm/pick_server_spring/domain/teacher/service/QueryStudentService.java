package io.github.pickdsm.pick_server_spring.domain.teacher.service;

import java.util.List;
import java.util.stream.Collectors;

import io.github.pickdsm.pick_server_spring.domain.student.domain.repository.StudentRepository;
import io.github.pickdsm.pick_server_spring.domain.teacher.presentation.dto.response.StudentResponse;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class QueryStudentService {

	private final StudentRepository studentRepository;

	public List<StudentResponse> execute(String name) {
		return studentRepository.findByNameLike(name)
				.parallelStream()
				.map(student ->
						new StudentResponse(student.getId(),
								student.getGcn(), student.getName())
				).collect(Collectors.toList());
	}

}
