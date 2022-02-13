package io.github.pickdsm.pick_server_spring.domain.attendance.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import io.github.pickdsm.pick_server_spring.domain.director.domain.Director;
import io.github.pickdsm.pick_server_spring.domain.student.domain.Student;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity(name = "tbl_attendance")
public class Attendance {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private int period;

	@Column(length = 10)
	private String state;

	private String memo;

	private String reason;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "student_id")
	private Student student;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "director_id")
	private Director director;

	@Builder
	public Attendance(int period, String state, String memo,
			String reason, Student student, Director director) {
		this.period = period;
		this.state = state;
		this.memo = memo;
		this.reason = reason;
		this.student = student;
		this.director = director;
	}

}
