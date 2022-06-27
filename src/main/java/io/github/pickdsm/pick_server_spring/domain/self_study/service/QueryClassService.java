package io.github.pickdsm.pick_server_spring.domain.self_study.service;

import io.github.pickdsm.pick_server_spring.domain.location.domain.repository.LocationRepository;
import io.github.pickdsm.pick_server_spring.domain.self_study.presentation.dto.response.QueryClassResponse;
import io.github.pickdsm.pick_server_spring.domain.student.domain.repository.StudentRepository;
import io.github.pickdsm.pick_server_spring.domain.teacher.domain.Teacher;
import io.github.pickdsm.pick_server_spring.domain.teacher.domain.repository.TeacherRepository;
import io.github.pickdsm.pick_server_spring.domain.teacher.exception.TeacherNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class QueryClassService {

    private final LocationRepository locationRepository;
    private final TeacherRepository teacherRepository;
    private final StudentRepository studentRepository;

    public List<QueryClassResponse> queryClass() {
        System.out.println(locationRepository.findAllClass().size());
        return locationRepository.findAllClass()
                .stream()
                .map(location -> new QueryClassResponse(
                        location.getId(),
                        location.getName(),
                        teacherRepository.findByLocation(location)
                                .map(Teacher::getName)
                                .orElse("선생님이 없습니다."),
                        location.getFloor(),
                        studentRepository.countByLocation(location)
                )).collect(Collectors.toList());
    }

}
