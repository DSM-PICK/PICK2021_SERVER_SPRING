package io.github.pickdsm.pick_server_spring.domain.location.service;

import io.github.pickdsm.pick_server_spring.domain.location.domain.Location;
import io.github.pickdsm.pick_server_spring.domain.location.domain.repository.LocationRepository;
import io.github.pickdsm.pick_server_spring.domain.location.exception.AlreadyExistLocationException;
import io.github.pickdsm.pick_server_spring.domain.location.presentation.dto.request.CreateLocationRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CreateLocationService {

    private final LocationRepository locationRepository;

    public void createLocation(CreateLocationRequest request) {
        if(locationRepository.findByName(request.getName()).isPresent()) {
            throw AlreadyExistLocationException.EXCEPTION;
        }

        locationRepository.save(
                Location.builder()
                        .name(request.getName())
                        .floor(request.getFloor())
                        .priority(request.getPriority())
                        .build()
        );
    }

}
