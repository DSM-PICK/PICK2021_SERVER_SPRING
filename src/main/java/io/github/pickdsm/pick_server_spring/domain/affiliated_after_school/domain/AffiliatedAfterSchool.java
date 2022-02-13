package io.github.pickdsm.pick_server_spring.domain.affiliated_after_school.domain;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import io.github.pickdsm.pick_server_spring.domain.after_school.domain.AfterSchool;
import io.github.pickdsm.pick_server_spring.domain.student.domain.Student;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity(name = "tbl_affiliated_after_school")
public class AffiliatedAfterSchool {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "student_id")
	private Student student;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "after_school_id")
	private AfterSchool afterSchool;

	@Builder
	public AffiliatedAfterSchool(Student student, AfterSchool afterSchool)  {
		this.student = student;
		this.afterSchool = afterSchool;
	}

}
