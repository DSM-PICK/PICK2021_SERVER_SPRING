package io.github.pickdsm.pick_server_spring.domain.schedule.service;

import javax.transaction.Transactional;

import io.github.pickdsm.pick_server_spring.domain.schedule.domain.Schedule;
import io.github.pickdsm.pick_server_spring.domain.schedule.domain.repository.ScheduleRepository;
import io.github.pickdsm.pick_server_spring.domain.schedule.domain.types.ScheduleName;
import io.github.pickdsm.pick_server_spring.domain.schedule.exception.ScheduleNotFoundException;
import io.github.pickdsm.pick_server_spring.domain.schedule.presentation.dto.request.ChangeRequest;
import io.github.pickdsm.pick_server_spring.global.exception.InvalidEnumValueException;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ChangeScheduleService {

	private final ScheduleRepository scheduleRepository;

	@Transactional
	public void execute(ChangeRequest request) {
		Schedule schedule = scheduleRepository
				.findByDate(request.getDate())
				.orElseThrow(ScheduleNotFoundException::new);
		ScheduleName name;

		try {
			name = ScheduleName.valueOf(request.getName());
		} catch (IllegalArgumentException e) {
			throw new InvalidEnumValueException();
		}

		schedule.changeName(name);
	}

}
