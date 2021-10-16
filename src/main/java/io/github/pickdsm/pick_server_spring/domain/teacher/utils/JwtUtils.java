package io.github.pickdsm.pick_server_spring.domain.teacher.utils;

import java.util.Optional;

import io.github.pickdsm.pick_server_spring.domain.teacher.domain.RefreshToken;
import io.github.pickdsm.pick_server_spring.domain.teacher.domain.Teacher;
import io.github.pickdsm.pick_server_spring.domain.teacher.domain.repository.RefreshTokenRepository;
import io.github.pickdsm.pick_server_spring.domain.teacher.presentation.dto.response.TokenResponse;
import io.github.pickdsm.pick_server_spring.global.security.jwt.JwtTokenProvider;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class JwtUtils {

	private static Long refreshExp;

	private static RefreshTokenRepository refreshTokenRepository;
	private static JwtTokenProvider jwtTokenProvider;

	public JwtUtils(RefreshTokenRepository refreshTokenRepository,
			JwtTokenProvider jwtTokenProvider) {
		JwtUtils.refreshTokenRepository = refreshTokenRepository;
		JwtUtils.jwtTokenProvider = jwtTokenProvider;
	}

	@Value("${jwt.refresh.exp}")
	public void setRefreshExp(Long refreshExp) {
		JwtUtils.refreshExp = refreshExp;
	}

	public static TokenResponse getToken(Teacher teacher) {
		String accessToken = jwtTokenProvider.generateAccessToken(teacher);
		String refreshToken = jwtTokenProvider.generateRefreshToken(teacher);
		refreshTokenRepository.findById(teacher.getId())
				.or(() -> Optional.of(new RefreshToken(teacher.getId(),
						refreshToken, refreshExp)))
				.ifPresent(token -> refreshTokenRepository.save(token.update(refreshToken, refreshExp)));
		return new TokenResponse(accessToken, refreshToken);
	}

}
