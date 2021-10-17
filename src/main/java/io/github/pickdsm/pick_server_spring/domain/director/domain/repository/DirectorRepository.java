package io.github.pickdsm.pick_server_spring.domain.director.domain.repository;

import java.util.List;

import io.github.pickdsm.pick_server_spring.domain.director.domain.Director;
import io.github.pickdsm.pick_server_spring.domain.schedule.domain.Schedule;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface DirectorRepository extends CrudRepository<Director, Long> {
	@Query("select d from tbl_director d join tbl_schedule s on s.id = d.schedule.id")
	List<Director> findBySchedule(Schedule schedule);
}
