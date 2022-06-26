package io.github.pickdsm.pick_server_spring.domain.location.presentation;

import io.github.pickdsm.pick_server_spring.domain.location.presentation.dto.request.CreateLocationRequest;
import io.github.pickdsm.pick_server_spring.domain.location.presentation.dto.request.UpdateLocationRequest;
import io.github.pickdsm.pick_server_spring.domain.location.presentation.dto.response.QueryLocationListResponse;
import io.github.pickdsm.pick_server_spring.domain.location.service.CreateLocationService;
import io.github.pickdsm.pick_server_spring.domain.location.service.QueryLocationListService;
import io.github.pickdsm.pick_server_spring.domain.location.service.QuerySpecificFloorLocationService;
import io.github.pickdsm.pick_server_spring.domain.location.service.UpdateLocationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/location")
@RestController
public class LocationController {

    private final QuerySpecificFloorLocationService querySpecificFloorLocationService;
    private final QueryLocationListService queryLocationListService;
    private final CreateLocationService createLocationService;
    private final UpdateLocationService updateLocationService;

    @GetMapping("/{floor}")
    public List<QueryLocationListResponse> querySpecificFloorLocationList(@PathVariable("floor") int floor) {
        return querySpecificFloorLocationService.querySpecificFloorLocationList(floor);
    }

    @GetMapping("/list")
    public List<QueryLocationListResponse> queryLocationList() {
        return queryLocationListService.queryLocationList();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void createLocation(@RequestBody CreateLocationRequest request) {
        createLocationService.createLocation(request);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PatchMapping("/{locationId}")
    public void updateLocation(@PathVariable("locationId") Long locationId, @RequestBody UpdateLocationRequest request) {
        updateLocationService.updateLocation(locationId, request);
    }

}
