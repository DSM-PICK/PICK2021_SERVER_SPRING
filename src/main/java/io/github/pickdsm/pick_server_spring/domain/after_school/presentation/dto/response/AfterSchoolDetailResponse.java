package io.github.pickdsm.pick_server_spring.domain.after_school.presentation.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
@AllArgsConstructor
public class AfterSchoolDetailResponse {

    private final String afterSchoolName;
    private final int count;
    private final String teacherName;
    private final String locationName;
    private final String day;
    private final List<Member> members;

}
