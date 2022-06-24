package io.github.pickdsm.pick_server_spring.domain.major.service;

import io.github.pickdsm.pick_server_spring.domain.major.domain.repository.MajorRepository;
import io.github.pickdsm.pick_server_spring.domain.major.presentation.dto.response.MajorResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class QueryMajorListService {

	private final MajorRepository majorRepository;

	public List<MajorResponse> execute() {
		return majorRepository.findAll()
				.stream().map(major ->
						new MajorResponse(major.getId(), major.getName(),
							major.getLocationName(), major.getHead().getName(), major.getLocationFloor())
		).collect(Collectors.toList());
	}

}
