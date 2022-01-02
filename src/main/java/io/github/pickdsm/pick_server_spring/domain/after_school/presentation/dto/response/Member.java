package io.github.pickdsm.pick_server_spring.domain.after_school.presentation.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Member {

    private final Long studentId;
    private final String studentName;
    private final String gcn;

}
