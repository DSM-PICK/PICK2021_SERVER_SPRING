package io.github.pickdsm.pick_server_spring.global.security;

import io.github.pickdsm.pick_server_spring.domain.teacher.domain.Teacher;
import io.github.pickdsm.pick_server_spring.domain.teacher.facade.TeacherFacade;
import lombok.RequiredArgsConstructor;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AuthDetailsService implements UserDetailsService {

	private final TeacherFacade teacherFacade;

	@Override
	public UserDetails loadUserByUsername(String id) throws UsernameNotFoundException {
		Teacher teacher = teacherFacade.getTeacherById(id);
		return new AuthDetails(teacher);
	}

}
