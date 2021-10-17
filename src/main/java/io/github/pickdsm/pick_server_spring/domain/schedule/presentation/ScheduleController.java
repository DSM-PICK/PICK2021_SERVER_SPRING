package io.github.pickdsm.pick_server_spring.domain.schedule.presentation;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.validation.Valid;

import io.github.pickdsm.pick_server_spring.domain.schedule.presentation.dto.request.ChangeRequest;
import io.github.pickdsm.pick_server_spring.domain.schedule.presentation.dto.request.CreateRequest;
import io.github.pickdsm.pick_server_spring.domain.schedule.presentation.dto.response.ScheduleListResponse;
import io.github.pickdsm.pick_server_spring.domain.schedule.presentation.dto.response.ScheduleNameResponse;
import io.github.pickdsm.pick_server_spring.domain.schedule.service.ChangeScheduleService;
import io.github.pickdsm.pick_server_spring.domain.schedule.service.CreateScheduleService;
import io.github.pickdsm.pick_server_spring.domain.schedule.service.QueryScheduleService;
import io.github.pickdsm.pick_server_spring.domain.schedule.service.QuerySchedulesService;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	private final QuerySchedulesService querySchedulesService;
	private final QueryScheduleService queryScheduleService;

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

	@GetMapping("/list/{month}")
	public List<ScheduleListResponse> querySchedules(@PathVariable("month") int month) {
		return querySchedulesService.execute(month);
	}

	@GetMapping("/{date}")
	public ScheduleNameResponse querySchedule(@PathVariable("date") String date) {
		return queryScheduleService
				.execute(LocalDate.parse(date, DateTimeFormatter.ISO_DATE));
	}

}
