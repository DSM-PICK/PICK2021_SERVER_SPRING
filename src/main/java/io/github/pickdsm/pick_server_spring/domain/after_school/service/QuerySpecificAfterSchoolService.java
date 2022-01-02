package io.github.pickdsm.pick_server_spring.domain.after_school.service;

import io.github.pickdsm.pick_server_spring.domain.affiliated_after_school.domain.repository.AffiliatedAfterSchoolRepository;
import io.github.pickdsm.pick_server_spring.domain.after_school.domain.AfterSchool;
import io.github.pickdsm.pick_server_spring.domain.after_school.domain.repository.AfterSchoolRepository;
import io.github.pickdsm.pick_server_spring.domain.after_school.exception.AfterSchoolNotFoundException;
import io.github.pickdsm.pick_server_spring.domain.after_school.presentation.dto.response.AfterSchoolDetailResponse;
import io.github.pickdsm.pick_server_spring.domain.after_school.presentation.dto.response.Member;
import io.github.pickdsm.pick_server_spring.domain.student.domain.Student;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class QuerySpecificAfterSchoolService {

    private final AfterSchoolRepository afterSchoolRepository;
    private final AffiliatedAfterSchoolRepository affiliatedAfterSchoolRepository;

    public AfterSchoolDetailResponse execute(Long afterSchoolId) {
        AfterSchool afterSchool = afterSchoolRepository.findById(afterSchoolId)
                .orElseThrow(() -> AfterSchoolNotFoundException.EXCEPTION);

        List<Member> members = new ArrayList<>();

        affiliatedAfterSchoolRepository.findByAfterSchool(afterSchool)
                .forEach(affiliatedAfterSchool -> {
                    Student member = affiliatedAfterSchool.getStudent();
                    members.add(new Member(member.getId(), member.getName(), member.getGcn()));
                });

        return AfterSchoolDetailResponse.builder()
                .afterSchoolName(afterSchool.getName())
                .count(members.size())
                .teacherName(afterSchool.getTeacher().getName())
                .locationName(afterSchool.getLocation().getName())
                .day(afterSchool.getDay().name())
                .members(members)
                .build();


    }

}
