package io.github.pickdsm.pick_server_spring.domain.location.presentation.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class QueryLocationListResponse {

    private final Long id;
    private final int floor;
    private final int priority;
    private final String name;

}
