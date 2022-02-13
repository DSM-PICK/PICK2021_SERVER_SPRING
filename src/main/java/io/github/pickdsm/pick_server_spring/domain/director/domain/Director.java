package io.github.pickdsm.pick_server_spring.domain.director.domain;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import io.github.pickdsm.pick_server_spring.domain.schedule.domain.Schedule;
import io.github.pickdsm.pick_server_spring.domain.teacher.domain.Teacher;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(uniqueConstraints = @UniqueConstraint (columnNames = {"schedule_id", "floor"}))
@Entity(name = "tbl_director")
public class Director {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private int floor;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "schedule_id")
	private Schedule schedule;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "teacher_id")
	private Teacher teacher;

	@Builder
	public Director(int floor, Schedule schedule, Teacher teacher) {
		this.floor = floor;
		this.schedule = schedule;
		this.teacher = teacher;
	}

	public void changeTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

}
