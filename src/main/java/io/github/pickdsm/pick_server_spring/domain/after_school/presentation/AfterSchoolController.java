package io.github.pickdsm.pick_server_spring.domain.after_school.presentation;

import io.github.pickdsm.pick_server_spring.domain.after_school.presentation.dto.request.CreateAfterSchoolRequest;
import io.github.pickdsm.pick_server_spring.domain.after_school.presentation.dto.request.CreateAfterSchoolStudentRequest;
import io.github.pickdsm.pick_server_spring.domain.after_school.presentation.dto.request.RemoveAfterSchoolStudentRequest;
import io.github.pickdsm.pick_server_spring.domain.after_school.presentation.dto.request.UpdateAfterSchoolRequest;
import io.github.pickdsm.pick_server_spring.domain.after_school.presentation.dto.response.AfterSchoolDetailResponse;
import io.github.pickdsm.pick_server_spring.domain.after_school.presentation.dto.response.AfterSchoolResponse;
import io.github.pickdsm.pick_server_spring.domain.after_school.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/after-school")
@RequiredArgsConstructor
public class AfterSchoolController {

	private final QueryAfterSchoolService queryAfterSchoolService;
	private final CreateAfterSchoolService createAfterSchoolService;
	private final UpdateAfterSchoolService updateAfterSchoolService;
	private final RemoveAfterSchoolService removeAfterSchoolService;
	private final CreateAfterSchoolStudentService createAfterSchoolStudentService;
	private final RemoveAfterSchoolStudentService removeAfterSchoolStudentService;
	private final QuerySpecificAfterSchoolService querySpecificAfterSchoolService;

	@GetMapping("/list")
	public List<AfterSchoolResponse> queryAfterSchool() {
		return queryAfterSchoolService.execute();
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public void createAfterSchool(@RequestBody @Valid CreateAfterSchoolRequest request) {
		createAfterSchoolService.execute(request);
	}

	@GetMapping("/{after-school-id}")
	public AfterSchoolDetailResponse querySpecificAfterSchool(@PathVariable("after-school-id") Long afterSchoolId) {
		return querySpecificAfterSchoolService.execute(afterSchoolId);
	}

	@PatchMapping("/{after-school_id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void updateAfterSchool(@PathVariable("after-school_id") Long afterSchoolId,
			@RequestBody @Valid UpdateAfterSchoolRequest request) {
		updateAfterSchoolService.execute(afterSchoolId, request);
	}

	@DeleteMapping("/{after-school_id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void removeAfterSchool(@PathVariable("after-school_id") Long afterSchoolId) {
		removeAfterSchoolService.execute(afterSchoolId);
	}

	@PostMapping("/{after-school_id}/student")
	@ResponseStatus(HttpStatus.CREATED)
	public void createAfterSchoolStudent(@PathVariable("after-school_id") Long afterSchoolId,
			@RequestBody @Valid CreateAfterSchoolStudentRequest request) {
		createAfterSchoolStudentService.execute(afterSchoolId, request);
	}

	@DeleteMapping("/{after-school_id}/student")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void removeAfterSchoolStudent(@PathVariable("after-school_id") Long afterSchoolId,
			@RequestBody @Valid RemoveAfterSchoolStudentRequest request) {
		removeAfterSchoolStudentService.execute(afterSchoolId, request);
	}

}
