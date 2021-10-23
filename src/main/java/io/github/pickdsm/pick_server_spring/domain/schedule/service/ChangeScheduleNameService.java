package io.github.pickdsm.pick_server_spring.domain.schedule.service;

import javax.transaction.Transactional;

import io.github.pickdsm.pick_server_spring.domain.schedule.domain.Schedule;
import io.github.pickdsm.pick_server_spring.domain.schedule.domain.repository.ScheduleRepository;
import io.github.pickdsm.pick_server_spring.domain.schedule.domain.types.ScheduleName;
import io.github.pickdsm.pick_server_spring.domain.schedule.exception.ScheduleNotFoundException;
import io.github.pickdsm.pick_server_spring.domain.schedule.presentation.dto.request.ChangeNameRequest;
import io.github.pickdsm.pick_server_spring.domain.schedule.utils.EnumUtils;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ChangeScheduleNameService {

	private final ScheduleRepository scheduleRepository;

	@Transactional
	public void execute(ChangeNameRequest request) {
		Schedule schedule = scheduleRepository
				.findByDate(request.getDate())
				.orElseThrow(() -> ScheduleNotFoundException.EXCEPTION);
		ScheduleName name = EnumUtils
				.convertToScheduleName(request.getName());

		schedule.changeName(name);
	}

}
