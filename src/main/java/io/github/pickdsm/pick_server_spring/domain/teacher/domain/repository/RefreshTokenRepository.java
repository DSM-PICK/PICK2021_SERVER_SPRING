package io.github.pickdsm.pick_server_spring.domain.teacher.domain.repository;

import java.util.Optional;

import io.github.pickdsm.pick_server_spring.domain.teacher.domain.RefreshToken;

import org.springframework.data.repository.CrudRepository;

public interface RefreshTokenRepository extends CrudRepository<RefreshToken, String> {
	Optional<RefreshToken> findByToken(String token);

}
