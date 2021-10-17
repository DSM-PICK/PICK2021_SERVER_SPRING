package io.github.pickdsm.pick_server_spring.domain.schedule.domain.repository;

import java.time.LocalDate;
import java.util.Optional;

import io.github.pickdsm.pick_server_spring.domain.schedule.domain.Schedule;

import org.springframework.data.repository.CrudRepository;

public interface ScheduleRepository extends CrudRepository<Schedule, Long> {
	Optional<Schedule> findByDate(LocalDate date);
}
