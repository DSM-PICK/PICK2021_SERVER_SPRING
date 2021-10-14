package io.github.pickdsm.pick_server_spring.domain.schedule.domain.repository;

import io.github.pickdsm.pick_server_spring.domain.schedule.domain.Schedule;

import org.springframework.data.repository.CrudRepository;

public interface ScheduleRepository extends CrudRepository<Schedule, Long> {
}
