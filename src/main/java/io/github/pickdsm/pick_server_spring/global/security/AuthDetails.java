package io.github.pickdsm.pick_server_spring.global.security;

import java.util.Collection;
import java.util.Collections;

import io.github.pickdsm.pick_server_spring.domain.teacher.domain.Teacher;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Getter
@RequiredArgsConstructor
public class AuthDetails implements UserDetails {

	private final Teacher teacher;

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return Collections.singletonList(
				new SimpleGrantedAuthority(teacher.getRole().name()));
	}

	@Override
	public String getPassword() {
		return teacher.getPassword();
	}

	@Override
	public String getUsername() {
		return teacher.getName();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
