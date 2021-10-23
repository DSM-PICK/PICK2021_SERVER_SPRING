package io.github.pickdsm.pick_server_spring.domain.major.service;

import javax.transaction.Transactional;

import io.github.pickdsm.pick_server_spring.domain.major.domain.repository.MajorRepository;
import io.github.pickdsm.pick_server_spring.domain.major.exception.MajorNotFoundException;
import io.github.pickdsm.pick_server_spring.domain.major.presentation.dto.request.ChangeNameRequest;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ChangeMajorNameService {

	private final MajorRepository majorRepository;

	@Transactional
	public void execute(Long majorId, ChangeNameRequest request) {
		majorRepository.findById(majorId)
				.orElseThrow(() -> MajorNotFoundException.EXCEPTION)
				.changeName(request.getMajorName());
	}

}
