package io.github.pickdsm.pick_server_spring.domain.teacher.domain.repository;

import io.github.pickdsm.pick_server_spring.domain.teacher.domain.Teacher;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<Teacher, String> {
}
