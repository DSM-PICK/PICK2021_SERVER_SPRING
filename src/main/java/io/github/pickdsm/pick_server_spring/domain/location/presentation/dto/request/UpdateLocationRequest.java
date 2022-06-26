package io.github.pickdsm.pick_server_spring.domain.location.presentation.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UpdateLocationRequest {

    private String name;
    private int floor;
    private int priority;

}
