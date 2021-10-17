package io.github.pickdsm.pick_server_spring.domain.after_school.domain.repository;

import java.util.List;

import io.github.pickdsm.pick_server_spring.domain.after_school.domain.AfterSchool;

import org.springframework.data.repository.CrudRepository;

public interface AfterSchoolRepository extends CrudRepository<AfterSchool, Long> {
	@Override
	List<AfterSchool> findAll();
}
