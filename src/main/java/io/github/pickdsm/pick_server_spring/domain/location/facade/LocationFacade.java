package io.github.pickdsm.pick_server_spring.domain.location.facade;

import io.github.pickdsm.pick_server_spring.domain.location.domain.Location;
import io.github.pickdsm.pick_server_spring.domain.location.domain.repository.LocationRepository;
import io.github.pickdsm.pick_server_spring.domain.location.exception.LocationNotFoundException;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class LocationFacade {

	private final LocationRepository locationRepository;

	public Location getLocationById(Long id) {
		return locationRepository.findById(id)
				.orElseThrow(() -> LocationNotFoundException.EXCEPTION);
	}

}
