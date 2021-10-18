package io.github.pickdsm.pick_server_spring.domain.schedule.presentation.dto.response;

import java.time.LocalDate;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ScheduleListResponse {

	private final LocalDate date;
	private final String name;
	private final int period;
	private final List<Director> director;

	@Getter
	@AllArgsConstructor
	public static class Director {
		private final String name;
		private final String teacherId;
		private final int floor;
	}

}
