package io.github.pickdsm.pick_server_spring.domain.schedule.domain;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import io.github.pickdsm.pick_server_spring.domain.schedule.domain.types.ScheduleName;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity(name = "tbl_schedule")
public class Schedule {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(length = 20)
	@Enumerated(EnumType.STRING)
	private ScheduleName name;

	private LocalDate date;

	private int period;

	@Builder
	public Schedule(ScheduleName name, LocalDate date, int period) {
		this.name = name;
		this.date = date;
		this.period = period;
	}

	public void changeName(ScheduleName name) {
		this.name = name;
	}

	public void changePeriod(int period) {
		this.period = period;
	}

}
