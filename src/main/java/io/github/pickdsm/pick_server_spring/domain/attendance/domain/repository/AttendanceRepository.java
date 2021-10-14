package io.github.pickdsm.pick_server_spring.domain.attendance.domain.repository;

import io.github.pickdsm.pick_server_spring.domain.attendance.domain.Attendance;

import org.springframework.data.repository.CrudRepository;

public interface AttendanceRepository extends CrudRepository<Attendance, Long> {
}
