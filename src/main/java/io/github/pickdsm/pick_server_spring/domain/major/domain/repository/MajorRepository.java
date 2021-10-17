package io.github.pickdsm.pick_server_spring.domain.major.domain.repository;

import java.util.List;

import io.github.pickdsm.pick_server_spring.domain.major.domain.Major;

import org.springframework.data.repository.CrudRepository;

public interface MajorRepository extends CrudRepository<Major, Long> {
	@Override
	List<Major> findAll();
}
