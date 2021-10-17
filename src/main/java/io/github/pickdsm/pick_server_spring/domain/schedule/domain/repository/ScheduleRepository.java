package io.github.pickdsm.pick_server_spring.domain.schedule.domain.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import io.github.pickdsm.pick_server_spring.domain.schedule.domain.Schedule;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface ScheduleRepository extends CrudRepository<Schedule, Long> {
	Optional<Schedule> findByDate(LocalDate date);

	@Query("SELECT s FROM tbl_schedule s WHERE s.date LIKE CONCAT('%-', :month, '-%')")
	List<Schedule> findByMonth(int month);
}
