package io.github.pickdsm.pick_server_spring.domain.schedule.service;

import io.github.pickdsm.pick_server_spring.domain.schedule.domain.Schedule;
import io.github.pickdsm.pick_server_spring.domain.schedule.domain.repository.ScheduleRepository;
import io.github.pickdsm.pick_server_spring.domain.schedule.domain.types.ScheduleName;
import io.github.pickdsm.pick_server_spring.domain.schedule.exception.AlreadyExistScheduleException;
import io.github.pickdsm.pick_server_spring.domain.schedule.presentation.dto.request.CreateRequest;
import io.github.pickdsm.pick_server_spring.domain.schedule.utils.EnumUtils;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateScheduleService {

	private final ScheduleRepository scheduleRepository;

	public void execute(CreateRequest request) {
		scheduleRepository
				.findByDate(request.getDate())
				.ifPresent(schedule -> {throw new AlreadyExistScheduleException();});
		ScheduleName name = EnumUtils
				.convertToScheduleName(request.getName());
		scheduleRepository.save(
				Schedule.builder()
				.date(request.getDate())
				.name(name)
				.period(3)
				.build()
		);
	}

}
