package io.github.pickdsm.pick_server_spring.domain.location.presentation;

import io.github.pickdsm.pick_server_spring.domain.location.presentation.dto.response.QueryLocationListResponse;
import io.github.pickdsm.pick_server_spring.domain.location.service.QueryLocationListService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/location")
@RestController
public class LocationController {

    private final QueryLocationListService queryLocationListService;

    @GetMapping("/{floor}")
    public List<QueryLocationListResponse> queryLocationList(@PathVariable("floor") int floor) {
        return queryLocationListService.queryLocationList(floor);
    }

}
