package io.github.pickdsm.pick_server_spring.domain.major.service;

import java.util.List;
import java.util.stream.Collectors;

import io.github.pickdsm.pick_server_spring.domain.major.domain.repository.MajorRepository;
import io.github.pickdsm.pick_server_spring.domain.major.presentation.dto.response.MajorResponse;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class QueryMajorListService {

	private final MajorRepository majorRepository;

	public List<MajorResponse> execute() {
		return majorRepository.findAll()
				.stream().map(major -> {
					String locationName = major.getLocation() == null ?
							null : major.getLocation().getName();
					return new MajorResponse(major.getId(), major.getName(),
							locationName, major.getHead().getName());
		}).collect(Collectors.toList());
	}

}
