package io.github.pickdsm.pick_server_spring.global.security;

import io.github.pickdsm.pick_server_spring.global.error.GlobalExceptionFilter;
import io.github.pickdsm.pick_server_spring.global.security.jwt.JwtTokenFilter;
import io.github.pickdsm.pick_server_spring.global.security.jwt.JwtTokenProvider;
import lombok.RequiredArgsConstructor;

import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@RequiredArgsConstructor
public class FilterConfig extends SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity> {

	private final JwtTokenProvider jwtTokenProvider;
	private final GlobalExceptionFilter globalExceptionFilter;

	@Override
	public void configure(HttpSecurity builder) {
		JwtTokenFilter jwtTokenFilter = new JwtTokenFilter(jwtTokenProvider);
		builder.addFilterBefore(jwtTokenFilter, UsernamePasswordAuthenticationFilter.class);
		builder.addFilterBefore(globalExceptionFilter, JwtTokenFilter.class);
	}
}
