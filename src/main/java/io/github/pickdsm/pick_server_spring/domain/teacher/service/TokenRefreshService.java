package io.github.pickdsm.pick_server_spring.domain.teacher.service;

import io.github.pickdsm.pick_server_spring.domain.teacher.domain.repository.RefreshTokenRepository;
import io.github.pickdsm.pick_server_spring.domain.teacher.facade.TeacherFacade;
import io.github.pickdsm.pick_server_spring.domain.teacher.presentation.dto.request.TokenRequest;
import io.github.pickdsm.pick_server_spring.domain.teacher.presentation.dto.response.TokenResponse;
import io.github.pickdsm.pick_server_spring.domain.teacher.utils.JwtUtils;
import io.github.pickdsm.pick_server_spring.global.security.exception.ExpiredRefreshTokenException;
import io.github.pickdsm.pick_server_spring.global.security.exception.InvalidTokenException;
import io.github.pickdsm.pick_server_spring.global.security.jwt.JwtTokenProvider;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TokenRefreshService {

	private final TeacherFacade teacherFacade;
	private final JwtTokenProvider jwtTokenProvider;
	private final RefreshTokenRepository refreshTokenRepository;

	public TokenResponse execute(TokenRequest request) {
		if(jwtTokenProvider.validateToken(request.getRefreshToken())) {
			return refreshTokenRepository
					.findByToken(request.getRefreshToken())
					.map(token -> JwtUtils.getToken(teacherFacade.getTeacherById(token.getId())))
					.orElseThrow(ExpiredRefreshTokenException::new);
		} throw new InvalidTokenException();
	}

}
