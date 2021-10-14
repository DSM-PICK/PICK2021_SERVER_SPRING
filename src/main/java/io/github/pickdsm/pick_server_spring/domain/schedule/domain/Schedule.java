package io.github.pickdsm.pick_server_spring.domain.schedule.domain;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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
	private String name;

	private LocalDate date;

	@Builder
	public Schedule(String name, LocalDate date) {
		this.name = name;
		this.date = date;
	}

}
