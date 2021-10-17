package io.github.pickdsm.pick_server_spring.domain.schedule.presentation;

import javax.validation.Valid;

import io.github.pickdsm.pick_server_spring.domain.schedule.presentation.dto.request.ChangeRequest;
import io.github.pickdsm.pick_server_spring.domain.schedule.presentation.dto.request.CreateRequest;
import io.github.pickdsm.pick_server_spring.domain.schedule.service.ChangeScheduleService;
import io.github.pickdsm.pick_server_spring.domain.schedule.service.CreateScheduleService;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/schedule")
@RequiredArgsConstructor
public class ScheduleController {

	private final CreateScheduleService createScheduleService;
	private final ChangeScheduleService changeScheduleService;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public void createSchedule(@RequestBody @Valid CreateRequest request) {
		createScheduleService.execute(request);
	}

	@PatchMapping
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void changeSchedule(@RequestBody @Valid ChangeRequest request) {
		changeScheduleService.execute(request);
	}

}
