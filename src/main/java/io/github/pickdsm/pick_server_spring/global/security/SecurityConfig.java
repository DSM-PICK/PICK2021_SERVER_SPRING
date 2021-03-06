package io.github.pickdsm.pick_server_spring.global.security;

import io.github.pickdsm.pick_server_spring.global.error.GlobalExceptionFilter;
import io.github.pickdsm.pick_server_spring.global.security.jwt.JwtTokenProvider;
import lombok.RequiredArgsConstructor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.cors.CorsUtils;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	private final JwtTokenProvider jwtTokenProvider;
	private final GlobalExceptionFilter globalExceptionFilter;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
				.csrf().disable()
				.formLogin().disable()
				.sessionManagement()
				.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		http
				.authorizeRequests()
				.requestMatchers(CorsUtils::isPreFlightRequest).permitAll()
				.antMatchers(HttpMethod.POST, "/teacher/register").permitAll()
				.antMatchers(HttpMethod.POST, "/teacher/login").permitAll()
				.antMatchers(HttpMethod.PUT, "/teacher/auth").permitAll()
				.antMatchers(HttpMethod.GET, "/teacher/list").permitAll()
				.antMatchers(HttpMethod.POST, "/major").hasRole("ADMIN")
				.anyRequest().authenticated()
				.and().apply(new FilterConfig(jwtTokenProvider, globalExceptionFilter));
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
