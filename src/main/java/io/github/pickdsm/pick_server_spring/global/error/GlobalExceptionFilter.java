package io.github.pickdsm.pick_server_spring.global.error;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import io.github.pickdsm.pick_server_spring.global.error.exception.ErrorCode;
import io.github.pickdsm.pick_server_spring.global.error.exception.PickException;

import org.springframework.web.filter.OncePerRequestFilter;

public class GlobalExceptionFilter extends OncePerRequestFilter {


	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
		try {
			filterChain.doFilter(request, response);
		} catch (PickException e) {
			ErrorCode errorCode = e.getErrorCode();
			ErrorResponse errorResponse =
					new ErrorResponse(errorCode.getStatus(), errorCode.getMessage());
			response.setStatus(errorCode.getStatus());
			response.setContentType("application/json");
			response.getWriter().write(errorResponse.toString());
		}
	}

}
