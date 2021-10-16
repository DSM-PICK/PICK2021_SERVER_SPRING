package io.github.pickdsm.pick_server_spring.domain.teacher.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.TimeToLive;
import org.springframework.data.redis.core.index.Indexed;

@Getter
@AllArgsConstructor
@RedisHash
public class RefreshToken {

	@Id
	private final String id;

	@Indexed
	private String token;

	@TimeToLive
	private Long ttl;

	public RefreshToken update(String token, Long ttl) {
		this.token = token;
		this.ttl = ttl;
		return this;
	}

}
