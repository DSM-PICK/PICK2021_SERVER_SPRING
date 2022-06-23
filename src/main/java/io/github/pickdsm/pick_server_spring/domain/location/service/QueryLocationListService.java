package io.github.pickdsm.pick_server_spring.domain.location.service;

import io.github.pickdsm.pick_server_spring.domain.location.domain.repository.LocationRepository;
import io.github.pickdsm.pick_server_spring.domain.location.presentation.dto.response.QueryLocationListResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class QueryLocationListService {

    private final LocationRepository locationRepository;

    public List<QueryLocationListResponse> queryLocationList() {
        return locationRepository.findAll()
                .stream().map(
                        location -> new QueryLocationListResponse(location.getId(), location.getFloor(),
                                location.getPriority(), location.getName())
                ).collect(Collectors.toList());
    }

}
