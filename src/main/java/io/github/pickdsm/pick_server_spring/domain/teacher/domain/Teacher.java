package io.github.pickdsm.pick_server_spring.domain.teacher.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import io.github.pickdsm.pick_server_spring.domain.location.domain.Location;
import io.github.pickdsm.pick_server_spring.domain.teacher.domain.types.Role;
import lombok.AccessLevel;
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

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "location_id")
	private Location location;

	@Builder
	public Teacher(String id, String name, String password, Role role, Location location) {
		this.id = id;
		this.name = name;
		this.password = password;
		this.role = role;
		this.location = location;
	}

	public void changePassword(String password) {
		this.password = password;
	}

	public void changeName(String name) {
		this.name = name;
	}

}
