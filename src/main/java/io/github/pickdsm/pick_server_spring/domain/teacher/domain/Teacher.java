package io.github.pickdsm.pick_server_spring.domain.teacher.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.Id;

import io.github.pickdsm.pick_server_spring.domain.teacher.domain.types.Role;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity(name = "tbl_teacher")
public class Teacher {

	@Id
	@Column(length = 10)
	private String id;

	@Column(nullable = false, length = 5)
	private String name;

	@Column(columnDefinition = "CHAR(60)")
	private String password;

	@Column(length = 7)
	@Enumerated
	private Role role;

	@Builder
	public Teacher(String name, String password, Role role) {
		this.name = name;
		this.password = password;
		this.role = role;
	}

}
