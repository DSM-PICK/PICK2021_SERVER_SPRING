package io.github.pickdsm.pick_server_spring.domain.schedule.service;

import javax.transaction.Transactional;

import io.github.pickdsm.pick_server_spring.domain.schedule.domain.Schedule;
import io.github.pickdsm.pick_server_spring.domain.schedule.domain.repository.ScheduleRepository;
import io.github.pickdsm.pick_server_spring.domain.schedule.exception.ScheduleNotFoundException;
import io.github.pickdsm.pick_server_spring.domain.schedule.presentation.dto.request.ChangePeriodRequest;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ChangeSchedulePeriodService {

	private final ScheduleRepository scheduleRepository;

	@Transactional
	public void execute(ChangePeriodRequest request) {
		Schedule schedule = scheduleRepository
				.findByDate(request.getDate())
				.orElseThrow(ScheduleNotFoundException::new);

		schedule.changePeriod(request.getPeriod());
	}

}
