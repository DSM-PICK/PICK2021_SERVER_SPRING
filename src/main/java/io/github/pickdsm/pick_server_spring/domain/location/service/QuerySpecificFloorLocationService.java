package io.github.pickdsm.pick_server_spring.domain.location.service;

import io.github.pickdsm.pick_server_spring.domain.location.domain.repository.LocationRepository;
import io.github.pickdsm.pick_server_spring.domain.location.presentation.dto.response.QueryLocationListResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class QuerySpecificFloorLocationService {

    private final LocationRepository locationFacade;

    public List<QueryLocationListResponse> querySpecificFloorLocationList(int floor) {
        return locationFacade.findByFloor(floor)
                .stream().map(
                        location -> new QueryLocationListResponse(location.getId(), location.getFloor(),
                                location.getPriority(), location.getName())
                ).collect(Collectors.toList());
    }


}
