package io.github.pickdsm.pick_server_spring.domain.after_school.domain;

import io.github.pickdsm.pick_server_spring.domain.after_school.domain.types.Day;
import io.github.pickdsm.pick_server_spring.domain.location.domain.Location;
import io.github.pickdsm.pick_server_spring.domain.teacher.domain.Teacher;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"day", "location_id"}))
@Entity(name = "tbl_after_school")
public class AfterSchool {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(length = 20, unique = true)
	private String name;

	@Column(length = 3)
	@Enumerated(EnumType.STRING)
	private Day day;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "teacher_id")
	private Teacher teacher;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "location_id")
	private Location location;

	public void changeName(String name) {
		this.name = name;
	}

	public void changeDay(Day day) {
		this.day = day;
	}

	public void changeTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public void changeLocation(Location location) {
		this.location = location;
	}

	@Builder
	public AfterSchool(String name, Day day, Teacher teacher, Location location) {
		this.name = name;
		this.day = day;
		this.teacher = teacher;
		this.location = location;
	}

}
