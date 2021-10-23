package io.github.pickdsm.pick_server_spring.global.security.jwt;

import java.time.LocalDate;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import io.github.pickdsm.pick_server_spring.domain.teacher.domain.Teacher;
import io.github.pickdsm.pick_server_spring.global.security.AuthDetailsService;
import io.github.pickdsm.pick_server_spring.global.security.exception.ExpiredAccessTokenException;
import io.github.pickdsm.pick_server_spring.global.security.exception.InvalidTokenException;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import lombok.RequiredArgsConstructor;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
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

	public String resolveToken(HttpServletRequest request) {
		String bearer = request.getHeader(jwtProperties.getHeader());
		if(bearer != null && bearer.length() > 7 && bearer.startsWith(jwtProperties.getPrefix())) {
			return bearer.substring(7);
		}
		return null;
	}

	public Authentication authentication(String token) {
		Claims body = getTokenBody(token);
		if(!body.getExpiration().after(new Date()))
			return null;
		UserDetails userDetails = authDetailsService
				.loadUserByUsername(body.getSubject());
		return new UsernamePasswordAuthenticationToken(userDetails, "", userDetails.getAuthorities());
	}

	private Claims getTokenBody(String token) {
		try {
			return Jwts.parser().setSigningKey(jwtProperties.getSecretKey())
					.parseClaimsJws(token).getBody();
		} catch (ExpiredJwtException e) {
			throw new ExpiredAccessTokenException();
		} catch (MalformedJwtException | SignatureException e) {
			throw new InvalidTokenException();
		}
	}

}
