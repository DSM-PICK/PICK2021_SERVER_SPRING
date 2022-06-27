package io.github.pickdsm.pick_server_spring.domain.self_study.presentation.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class QueryClassResponse {

    private final Long id;
    private final String name;
    private final String teacherName;
    private final int floor;
    private final int count;

}
