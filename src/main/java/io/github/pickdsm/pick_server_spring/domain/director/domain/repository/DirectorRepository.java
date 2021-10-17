package io.github.pickdsm.pick_server_spring.domain.director.domain.repository;

import java.util.List;
import java.util.Optional;

import io.github.pickdsm.pick_server_spring.domain.director.domain.Director;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface DirectorRepository extends CrudRepository<Director, Long> {
	@Query("select d from tbl_director d where d.schedule.id = :scheduleId")
	List<Director> findBySchedule(Long scheduleId);
	@Query("select d from tbl_director d where d.schedule.id = :scheduleId and d.floor = :floor")
	Optional<Director> findByScheduleAndFloor(Long scheduleId, int floor);
}
