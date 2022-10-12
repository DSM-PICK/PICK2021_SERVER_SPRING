package io.github.pickdsm.pick_server_spring.domain.teacher.service;

import io.github.pickdsm.pick_server_spring.domain.teacher.domain.Teacher;
import io.github.pickdsm.pick_server_spring.domain.teacher.domain.repository.TeacherRepository;
import io.github.pickdsm.pick_server_spring.domain.teacher.domain.types.Role;
import io.github.pickdsm.pick_server_spring.domain.teacher.exception.AlreadyExistTeacherException;
import io.github.pickdsm.pick_server_spring.domain.teacher.presentation.dto.request.CreateTeacherRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CreateTeacherService {

    private final TeacherRepository teacherRepository;
    private final PasswordEncoder passwordEncoder;
    @Value("${teacher.id}")
    private String id;

    @Value("${teacher.password}")
    private String password;

    public void execute(CreateTeacherRequest request) {
        Teacher lastTeacher = teacherRepository.findTop1ByOrderByIdDesc();
        String teacherId = id + Integer.parseInt(lastTeacher.getId().substring(3)) + 1;

        if (!teacherRepository.existsById(id)) {
            throw AlreadyExistTeacherException.EXCEPTION;
        }

        Teacher teacher = Teacher.builder()
                .id(teacherId)
                .name(request.getName())
                .password(passwordEncoder.encode(password))
                .role(Role.ROLE_DEFAULT)
                .build();
        teacherRepository.save(teacher);
    }
}
