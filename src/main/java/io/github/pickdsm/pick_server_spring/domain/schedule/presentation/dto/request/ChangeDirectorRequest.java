package io.github.pickdsm.pick_server_spring.domain.schedule.presentation.dto.request;

import java.time.LocalDate;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ChangeDirectorRequest {

	private int floor;
	private LocalDate date;
	private String teacherId;

}
