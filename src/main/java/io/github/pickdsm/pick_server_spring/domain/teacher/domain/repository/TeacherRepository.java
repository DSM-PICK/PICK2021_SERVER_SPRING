package io.github.pickdsm.pick_server_spring.domain.teacher.domain.repository;

import io.github.pickdsm.pick_server_spring.domain.teacher.domain.Teacher;

import org.springframework.data.repository.CrudRepository;

public interface TeacherRepository extends CrudRepository<Teacher, String> {
}
