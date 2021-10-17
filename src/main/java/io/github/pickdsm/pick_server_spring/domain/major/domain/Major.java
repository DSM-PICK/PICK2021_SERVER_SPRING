package io.github.pickdsm.pick_server_spring.domain.major.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import io.github.pickdsm.pick_server_spring.domain.location.domain.Location;
import io.github.pickdsm.pick_server_spring.domain.major.exception.NotMajorMemberException;
import io.github.pickdsm.pick_server_spring.domain.student.domain.Student;
import io.github.pickdsm.pick_server_spring.domain.teacher.domain.Teacher;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

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

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "teacher_id")
	private Teacher teacher;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "location_id", unique = true)
	private Location location;

	@OneToMany(fetch = FetchType.LAZY)
	private final Set<Student> members = new HashSet<>();

	public void changeHead(Student head) {
		if(head.getMajor() == null ||
				!head.getMajor().getId().equals(this.id))
			throw new NotMajorMemberException();
		this.head = head;
	}

	@Builder
	public Major(String name, Student head, Teacher teacher, Location location) {
		this.name = name;
		this.head = head;
		this.teacher = teacher;
		this.location = location;
	}

}
