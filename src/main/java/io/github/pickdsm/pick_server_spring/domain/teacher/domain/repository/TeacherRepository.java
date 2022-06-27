package io.github.pickdsm.pick_server_spring.domain.teacher.domain.repository;

import io.github.pickdsm.pick_server_spring.domain.location.domain.Location;
import io.github.pickdsm.pick_server_spring.domain.teacher.domain.Teacher;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TeacherRepository extends JpaRepository<Teacher, String> {
    Optional<Teacher> findByLocation(Location location);
}
