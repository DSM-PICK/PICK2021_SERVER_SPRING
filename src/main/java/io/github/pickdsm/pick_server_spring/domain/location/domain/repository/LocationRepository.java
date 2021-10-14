package io.github.pickdsm.pick_server_spring.domain.location.domain.repository;

import io.github.pickdsm.pick_server_spring.domain.location.domain.Location;

import org.springframework.data.repository.CrudRepository;

public interface LocationRepository extends CrudRepository<Location, Long> {
}
