package io.github.pickdsm.pick_server_spring.global.security.jwt;

import java.time.LocalDate;
import java.util.Date;

import io.github.pickdsm.pick_server_spring.domain.teacher.domain.Teacher;
import io.github.pickdsm.pick_server_spring.global.security.AuthDetailsService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class JwtTokenProvider {

	private final AuthDetailsService authDetailsService;
	private final JwtProperties jwtProperties;

	public String generateAccessToken(Teacher teacher) {
		return Jwts.builder()
				.setSubject(teacher.getId())
				.setIssuedAt(new Date())
				.setExpiration(
						new Date(System.currentTimeMillis() + jwtProperties.getAccessExp() * 1000)
				)
				.claim("type", "access_token")
				.claim("role", teacher.getRole().name())
				.signWith(SignatureAlgorithm.HS256, jwtProperties.getSecretKey())
				.compact();
	}

	public String generateRefreshToken(Teacher teacher) {
		return Jwts.builder()
				.setSubject(teacher.getId())
				.setIssuedAt(new Date())
				.setExpiration(
						new Date(System.currentTimeMillis() + jwtProperties.getRefreshExp() * 1000)
				)
				.claim("type", "refresh_token")
				.claim("role", teacher.getRole().name())
				.signWith(SignatureAlgorithm.HS256, jwtProperties.getSecretKey())
				.compact();
	}


}
