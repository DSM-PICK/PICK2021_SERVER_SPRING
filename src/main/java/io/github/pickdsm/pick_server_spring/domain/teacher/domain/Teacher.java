package io.github.pickdsm.pick_server_spring.domain.teacher.domain;

import io.github.pickdsm.pick_server_spring.domain.location.domain.Location;
import io.github.pickdsm.pick_server_spring.domain.teacher.domain.types.Role;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

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

	@Column(length = 12)
	@Enumerated(EnumType.STRING)
	private Role role;

	@ManyToOne(fetch = FetchType.LAZY)
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

	public Long getLocationId() {
		if(location == null)
			return null;
		return location.getId();
	}

	public String getLocationName() {
		if(location == null)
			return null;
		return location.getName();
	}

}
