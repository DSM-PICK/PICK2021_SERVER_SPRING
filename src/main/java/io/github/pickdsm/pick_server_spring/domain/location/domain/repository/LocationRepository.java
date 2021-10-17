package io.github.pickdsm.pick_server_spring.domain.location.domain.repository;

import java.util.Optional;

import io.github.pickdsm.pick_server_spring.domain.location.domain.Location;

import org.springframework.data.repository.CrudRepository;

public interface LocationRepository extends CrudRepository<Location, Long> {
	Optional<Location> findByName(String name);
}
