package io.github.pickdsm.pick_server_spring.domain.after_school.domain;

import io.github.pickdsm.pick_server_spring.domain.affiliated_after_school.domain.AffiliatedAfterSchool;
import io.github.pickdsm.pick_server_spring.domain.after_school.domain.types.Day;
import io.github.pickdsm.pick_server_spring.domain.location.domain.Location;
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

	@OneToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "teacher_id")
	private Teacher teacher;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "location_id")
	private Location location;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "afterSchool")
	private Set<AffiliatedAfterSchool> affiliatedAfterSchools = new HashSet<>();

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

	public String getTeacherName() {
		if(this.teacher == null)
			return null;
		return this.teacher.getName();
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
	public AfterSchool(String name, Day day, Teacher teacher, Location location) {
		this.name = name;
		this.day = day;
		this.teacher = teacher;
		this.location = location;
	}

}
