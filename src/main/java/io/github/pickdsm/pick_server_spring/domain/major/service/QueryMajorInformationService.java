package io.github.pickdsm.pick_server_spring.domain.major.service;

import java.util.stream.Collectors;

import io.github.pickdsm.pick_server_spring.domain.major.domain.Major;
import io.github.pickdsm.pick_server_spring.domain.major.domain.repository.MajorRepository;
import io.github.pickdsm.pick_server_spring.domain.major.exception.MajorNotFoundException;
import io.github.pickdsm.pick_server_spring.domain.major.presentation.dto.response.MajorInformationResponse;
import io.github.pickdsm.pick_server_spring.domain.major.presentation.dto.response.MajorInformationResponse.Member;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class QueryMajorInformationService {

	private final MajorRepository majorRepository;

	public MajorInformationResponse execute(Long majorId) {
		Major major = majorRepository
				.findById(majorId)
				.orElseThrow(() -> MajorNotFoundException.EXCEPTION);

		return new MajorInformationResponse(
				major.getName(),
				major.getMembers().size(),
				major.getHeadName(),
				major.getTeacherName(),
				major.getLocationName(),
				major.getMembers()
						.stream()
						.map(member -> new Member(member.getId(),
								member.getName(), member.getGcn()))
						.collect(Collectors.toList())
		);
	}

}
