package io.github.pickdsm.pick_server_spring.domain.location.domain.repository;

import java.util.List;
import java.util.Optional;

import io.github.pickdsm.pick_server_spring.domain.location.domain.Location;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface LocationRepository extends CrudRepository<Location, Long> {
	Optional<Location> findByName(String name);
	List<Location> findByFloor(int floor);
	List<Location> findAll();
	@Query("SELECT l FROM tbl_location l WHERE l.name LIKE '_-_'")
	List<Location> findAllClass();
}
