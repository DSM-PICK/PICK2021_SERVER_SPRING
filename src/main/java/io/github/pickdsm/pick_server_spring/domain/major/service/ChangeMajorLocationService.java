package io.github.pickdsm.pick_server_spring.domain.major.service;

import javax.transaction.Transactional;

import io.github.pickdsm.pick_server_spring.domain.location.domain.Location;
import io.github.pickdsm.pick_server_spring.domain.location.facade.LocationFacade;
import io.github.pickdsm.pick_server_spring.domain.major.domain.Major;
import io.github.pickdsm.pick_server_spring.domain.major.domain.repository.MajorRepository;
import io.github.pickdsm.pick_server_spring.domain.major.exception.MajorNotFoundException;
import io.github.pickdsm.pick_server_spring.domain.major.presentation.dto.request.ChangeLocationRequest;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ChangeMajorLocationService {

	private final MajorRepository majorRepository;
	private final LocationFacade locationFacade;

	@Transactional
	public void execute(Long majorId, ChangeLocationRequest request) {
		Major major = majorRepository.findById(majorId)
				.orElseThrow(MajorNotFoundException::new);
		Location location = locationFacade
				.getLocationById(request.getLocationId());
		major.changeLocation(location);
	}

}
