package io.github.pickdsm.pick_server_spring.domain.location.service;

import io.github.pickdsm.pick_server_spring.domain.location.domain.Location;
import io.github.pickdsm.pick_server_spring.domain.location.domain.repository.LocationRepository;
import io.github.pickdsm.pick_server_spring.domain.location.exception.LocationNotFoundException;
import io.github.pickdsm.pick_server_spring.domain.location.presentation.dto.request.UpdateLocationRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class UpdateLocationService {

    private final LocationRepository locationRepository;

    @Transactional
    public void updateLocation(Long locationId, UpdateLocationRequest request) {
        Location location = locationRepository.findById(locationId)
                        .orElseThrow(() -> LocationNotFoundException.EXCEPTION);
        location.updateLocation(request.getName(), request.getFloor(), request.getPriority());
    }

}
