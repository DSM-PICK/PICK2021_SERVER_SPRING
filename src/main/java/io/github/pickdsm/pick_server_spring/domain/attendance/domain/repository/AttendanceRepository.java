package io.github.pickdsm.pick_server_spring.domain.attendance.domain.repository;

import io.github.pickdsm.pick_server_spring.domain.attendance.domain.Attendance;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;
import java.util.List;

public interface AttendanceRepository extends CrudRepository<Attendance, Long> {
    @Query("SELECT a FROM tbl_attendance a WHERE a.date = :date AND a.location.floor = :floor")
    List<Attendance> findByFloor(LocalDate date, int floor);
}
