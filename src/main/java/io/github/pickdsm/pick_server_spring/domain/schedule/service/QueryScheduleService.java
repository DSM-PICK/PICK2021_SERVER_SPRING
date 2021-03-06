package io.github.pickdsm.pick_server_spring.domain.schedule.service;

import java.time.LocalDate;

import io.github.pickdsm.pick_server_spring.domain.schedule.domain.Schedule;
import io.github.pickdsm.pick_server_spring.domain.schedule.domain.repository.ScheduleRepository;
import io.github.pickdsm.pick_server_spring.domain.schedule.exception.ScheduleNotFoundException;
import io.github.pickdsm.pick_server_spring.domain.schedule.presentation.dto.response.ScheduleNameResponse;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class QueryScheduleService {

	private final ScheduleRepository scheduleRepository;

	public ScheduleNameResponse execute(LocalDate date) {
		Schedule schedule = scheduleRepository.findByDate(date)
				.orElseThrow(() -> ScheduleNotFoundException.EXCEPTION);

		return new ScheduleNameResponse(
				schedule.getName().name(),
				schedule.getPeriod()
		);
	}

}
