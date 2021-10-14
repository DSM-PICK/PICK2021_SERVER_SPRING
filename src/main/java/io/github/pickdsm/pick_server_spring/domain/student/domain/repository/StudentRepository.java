package io.github.pickdsm.pick_server_spring.domain.student.domain.repository;

import io.github.pickdsm.pick_server_spring.domain.student.domain.Student;

import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<Student, Long> {
}
