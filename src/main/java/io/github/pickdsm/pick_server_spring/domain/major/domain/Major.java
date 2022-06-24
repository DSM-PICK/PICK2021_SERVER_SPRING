package io.github.pickdsm.pick_server_spring.domain.major.domain;

import io.github.pickdsm.pick_server_spring.domain.location.domain.Location;
import io.github.pickdsm.pick_server_spring.domain.major.exception.NotMajorMemberException;
import io.github.pickdsm.pick_server_spring.domain.student.domain.Student;
import io.github.pickdsm.pick_server_spring.domain.teacher.domain.Teacher;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity(name = "tbl_major")
public class Major {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(length = 20, unique = true)
	private String name;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "head_id", unique = true)
	private Student head;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "teacher_id")
	private Teacher teacher;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "location_id", unique = true)
	private Location location;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "major")
	private final Set<Student> members = new HashSet<>();

	public void changeHead(Student head) {
		if(head.getMajor() == null ||
				!head.getMajor().getId().equals(this.id))
			throw NotMajorMemberException.EXCEPTION;
		this.head = head;
	}

	public void changeName(String name) {
		this.name = name;
	}

	public void changeLocation(Location location) {
		this.location = location;
	}

	public String getHeadName() {
		return this.head.getName();
	}

	public String getLocationName() {
		if(this.location == null)
			return null;
		return this.location.getName();
	}

	public int getLocationFloor() {
		if(this.location == null)
			return 0;
		return this.location.getFloor();
	}

	@Builder
	public Major(String name, Student head, Teacher teacher, Location location) {
		this.name = name;
		this.head = head;
		this.teacher = teacher;
		this.location = location;
	}

}
