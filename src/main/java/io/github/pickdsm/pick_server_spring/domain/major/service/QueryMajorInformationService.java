package io.github.pickdsm.pick_server_spring.domain.major.service;

import io.github.pickdsm.pick_server_spring.domain.major.domain.Major;
import io.github.pickdsm.pick_server_spring.domain.major.domain.repository.MajorRepository;
import io.github.pickdsm.pick_server_spring.domain.major.exception.MajorNotFoundException;
import io.github.pickdsm.pick_server_spring.domain.major.presentation.dto.response.MajorInformationResponse;
import io.github.pickdsm.pick_server_spring.domain.major.presentation.dto.response.MajorInformationResponse.Member;
import io.github.pickdsm.pick_server_spring.domain.student.domain.Student;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class QueryMajorInformationService {

    private final MajorRepository majorRepository;

    public MajorInformationResponse execute(Long majorId) {
        Major major = majorRepository
                .findById(majorId)
                .orElseThrow(() -> MajorNotFoundException.EXCEPTION);

        List<Member> memberList = major.getMembers()
                .stream()
                .sorted(Comparator.comparing(Student::getId))
                .filter(student -> !student.getId().equals(major.getHead().getId()))
                .map(member -> new Member(member.getId(),
                        member.getName(), member.getGcn())
                ).collect(Collectors.toList());

        memberList.add(0, new Member(
                major.getHead().getId(),
                major.getHead().getName(),
                major.getHead().getGcn())
        );

        return new MajorInformationResponse(
                major.getName(),
                major.getMembers().size(),
                major.getHeadName(),
                major.getTeacherName(),
                major.getLocationName(),
                memberList
        );
    }

}
