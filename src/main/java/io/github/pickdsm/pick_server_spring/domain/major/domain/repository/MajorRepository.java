package io.github.pickdsm.pick_server_spring.domain.major.domain.repository;

import java.util.List;
import java.util.Optional;

import io.github.pickdsm.pick_server_spring.domain.location.domain.Location;
import io.github.pickdsm.pick_server_spring.domain.major.domain.Major;

import org.springframework.data.repository.CrudRepository;

public interface MajorRepository extends CrudRepository<Major, Long> {
	@Override
	List<Major> findAll();
	Optional<Major> findByLocation(Location location);
	Optional<Major> findByName(String name);
}
