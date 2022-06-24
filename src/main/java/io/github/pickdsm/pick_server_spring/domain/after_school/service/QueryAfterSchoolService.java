package io.github.pickdsm.pick_server_spring.domain.after_school.service;

import io.github.pickdsm.pick_server_spring.domain.after_school.domain.repository.AfterSchoolRepository;
import io.github.pickdsm.pick_server_spring.domain.after_school.presentation.dto.response.AfterSchoolResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class QueryAfterSchoolService {

    private final AfterSchoolRepository afterSchoolRepository;

    public List<AfterSchoolResponse> execute() {
        return afterSchoolRepository.findAll()
                .stream()
                .map(afterSchool -> new AfterSchoolResponse(afterSchool.getId(), afterSchool.getName(),
                        afterSchool.getTeacherName(), afterSchool.getLocationName(), afterSchool.getLocationFloor(),
                        afterSchool.getAffiliatedAfterSchools().size()))
                .collect(Collectors.toList());
    }

}
