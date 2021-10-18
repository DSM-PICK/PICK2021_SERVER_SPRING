package io.github.pickdsm.pick_server_spring.domain.schedule.presentation;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.validation.Valid;

import io.github.pickdsm.pick_server_spring.domain.schedule.domain.types.ScheduleName;
import io.github.pickdsm.pick_server_spring.domain.schedule.presentation.dto.request.ChangeDirectorRequest;
import io.github.pickdsm.pick_server_spring.domain.schedule.presentation.dto.request.ChangeNameRequest;
import io.github.pickdsm.pick_server_spring.domain.schedule.presentation.dto.request.ChangePeriodRequest;
import io.github.pickdsm.pick_server_spring.domain.schedule.presentation.dto.request.CreateDirectorRequest;
import io.github.pickdsm.pick_server_spring.domain.schedule.presentation.dto.request.CreateRequest;
import io.github.pickdsm.pick_server_spring.domain.schedule.presentation.dto.response.ScheduleListResponse;
import io.github.pickdsm.pick_server_spring.domain.schedule.presentation.dto.response.ScheduleNameResponse;
import io.github.pickdsm.pick_server_spring.domain.schedule.service.ChangeDirectorService;
import io.github.pickdsm.pick_server_spring.domain.schedule.service.ChangeScheduleNameService;
import io.github.pickdsm.pick_server_spring.domain.schedule.service.ChangeSchedulePeriodService;
import io.github.pickdsm.pick_server_spring.domain.schedule.service.CreateDirectorService;
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
	private final ChangeScheduleNameService changeScheduleNameService;
	private final ChangeSchedulePeriodService changeSchedulePeriodService;
	private final QuerySchedulesService querySchedulesService;
	private final QueryScheduleService queryScheduleService;
	private final ChangeDirectorService changeDirectorService;
	private final CreateDirectorService createDirectorService;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public void createSchedule(@RequestBody @Valid CreateRequest request) {
		createScheduleService.execute(request);
	}

	@PatchMapping
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void changeScheduleName(@RequestBody @Valid ChangeNameRequest request) {
		changeScheduleNameService.execute(request);
	}

	@PatchMapping("/period")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void changeSchedulePeriod(@RequestBody @Valid ChangePeriodRequest request) {
		changeSchedulePeriodService.execute(request);
	}

	@GetMapping("/list/{year}/{month}")
	public List<ScheduleListResponse> querySchedules(@PathVariable("year") int year,
			@PathVariable("month") int month) {
		return querySchedulesService.execute(year, month);
	}

	@GetMapping("/{date}")
	public ScheduleNameResponse querySchedule(@PathVariable("date") String date) {
		return queryScheduleService
				.execute(LocalDate.parse(date, DateTimeFormatter.ISO_DATE));
	}

	@GetMapping("/name")
	public List<String> queryScheduleName() {
		return Stream.of(ScheduleName.values())
				.map(Enum::name)
				.collect(Collectors.toList());
	}

	@PostMapping("/director")
	@ResponseStatus(HttpStatus.CREATED)
	public void createDirector(@RequestBody @Valid CreateDirectorRequest request) {
		createDirectorService.execute(request);
	}

	@PatchMapping("/director")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void changeDirector(@RequestBody @Valid ChangeDirectorRequest request) {
		changeDirectorService.execute(request);
	}

}
