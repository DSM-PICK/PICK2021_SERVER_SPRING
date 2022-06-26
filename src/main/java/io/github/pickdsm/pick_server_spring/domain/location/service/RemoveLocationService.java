package io.github.pickdsm.pick_server_spring.domain.location.service;

import io.github.pickdsm.pick_server_spring.domain.location.domain.repository.LocationRepository;
import io.github.pickdsm.pick_server_spring.domain.location.exception.LocationNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class RemoveLocationService {

    private final LocationRepository locationRepository;

    public void removeLocation(Long locationId) {
        if(locationRepository.findById(locationId).isEmpty()) {
            throw LocationNotFoundException.EXCEPTION;
        }

        locationRepository.deleteById(locationId);

    }

}
