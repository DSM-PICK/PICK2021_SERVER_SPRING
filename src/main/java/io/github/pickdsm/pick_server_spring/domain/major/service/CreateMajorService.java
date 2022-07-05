package io.github.pickdsm.pick_server_spring.domain.major.service;

import io.github.pickdsm.pick_server_spring.domain.location.domain.Location;
import io.github.pickdsm.pick_server_spring.domain.location.facade.LocationFacade;
import io.github.pickdsm.pick_server_spring.domain.major.domain.Major;
import io.github.pickdsm.pick_server_spring.domain.major.domain.repository.MajorRepository;
import io.github.pickdsm.pick_server_spring.domain.major.exception.AlreadyExistMajorLocationException;
import io.github.pickdsm.pick_server_spring.domain.major.exception.AlreadyExistMajorNameException;
import io.github.pickdsm.pick_server_spring.domain.major.presentation.dto.request.CreateMajorRequest;
import io.github.pickdsm.pick_server_spring.domain.major.presentation.dto.response.PostMajorResponse;
import io.github.pickdsm.pick_server_spring.domain.student.domain.Student;
import io.github.pickdsm.pick_server_spring.domain.student.facade.StudentFacade;
import io.github.pickdsm.pick_server_spring.domain.teacher.domain.Teacher;
import io.github.pickdsm.pick_server_spring.domain.teacher.facade.TeacherFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class CreateMajorService {

    private final StudentFacade studentFacade;
    private final LocationFacade locationFacade;
    private final TeacherFacade teacherFacade;
    private final MajorRepository majorRepository;

    @Transactional
    public PostMajorResponse execute(CreateMajorRequest request) {
        majorRepository.findByName(request.getMajorName())
                .ifPresent(major -> {
                    throw AlreadyExistMajorNameException.EXCEPTION;
                });
        Student head = studentFacade
                .getStudentByNameAndGcn(request.getHeadName(), request.getHeadGcn());
        Location location = locationFacade
                .getLocationById(request.getLocationId());
        Teacher teacher = teacherFacade
                .getTeacherById(request.getTeacherId());
        Major major;

        try {
            major = majorRepository.save(
                    Major.builder()
                            .name(request.getMajorName())
                            .head(head)
                            .location(location)
                            .teacher(teacher)
                            .build()
            );
        } catch (RuntimeException e) {
            throw AlreadyExistMajorLocationException.EXCEPTION;
        }


        head.changeMajor(major);

        return new PostMajorResponse(major.getId());
    }

}
