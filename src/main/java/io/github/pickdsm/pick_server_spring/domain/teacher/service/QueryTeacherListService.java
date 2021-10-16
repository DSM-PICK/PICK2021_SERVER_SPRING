package io.github.pickdsm.pick_server_spring.domain.teacher.service;

import java.util.List;
import java.util.stream.Collectors;

import io.github.pickdsm.pick_server_spring.domain.teacher.domain.repository.TeacherRepository;
import io.github.pickdsm.pick_server_spring.domain.teacher.presentation.dto.response.TeacherResponse;
import io.github.pickdsm.pick_server_spring.domain.teacher.presentation.dto.response.TokenResponse;
import lombok.RequiredArgsConstructor;

import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class QueryTeacherListService {

	private final TeacherRepository teacherRepository;

	public List<TeacherResponse> execute() {
		return teacherRepository.findAll(Sort.by(Direction.ASC, "id"))
				.parallelStream().map(teacher ->
					new TeacherResponse(teacher.getName(), teacher.getId())
				).collect(Collectors.toList());
	}

}
